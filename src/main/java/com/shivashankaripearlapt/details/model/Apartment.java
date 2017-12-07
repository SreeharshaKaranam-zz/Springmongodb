package com.shivashankaripearlapt.details.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apartment")
public class Apartment {

	
	@Id
	private String blockNumber;
	private String primaryMemberName;
	private String secondaryMemberName;
	private String mobileNumber;


	public String getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	public String getPrimaryMemberName() {
		return primaryMemberName;
	}

	public void setPrimaryMemberName(String primaryMemberName) {
		this.primaryMemberName = primaryMemberName;
	}

	public String getSecondaryMemberName() {
		return secondaryMemberName;
	}

	public void setSecondaryMemberName(String secondaryMemberName) {
		this.secondaryMemberName = secondaryMemberName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
