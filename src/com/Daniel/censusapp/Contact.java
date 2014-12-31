package com.Daniel.censusapp;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import android.util.Log;

public class Contact {
	
	private String name;
	private String phoneNumber;
	
	
	private String streetAddress;
	private String city;
	
	private UUID idNumber;
	private boolean contacted = false;
	
	private Date dateOfBirth;
	public Contact()
	{
		idNumber = UUID.randomUUID();
		dateOfBirth = new Date();
	}
	
	
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		
		Log.e("CENCUS","ADDRESS CHANGE TO " + streetAddress);
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		Log.e("CENCUS","CITY CHANGE TO " + city);
		this.city = city;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		Log.e("CENCUS","NAME CHANGE TO " + name);
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		Log.e("CENCUS","PHONE NUMBER CHANGE TO " + phoneNumber);
		this.phoneNumber = phoneNumber;
	}


	public boolean isContacted() {
		return contacted;
	}


	public void setContacted(boolean contacted) {
		Log.e("CENSUS", "CONTACTED CHANGED TO " + contacted);
		this.contacted = contacted;
	}


	public UUID getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(UUID idNumber) {
			        this.idNumber = idNumber;
		  }


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getDateString()
	{
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(dateOfBirth);
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		
		return month + "/" + day + "/" + year;
	}

	

}
