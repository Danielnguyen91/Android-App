package com.Daniel.censusapp;

import java.util.Date;
import java.util.UUID;
import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.CompoundButton.OnCheckedChangeListener;




public class ContactFragment extends Fragment {

	public static final String CONTACT_ID = "com.Daniel.censusapp.contact_id";
	private Contact contact;
	private EditText contactNameEditText;
	private EditText contactStreetEditText;
	private EditText contactCityEditText;
	private EditText contactPhoneEditText;
	
	private CheckBox contactCheckBox;
	
	private static final String DATE_OF_BIRTH = "Date of Birth";
	
	private EditText contactBirthdayEditText;
	
	private static final int REQUEST_DATE = 0;
	
	public static ContactFragment newContactFragment(UUID contactID)
	{
		Bundle passedData = new Bundle();
		
		passedData.putSerializable(CONTACT_ID, contactID);
		
		ContactFragment contactFragment = new ContactFragment();
		contactFragment.setArguments(passedData);
		
		return contactFragment;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		UUID contactId = (UUID) getArguments().getSerializable(CONTACT_ID);
		
		contact = AllContacts.get(getActivity()).getContact(contactId);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View theView = inflater.inflate(R.layout.fragment_contact, container,false);
		
		contactNameEditText = (EditText) theView.findViewById(R.id.contactNameEditText);
		
		contactStreetEditText = (EditText) theView.findViewById(R.id.contactStreetEditText);
		
		contactCityEditText = (EditText) theView.findViewById(R.id.contactCityEditText);
		
		contactPhoneEditText = (EditText) theView.findViewById(R.id.contactPhoneEditText);
		
		contactCheckBox = (CheckBox) theView.findViewById(R.id.contactCheckBox);
	
		TextWatcher editTextWatcher = new TextWatcher()
		{
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				Log.e("TEXT WAS CHANGED", arg0.toString());
				if (contactNameEditText.hasFocus() == true)
				{
					contact.setName(arg0.toString());
				}
				else if(contactStreetEditText.hasFocus() == true)
				{
					contact.setStreetAddress(arg0.toString());
				}
				else if (contactCityEditText.hasFocus() == true)
				{
					contact.setCity(arg0.toString());
				}
				else if (contactPhoneEditText.hasFocus() == true)
				{
					contact.setPhoneNumber(arg0.toString());
				}
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

		
		};
		
		
	
		
		contactNameEditText.addTextChangedListener(editTextWatcher);
		contactStreetEditText.addTextChangedListener(editTextWatcher);
		contactCityEditText.addTextChangedListener(editTextWatcher);
		contactPhoneEditText.addTextChangedListener(editTextWatcher);
		
		
		contactCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				contact.setContacted(arg1);
			}
			
		});
		
		contactBirthdayEditText = (EditText)theView.findViewById(R.id.contactBirthdayEditText);
		
		contactBirthdayEditText.setText(contact.getDateString());
		
		contactBirthdayEditText.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragManager = getActivity().getSupportFragmentManager();
				
				DateDialogFragment dateDialog = DateDialogFragment.newInstance(contact.getDateOfBirth());
				
				dateDialog.setTargetFragment(ContactFragment.this,REQUEST_DATE);
				
				dateDialog.show(fragManager, DATE_OF_BIRTH);
			}
			
		});
		
		contactNameEditText.setText(contact.getName());
		contactStreetEditText.setText(contact.getStreetAddress());
	    contactCityEditText.setText(contact.getCity());
		contactPhoneEditText.setText(contact.getPhoneNumber());
		contactCheckBox.setChecked(contact.isContacted());
		
		
		
		return theView;
	}
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if(resultCode != Activity.RESULT_OK) return;
		
		if (requestCode == REQUEST_DATE)
		{
			Date birthDate = (Date) data.getSerializableExtra(DateDialogFragment.CONTACT_BIRTHDAY);
			
			contact.setDateOfBirth(birthDate);
			
			contactBirthdayEditText.setText(contact.getDateString());
			
		}
	}

	
	
}
