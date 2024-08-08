package com.example.demo;

import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


@SpringBootApplication
@Slf4j
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		try{
			InputStream inputStream = classLoader.getResourceAsStream("sample.csv");
			 if(inputStream == null) return;
			 try{
				 CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
				 String[] reader;
				 while((reader = csvReader.readNext()) != null){
					 log.info(reader.length + " ");
				 }
			 }catch (Exception e){
               log.info(e.getMessage());
			 }

		}catch(Exception e){
			log.info("Error while streaming the csv file !");
		}
	}

}
