package com.project.fileMerger.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class TransactionFundForMember {
	private String fundIdentifier;
	private String fundEmployerIdentifier;
	private Date memberFundRegistrationDate;

	public TransactionFundForMember(String fundIdentifier, String fundEmployerIdentifier, Date memberFundRegistrationDate) {
		super();
		this.fundIdentifier = fundIdentifier;
		this.fundEmployerIdentifier = fundEmployerIdentifier;
		this.memberFundRegistrationDate = memberFundRegistrationDate;
	}

	public TransactionFundForMember() {
	}

	@XmlElement
	public String getFundIdentifier() {
		return fundIdentifier;
	}

	public void setFundIdentifier(String fundIdentifier) {
		this.fundIdentifier = fundIdentifier;
	}

	@XmlElement
	public String getFundEmployerIdentifier() {
		return fundEmployerIdentifier;
	}

	public void setFundEmployerIdentifier(String fundEmployerIdentifier) {
		this.fundEmployerIdentifier = fundEmployerIdentifier;
	}

	@XmlElement
	public Date getMemberFundRegistrationDate() {
		return memberFundRegistrationDate;
	}

	public void setMemberFundRegistrationDate(Date memberFundRegistrationDate) {
		this.memberFundRegistrationDate = memberFundRegistrationDate;
	}

	@Override
	public String toString() {
		return "Member [  fundIdentifier=" + fundIdentifier + ", fundEmployerIdentifier=" + fundEmployerIdentifier
				+ " memberFundRegistrationDate=" + memberFundRegistrationDate + "]";
	}
}
