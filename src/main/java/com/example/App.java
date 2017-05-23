package com.example;

import com.example.entity.Book;
import com.univocity.parsers.fixed.FixedWidthFieldLengths;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.core.Predicate;

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
    public static void main(String[] args) throws FileNotFoundException {
        BooksManager manager = new BooksManager();
        List<Book> bookList = manager.getBooks();
        List<String> keyList = new ArrayList<String>();
        keyList.add("title");
        keyList.add("nirc");
        keyList.add("price");
        Map<String, List> keyMap = new HashMap<String, List>();
        for (String key: keyList  ){
            List result = processObject(key, bookList);
            keyMap.put(key,result);
        }
        for (int i = 0; i < bookList.size(); i++) {
            String titleList = (String) keyMap.get("title").get(i);
            String nircList = (String) keyMap.get("nirc").get(i);
            Double priceList = (Double) keyMap.get("price").get(i);
        }


        writeIntoFile(keyMap,bookList);

    }

    private static void writeIntoFile(Map<String, List> keyMap, List<Book> bookList) throws FileNotFoundException {
        ByteArrayOutputStream fixedWidthResult = new ByteArrayOutputStream();

        // CsvWriter (and all other file writers) work with an instance of java.io.Writer
        Writer outputWriter = new OutputStreamWriter(fixedWidthResult);
        FixedWidthFieldLengths lengths = new FixedWidthFieldLengths(20, 20, 35);
        FixedWidthWriterSettings settings = new FixedWidthWriterSettings(lengths);

        // Any null values will be written as ?
        settings.setNullValue("?");

        // Sets the file headers so the writer knows the correct order when writing values taken from a TestBean instance
        settings.setHeaders("amount", "pending", "date", "quantity", "comments");

        // Creates a writer with the above settings;
        FixedWidthWriter writer = new FixedWidthWriter(new FileOutputStream(new File("output.txt")), settings);
        for (int i = 0; i < bookList.size(); i++) {
            writer.writeRow(keyMap.get("title").get(i), keyMap.get("nirc").get(i), keyMap.get("price").get(i));
        }

        writer.close();
    }

    private static List processObject(String key, List objList) {
        List<Object> list = new ArrayList<Object>();
        for (Object obj: objList) {
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
