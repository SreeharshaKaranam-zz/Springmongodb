package com.shivashankaripearlapt.details.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Apartment")
public class Apartment {

	private String name;
	private String address;
	@Id
	private int pincode;
	private int noOfFlats;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public int getNoOfFlats() {
		return noOfFlats;
	}

	public void setNoOfFlats(int noOfFlats) {
		this.noOfFlats = noOfFlats;
	}

}
