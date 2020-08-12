package com.project.fileMerger.util;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.project.fileMerger.dto.MemberRegistrationTransaction;
import com.project.fileMerger.dto.TransactionDetails;
import com.project.fileMerger.dto.TransactionEmployer;
import com.project.fileMerger.dto.TransactionFundForMember;
import com.project.fileMerger.dto.TransactionMembers;

/**
 * @author ashraf_sarhan
 *
 */
public class CsvReader {

	public static MemberRegistrationTransaction readCsvFile(String fileName) {

		File csvFile = new File(fileName).getAbsoluteFile();
		MemberRegistrationTransaction mb = new MemberRegistrationTransaction();
		CsvMapper csvMapper = new CsvMapper();
		try {
			MappingIterator<Map> rows = csvMapper.readerWithSchemaFor(Map.class)
					.with(CsvSchema.emptySchema().withHeader()).readValues(csvFile);
			Map<Object, Map<Object, Map<Object, List<Object>>>> members = toMembersList(rows);

			members.entrySet().forEach(e -> {

				mb.setTransactionIdentifier((String) e.getKey());
				List<TransactionDetails> tdList = new ArrayList<>();
				e.getValue().entrySet().forEach(t -> {
					TransactionDetails td = new TransactionDetails();
					td.setTransactionEmployer((TransactionEmployer) t.getKey());
					t.getValue().entrySet().forEach(m -> {
						td.setTransactionFundForMember((TransactionFundForMember) m.getKey());
						td.setTransactionMembers((ArrayList<TransactionMembers>) (ArrayList<?>) m.getValue());
					});
					tdList.add(td);
				});
				mb.setTransactionDetails(tdList);
			});

		} catch (IOException e) {
			System.out.println("Error reading csv file");
			;
		}
		return mb;
	}

	public static Map<Object, Map<Object, Map<Object, List<Object>>>> toMembersList(MappingIterator<Map> rows) {
		return toStream(rows)
				// group by employer names
				.collect(Collectors.groupingBy(map -> map.get("transactionIdentifier"),
						Collectors.groupingBy(
								map -> new TransactionEmployer((String) map.get("employerNames"),
										(String) map.get("employerABN")),
								Collectors.groupingBy(
										map -> new TransactionFundForMember((String) map.get("fundIdentifier"),
												(String) map.get("fundEmployerIdentifier"), toDate(
														map.get("memberFundRegistrationDate"))),
										Collectors.mapping(map -> Arrays.asList(new TransactionMembers(
												(String) map.get("memberFirstName"), (String) map.get("memberLastName"),
												(String) map.get("memberOtherNames"),
												toDate(map.get("memberDateOfBirth")), (String) map.get("memberGender"),
												(String) map.get("memberAddress"), (String) map.get("memberEmail"),
												toNumber(map.get("memberContactNumber")),
												(String) map.get("memberNumber"), toNumber(map.get("memberTFN")),
												(String) map.get("memberPayrollNumber"),
												(String) map.get("memberEmploymentStatus"))), Collectors.toList())))));

	}

	private static Stream<Map> toStream(MappingIterator<Map> rowIterator) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(rowIterator, Spliterator.ORDERED), false);
	}

	private static int toNumber(Object value) {
		return new BigDecimal(Objects.toString(value, "0")).intValue();
	}

	private static Date toDate(Object value) {
		return new Date((String) value);
	}

}
