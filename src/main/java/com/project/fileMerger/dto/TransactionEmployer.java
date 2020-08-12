package com.project.fileMerger.dto;

import javax.xml.bind.annotation.XmlElement;

public class TransactionEmployer {
	private String employerNames;
	private String employerABN;

	public TransactionEmployer(String employerNames, String employerABN) {
		super();
		this.employerNames = employerNames;
		this.employerABN = employerABN;
	}

	public TransactionEmployer() {
	}
	
	@XmlElement
	public String getEmployerNames() {
		return employerNames;
	}

	public void setEmployerNames(String employerNames) {
		this.employerNames = employerNames;
	}

	@XmlElement
	public String getEmployerABN() {
		return employerABN;
	}

	public void setEmployerABN(String employerABN) {
		this.employerABN = employerABN;
	}

	@Override
	public String toString() {
		return "Member [ employerNames=" + employerNames + ", employerABN=" + employerABN + "]";
	}
}
