package com.concretepage;
import com.concretepage.bean.BookProxy;
import com.concretepage.dao.IBookDAO;
import com.concretepage.entity.Author;
import com.concretepage.entity.Book;
import com.concretepage.model.FileConfiguration;
import com.concretepage.model.FieldDTO;
import com.concretepage.service.IBatchExecutorService;
import com.google.gson.Gson;
import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.fixed.FixedWidthFields;
import com.univocity.parsers.fixed.FixedWidthWriter;
import com.univocity.parsers.fixed.FixedWidthWriterSettings;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MyApplication {
	@Autowired
	private IBookDAO bookDAO;
	@Autowired
	private IBatchExecutorService batchExecutorService;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			for (int i = 1; i < 100; i++) {
				Book newBook = new Book();
				newBook.setTitle("Hibernate12"+i);
				newBook.setNirc("652ISFHA"+i);
				newBook.setPrice(1.5*i);
				newBook.setDescription("Simplified Data Persistence with Hibernate and JPA");
				newBook.setPublishedDate(new Date());
				Author author = new Author();
				author.setName("Author_"+i);
				author.setEmail("author_"+i+"@gmail.com");
				newBook.setAuthor(author);
				bookDAO.addBook(newBook);
			}
			batchExecutorService.execute("FROM Book");
		};
	}


}            