package com.project.fileMerger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.fileMerger.dto.MemberRegistrationTransaction;
import com.project.fileMerger.util.CsvReader;
import com.project.fileMerger.util.XmlReader;

@SpringBootApplication
public class FileMergerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileMergerApplication.class, args);
		List<MemberRegistrationTransaction> mbList = new ArrayList<>();
		mbList.add(CsvReader.readCsvFile(FileMergerApplication.class.getClassLoader().getResource("sample.csv").getFile())); 
		mbList.add(XmlReader.readXmlFile(FileMergerApplication.class.getClassLoader().getResource("sample.xml").getFile()));
		
		ObjectMapper mapper = new ObjectMapper();
        File file = new File("src/main/resources/memberRegistrationTransaction.json");
        
        try {
            // Serialize Java object info JSON file.
            mapper.writeValue(file, mbList);
        } catch (IOException e) {
            System.out.println("Error creating the json file");
        }
	}

}
