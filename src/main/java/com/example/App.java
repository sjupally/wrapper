package com.example;

import com.example.bean.BookProxy;
import com.example.entity.Book;
import com.google.gson.Gson;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.fixed.FixedWidthFieldLengths;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Srikanth on 5/23/2017.
 */
class App {
    public static void main(String[] args) throws Exception {
        BooksManager manager = new BooksManager();
        List<Book> bookList = manager.getBooks();
        List<String> keyList = new ArrayList<String>();
        keyList.add("title");
        keyList.add("nirc");
        keyList.add("price");
        Map<String, List> keyMap = new HashMap<String, List>();
        /*for (String key: keyList  ){
            List result = processObject(key, bookList);
            keyMap.put(key,result);
        }*/
        App app = new App();
        List<BookProxy> proxyList = new ArrayList<BookProxy>();
        for (Book book : bookList) {
            JSONObject jsonObject = app.procss(keyList, book, new BookProxy());
            Gson gson = new Gson();
            BookProxy bookProxy = gson.fromJson(jsonObject.toString(), BookProxy.class);
            proxyList.add(bookProxy);
        }


        writeIntoFile(keyList, proxyList);

    }

    private JSONObject procss(List<String> keyList, Book book, BookProxy proxy) throws Exception {
        JSONObject jsonObject = new JSONObject();
        for (String key : keyList) {
            Class<?> clazz = book.getClass();
            Object value = null;
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                value = field.get(book);
                jsonObject.put(key, value);
            } catch (NoSuchFieldException e) {
                value = null;
            } catch (IllegalAccessException e) {
                value = null;
            }
        }
        return jsonObject;
    }

    Object instantiate(List<Object> args, String className) throws Exception {
        // Load the class.
        Class<?> clazz = Class.forName(className);
        Field[] fields = clazz.getDeclaredFields();
        for (Object obj : args) {
            for (Field f : fields) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                    Class<?> type = f.getType();

                    if (type.equals(Double.class)) {
                        f.set(clazz, obj); //Set Default value
                    } else if (type.equals(String.class)) {
                        f.set(clazz, obj);
                    }
                    f.setAccessible(false);
                }
            }
        }
        return clazz;
    }

    private static void writeIntoFile(List<String> keyList, List<BookProxy> bookList) throws FileNotFoundException {
        FixedWidthFieldLengths lengths = new FixedWidthFieldLengths(20, 20, 35);
        FixedWidthWriterSettings settings = new FixedWidthWriterSettings(lengths);

        // Any null values will be written as ?
        settings.setNullValue("?");

        // Creates a BeanWriterProcessor that handles annotated fields in the TestBean class.
        settings.setRowWriterProcessor(new BeanWriterProcessor<BookProxy>(BookProxy.class));

        // Sets the file headers so the writer knows the correct order when writing values taken from a TestBean instance
        settings.setHeaders("title", "nirc", "price");

        // Creates a writer with the above settings;
        FixedWidthWriter writer = new FixedWidthWriter(new FileOutputStream(new File("output.txt")), settings);

        // Writes the headers specified in the settings
        writer.writeHeaders();


        for (BookProxy bean:bookList) {
            writer.processRecord(bean);
        }

        writer.close();
    }

    private static List processObject(String key, List objList) {
        List<Object> list = new ArrayList<Object>();
        for (Object obj : objList) {
            Class<?> clazz = obj.getClass();
            Object value = null;
            try {
                Field field = clazz.getDeclaredField(key);
                field.setAccessible(true);
                value = field.get(obj);
            } catch (NoSuchFieldException e) {
                value = null;
            } catch (IllegalAccessException e) {
                value = null;
            }
            list.add(value);
        }
        return list;
    }
}
