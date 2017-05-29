package com.concretepage.service;

import com.concretepage.bean.BookProxy;
import com.concretepage.dao.IBookDAO;
import com.concretepage.entity.Book;
import com.concretepage.model.FieldDTO;
import com.concretepage.model.FileConfiguration;
import com.google.gson.Gson;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Srikanth on 5/26/2017.
 */
@Component
public class BatchExecutorService implements IBatchExecutorService{
    @Autowired
    private IBookDAO bookDAO;
    @Autowired
    private FileConfiguration fileConfiguration;

    @Override
    public void execute(String sqlQuery) throws Exception {
        List<Book> list = bookDAO.getAllBooks(sqlQuery);
        List<BookProxy> proxyList = new ArrayList<BookProxy>();
        /*for (Book book : list) {
            JSONObject jsonObject = procss(fileConfiguration.getFieldList(), book, new BookProxy());
            Gson gson = new Gson();
            BookProxy bookProxy = gson.fromJson(jsonObject.toString(), BookProxy.class);
            proxyList.add(bookProxy);
        }*/
        writeIntoFile(fileConfiguration, list);
    }

    private JSONObject procss(List<FieldDTO> keyList, Book book, BookProxy proxy) throws Exception {
        JSONObject jsonObject = new JSONObject();
        for (FieldDTO fieldDTO : keyList) {
            String key = fieldDTO.getName();
            Class<?> clazz = book.getClass();
            Object value = null;
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                if(fieldDTO.getType().equalsIgnoreCase("Object")){
                    Field subFiled = field.getClass().getDeclaredField(fieldDTO.getSubType());
                    subFiled.setAccessible(true);
                    value = subFiled.get(fieldDTO.getSubType());
                } else {
                    value = field.get(book);
                }
                jsonObject.put(key, value);
            } catch (NoSuchFieldException e) {
                value = null;
            } catch (IllegalAccessException e) {
                value = null;
            }
        }
        return jsonObject;
    }

    private void writeIntoFile(FileConfiguration fileConfiguration, List<Book> bookList) throws FileNotFoundException {
        //int[] fieldLengths = {0, 0, 0,0};
        //String[] fields = {"title", "nirc", "price","name"};
        FixedWidthFields fixedWidthFields = new FixedWidthFields(Book.class);
        FixedWidthWriterSettings settings = new FixedWidthWriterSettings(fixedWidthFields);
        settings.setNullValue("?");
        settings.setRowWriterProcessor(new BeanWriterProcessor<Book>(Book.class));
        settings.setHeaders("title", "nirc", "price","name");
        FixedWidthWriter writer = new FixedWidthWriter(new FileOutputStream(new File("data.txt")), settings);
        writer.writeHeaders();
        for (Book bean:bookList) {
            writer.processRecord(bean);
        }
        writer.close();
    }
}
