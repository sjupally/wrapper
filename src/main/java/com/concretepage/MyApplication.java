package com.concretepage;
import com.concretepage.bean.BookProxy;
import com.concretepage.dao.IBookDAO;
import com.concretepage.dao.IRecordDAO;
import com.concretepage.entity.Author;
import com.concretepage.entity.Book;
import com.concretepage.entity.Record;
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
import java.util.UUID;

@SpringBootApplication
public class MyApplication {
	@Autowired
	private IRecordDAO iRecordDAO;
	@Autowired
	private IBatchExecutorService batchExecutorService;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    }
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			for (int i = 1 ; i < 5; i++) {
				Record record = new Record();
				record.setOrigSysKey("ORIGSYSKEY-"+i);
				record.setTarSysId("DQSP");
				record.setAccountNo("AC386226" + i);
				record.setTransCode("ONO155");
				record.setCrDrInd("0");
				record.setTransAmt(1234.2332);
				record.setBot(2212);
				record.setRef("ADV");
				record.setBrandInd("D");
				record.setInsuffInd("1");
				record.setCaValDate("20170531");
				record.setRef1("ref11111111111111111111");
				record.setRef2("ref22222222222222222222");
				record.setRef3("ref33333333333333333333");
				record.setHoldInd(" ");
				record.setNoSuspenseInd("0");
				record.setAccntNoInd(" ");
				iRecordDAO.add(record);
			}

			batchExecutorService.execute("FROM Record");
		};
	}


}            