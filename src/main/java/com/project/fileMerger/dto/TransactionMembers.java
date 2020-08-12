package com.project.fileMerger.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class TransactionMembers {
	private String memberFirstName;
	private String memberLastName;
	private String memberOtherNames;
	private Date memberDateOfBirth;
	private String memberGender;
	private String memberAddress;
	private String memberEmail;
	private int memberContactNumber;
	private String memberNumber;
	private int memberTFN;
	private String memberPayrollNumber;
	private String memberEmploymentStatus;

	public TransactionMembers(String memberFirstName, String memberLastName, String memberOtherNames,
			Date memberDateOfBirth, String memberGender, String memberAddress, String memberEmail,
			int memberContactNumber, String memberNumber, int memberTFN, String memberPayrollNumber,
			String memberEmploymentStatus) {
		super();
		this.memberFirstName = memberFirstName;
		this.memberLastName = memberLastName;
		this.memberOtherNames = memberOtherNames;
		this.memberDateOfBirth = memberDateOfBirth;
		this.memberGender = memberGender;
		this.memberAddress = memberAddress;
		this.memberEmail = memberEmail;
		this.memberContactNumber = memberContactNumber;
		this.memberNumber = memberNumber;
		this.memberTFN = memberTFN;
		this.memberPayrollNumber = memberPayrollNumber;
		this.memberEmploymentStatus = memberEmploymentStatus;
	}

	public TransactionMembers() {
	}

	@XmlElement
	public String getMemberFirstName() {
		return memberFirstName;
	}

	public void setMemberFirstName(String memberFirstName) {
		this.memberFirstName = memberFirstName;
	}

	@XmlElement
	public String getMemberLastName() {
		return memberLastName;
	}

	public void setMemberLastName(String memberLastName) {
		this.memberLastName = memberLastName;
	}
	
	@XmlElement
	public String getMemberOtherNames() {
		return memberOtherNames;
	}

	public void setMemberOtherNames(String memberOtherNames) {
		this.memberOtherNames = memberOtherNames;
	}

	@XmlElement
	public Date getMemberDateOfBirth() {
		return memberDateOfBirth;
	}

	public void setMemberDateOfBirth(Date memberDateOfBirth) {
		this.memberDateOfBirth = memberDateOfBirth;
	}

	@XmlElement
	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	@XmlElement
	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	@XmlElement
	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	@XmlElement
	public int getMemberContactNumber() {
		return memberContactNumber;
	}

	public void setMemberContactNumber(int memberContactNumber) {
		this.memberContactNumber = memberContactNumber;
	}

	@XmlElement
	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	@XmlElement
	public int getMemberTFN() {
		return memberTFN;
	}

	public void setMemberTFN(int memberTFN) {
		this.memberTFN = memberTFN;
	}

	@XmlElement
	public String getMemberPayrollNumber() {
		return memberPayrollNumber;
	}

	public void setMemberPayrollNumber(String memberPayrollNumber) {
		this.memberPayrollNumber = memberPayrollNumber;
	}

	@XmlElement
	public String getMemberEmploymentStatus() {
		return memberEmploymentStatus;
	}

	public void setMemberEmploymentStatus(String memberEmploymentStatus) {
		this.memberEmploymentStatus = memberEmploymentStatus;
	}

	@Override
	public String toString() {
		return "Member [ memberFirstName=" + memberFirstName + ", memberLastName=" + memberLastName
				+ ", memberOtherNames=" + memberOtherNames + ", memberDateOfBirth=" + memberDateOfBirth
				+ ", memberGender=" + memberGender + ", memberAddress=" + memberAddress + ", memberEmail=" + memberEmail
				+ ", memberContactNumber=" + memberContactNumber + ", memberNumber=" + memberNumber + ", memberTFN="
				+ memberTFN + ", memberPayrollNumber=" + memberPayrollNumber + ", memberEmploymentStatus="
				+ memberEmploymentStatus + "]";
	}

}
