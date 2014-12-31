package com.Daniel.censusapp;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;

public class AllContacts {
	private static AllContacts allContacts;
	
	private Context applicationContext;
	
	private ArrayList<Contact> contactList;
	
	private AllContacts(Context applicationContext)
	{
		this.applicationContext = applicationContext;
		
		contactList = new ArrayList<Contact>();
		
		Contact paulSmith = new Contact();
		paulSmith.setName("Paul Smith");
		paulSmith.setStreetAddress("123 Main st");
		paulSmith.setContacted(true);
		contactList.add(paulSmith);
		
		
		
		Contact sallySmith = new Contact();
		sallySmith.setName("Sally Smith");
		sallySmith.setStreetAddress("124 Main st");
		sallySmith.setContacted(false);
		contactList.add(sallySmith);
		
		
		
		Contact markSmith = new Contact();
		markSmith.setName("Mark Smith");
		markSmith.setStreetAddress("127 Main st");
		markSmith.setContacted(false);
		contactList.add(markSmith);
	}
	
	public static AllContacts get(Context context)
	{
		if (allContacts == null)
		{
			allContacts = new AllContacts(context.getApplicationContext());
		}
		
		return allContacts;
	}
	
	public ArrayList<Contact> getContactList()
	{
		return contactList;
	}
	
	
	public Contact getContact(UUID id)
	{
		for (Contact items : contactList)
		{
			if (items.getIdNumber().equals(id))
			{
				return items;
			}
		}
		return null;
	}
}
