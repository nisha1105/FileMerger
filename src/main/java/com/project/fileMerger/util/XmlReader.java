package com.project.fileMerger.util;

import java.io.File;

import javax.xml.bind.JAXBContext;

import com.project.fileMerger.dto.MemberRegistrationTransaction;

public class XmlReader {

	public static MemberRegistrationTransaction readXmlFile(String fileName) {

		MemberRegistrationTransaction memberRegistrationTransaction = new MemberRegistrationTransaction();
		try {
			File inputFile = new File(fileName);
			// Create JAXB context to specify the type of pojo
			JAXBContext jaxbContext = JAXBContext.newInstance(MemberRegistrationTransaction.class);

			// Parse the file and map to the pojo
			memberRegistrationTransaction = (MemberRegistrationTransaction) jaxbContext
					.createUnmarshaller().unmarshal(inputFile);

		} catch (Exception e) {
			System.out.println("Error parsing the XML File ");
		}
		return memberRegistrationTransaction;
	}
}
