package com.project.fileMerger.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.fileMerger.FileMergerApplication;
import com.project.fileMerger.dto.MemberRegistrationTransaction;
import com.project.fileMerger.dto.TransactionDetails;
import com.project.fileMerger.dto.TransactionEmployer;
import com.project.fileMerger.dto.TransactionFundForMember;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CsvReaderTest {

	MemberRegistrationTransaction memberRegistrationTransaction = new MemberRegistrationTransaction();

	@BeforeEach
	protected void setUp() throws Exception {
		memberRegistrationTransaction = CsvReader
				.readCsvFile(FileMergerApplication.class.getClassLoader().getResource("sample.csv").getFile());
	}

	@Test
	public void CSVReadertest() throws Exception {
		MemberRegistrationTransactionValidator();
		TransactionFundForMemberValidator();
		TransactionEmployerValidator();
		TransactionDetailsValidator();
	}

	private void MemberRegistrationTransactionValidator() throws Exception {
		assertThat(Integer.parseInt(memberRegistrationTransaction.getTransactionIdentifier()), equalTo(1));
		assertThat(memberRegistrationTransaction.getTransactionDetails().size(), equalTo(1));
		assertThat(memberRegistrationTransaction.toString(), equalTo(
				"MemberRegistrationTransaction [transactionIdentifier=1, transactionDetails=[TransactionDetails [transactionEmployer=Member [ employerNames=ACME Inc, employerABN=55 794 738 187], transactionFundForMember=Member [  fundIdentifier=FUND123, fundEmployerIdentifier=FEID1 memberFundRegistrationDate=Mon Sep 10 00:00:00 AEST 2018], transactionMembers=[[Member [ memberFirstName=John, memberLastName=Smith, memberOtherNames=, memberDateOfBirth=Tue Nov 12 00:00:00 AEDT 1991, memberGender=M, memberAddress=12 Alcott Street Sydney NSW 2000, memberEmail=jsmith@email.com, memberContactNumber=401234567, memberNumber=M12345, memberTFN=123456782, memberPayrollNumber=P12345, memberEmploymentStatus=Permanent]]]]]]"));
	}

	private void TransactionFundForMemberValidator() {
		TransactionFundForMember transactionFundForMembers = memberRegistrationTransaction.getTransactionDetails()
				.get(0).getTransactionFundForMember();
		assertThat(transactionFundForMembers.getFundIdentifier(), equalTo("FUND123"));
		assertThat(transactionFundForMembers.getFundEmployerIdentifier(), equalTo("FEID1"));
		assertThat(transactionFundForMembers.toString(), equalTo(
				"Member [  fundIdentifier=FUND123, fundEmployerIdentifier=FEID1 memberFundRegistrationDate=Mon Sep 10 00:00:00 AEST 2018]"));
	}

	private void TransactionEmployerValidator() {
		TransactionEmployer transactionEmployer = memberRegistrationTransaction.getTransactionDetails().get(0)
				.getTransactionEmployer();
		assertThat(transactionEmployer.getEmployerNames(), equalTo("ACME Inc"));
		assertThat(transactionEmployer.getEmployerABN(), equalTo("55 794 738 187"));
		assertThat(transactionEmployer.toString(),
				equalTo("Member [ employerNames=ACME Inc, employerABN=55 794 738 187]"));
	}

	private void TransactionDetailsValidator() {
		TransactionDetails transactionDetails = memberRegistrationTransaction.getTransactionDetails().get(0);
		assertThat(transactionDetails.getTransactionMembers().size(), equalTo(1));
		assertThat(transactionDetails.toString(), equalTo(
				"TransactionDetails [transactionEmployer=Member [ employerNames=ACME Inc, employerABN=55 794 738 187], transactionFundForMember=Member [  fundIdentifier=FUND123, fundEmployerIdentifier=FEID1 memberFundRegistrationDate=Mon Sep 10 00:00:00 AEST 2018], transactionMembers=[[Member [ memberFirstName=John, memberLastName=Smith, memberOtherNames=, memberDateOfBirth=Tue Nov 12 00:00:00 AEDT 1991, memberGender=M, memberAddress=12 Alcott Street Sydney NSW 2000, memberEmail=jsmith@email.com, memberContactNumber=401234567, memberNumber=M12345, memberTFN=123456782, memberPayrollNumber=P12345, memberEmploymentStatus=Permanent]]]]"));
	}

}