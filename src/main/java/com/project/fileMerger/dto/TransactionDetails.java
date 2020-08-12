package com.project.fileMerger.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class TransactionDetails {

	private TransactionEmployer transactionEmployer;
	private TransactionFundForMember transactionFundForMember;
	private List<TransactionMembers> transactionMembers;
	
	public TransactionDetails() {
		super();
	}

	public TransactionDetails(TransactionEmployer transactionEmployer,
			TransactionFundForMember transactionFundForMember, List<TransactionMembers> transactionMembers) {
		super();
		this.transactionEmployer = transactionEmployer;
		this.transactionFundForMember = transactionFundForMember;
		this.transactionMembers = transactionMembers;
	}
	
	@XmlElement
	public TransactionEmployer getTransactionEmployer() {
		return transactionEmployer;
	}
	public void setTransactionEmployer(TransactionEmployer transactionEmployer) {
		this.transactionEmployer = transactionEmployer;
	}
	
	@XmlElement
	public TransactionFundForMember getTransactionFundForMember() {
		return transactionFundForMember;
	}
	public void setTransactionFundForMember(TransactionFundForMember transactionFundForMember) {
		this.transactionFundForMember = transactionFundForMember;
	}
	
	@XmlElement
	public List<TransactionMembers> getTransactionMembers() {
		return transactionMembers;
	}
	public void setTransactionMembers(List<TransactionMembers> transactionMembers) {
		this.transactionMembers = transactionMembers;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transactionEmployer=" + transactionEmployer.toString() + ", transactionFundForMember="
				+ transactionFundForMember.toString() + ", transactionMembers=" + transactionMembers + "]";
	}	
	
	
	
}
