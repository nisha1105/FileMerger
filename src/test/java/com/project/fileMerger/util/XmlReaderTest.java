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
import com.project.fileMerger.dto.TransactionMembers;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class XmlReaderTest {

	MemberRegistrationTransaction memberRegistrationTransaction = new MemberRegistrationTransaction();

	@BeforeEach
	protected void setUp() throws Exception {
		memberRegistrationTransaction = XmlReader
				.readXmlFile(FileMergerApplication.class.getClassLoader().getResource("sample.xml").getFile());
	}

	@Test
	public void XMlReadertest() throws Exception {
		MemberRegistrationTransactionValidator();
		TransactionMembersValidator();
		TransactionFundForMemberValidator();
		TransactionEmployerValidator();
		TransactionDetailsValidator();
	}

	private void MemberRegistrationTransactionValidator() throws Exception {
		assertThat(Integer.parseInt(memberRegistrationTransaction.getTransactionIdentifier()), equalTo(2));
		assertThat(memberRegistrationTransaction.getTransactionDetails().size(), equalTo(1));
	}

	private void TransactionMembersValidator() {
		assertThat(memberRegistrationTransaction.getTransactionDetails().get(0).getTransactionMembers().size(),
				equalTo(1));
		TransactionMembers transactionMembers = memberRegistrationTransaction.getTransactionDetails().get(0)
				.getTransactionMembers().get(0);
		assertThat(transactionMembers.getMemberFirstName(), equalTo("John"));
		assertThat(transactionMembers.getMemberLastName(), equalTo("Smith"));
		assertThat(transactionMembers.getMemberOtherNames(), equalTo(""));
		assertThat(transactionMembers.getMemberGender(), equalTo("M"));
		assertThat(transactionMembers.getMemberAddress(), equalTo("12 Alcott Street Sydney NSW 2000"));
		assertThat(transactionMembers.getMemberEmail(), equalTo("jsmith@email.com"));
		assertThat(transactionMembers.getMemberContactNumber(), equalTo(401234567));
		assertThat(transactionMembers.getMemberNumber(), equalTo("M12345"));
		assertThat(transactionMembers.getMemberTFN(), equalTo(123456782));
		assertThat(transactionMembers.getMemberPayrollNumber(), equalTo("P12345"));
		assertThat(transactionMembers.getMemberEmploymentStatus(), equalTo("Permanent"));
		assertThat(transactionMembers.toString(), equalTo(
				"Member [ memberFirstName=John, memberLastName=Smith, memberOtherNames=, memberDateOfBirth=Sun Nov 28 00:00:00 AEDT 1976, memberGender=M, memberAddress=12 Alcott Street Sydney NSW 2000, memberEmail=jsmith@email.com, memberContactNumber=401234567, memberNumber=M12345, memberTFN=123456782, memberPayrollNumber=P12345, memberEmploymentStatus=Permanent]"));
	}

	private void TransactionFundForMemberValidator() {
		TransactionFundForMember transactionFundForMembers = memberRegistrationTransaction.getTransactionDetails()
				.get(0).getTransactionFundForMember();
		assertThat(transactionFundForMembers.getFundIdentifier(), equalTo("FUND123"));
		assertThat(transactionFundForMembers.getFundEmployerIdentifier(), equalTo("FEID1"));
	}

	private void TransactionEmployerValidator() {
		TransactionEmployer transactionEmployer = memberRegistrationTransaction.getTransactionDetails().get(0)
				.getTransactionEmployer();
		assertThat(transactionEmployer.getEmployerNames(), equalTo("ACME Inc"));
		assertThat(transactionEmployer.getEmployerABN(), equalTo("55 794 738 187"));
	}

	private void TransactionDetailsValidator() {
		TransactionDetails transactionDetails = memberRegistrationTransaction.getTransactionDetails().get(0);
		assertThat(transactionDetails.getTransactionMembers().size(), equalTo(1));
	}

}
