package com.project.fileMerger.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MemberRegistrationTransaction {

	private String transactionIdentifier;
	private List<TransactionDetails> transactionDetails;
	
	public MemberRegistrationTransaction() {
		super();
	}

	public MemberRegistrationTransaction(String transactionIdentifier, List<TransactionDetails> transactionDetails) {
		super();
		this.transactionIdentifier = transactionIdentifier;
		this.transactionDetails = transactionDetails;
	}

	@XmlElement
	public String getTransactionIdentifier() {
		return transactionIdentifier;
	}

	public void setTransactionIdentifier(String transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
	}
	
	@XmlElement
	public List<TransactionDetails> getTransactionDetails() {
		return transactionDetails;
	}

	public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}

	@Override
	public String toString() {
	
		return "MemberRegistrationTransaction [transactionIdentifier=" + transactionIdentifier + ", transactionDetails="
				+ transactionDetails + "]";
	}


	
	
	
	
	

}
