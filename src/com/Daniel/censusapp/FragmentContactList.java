package com.Daniel.censusapp;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentContactList extends ListFragment {
	private ArrayList<Contact> contactList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		getActivity().setTitle(R.string.fragment_contact_list_title);
		
		contactList = AllContacts.get(getActivity()).getContactList();
		
		ContactAdapter contactAdapter = new ContactAdapter(contactList);
		
		setListAdapter(contactAdapter);
		
		
	}
	
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		
		Log.e("CENSUS APP", "LIST ITEM CLICKED");
		
		Contact clickedContact = ((ContactAdapter) getListAdapter()).getItem(position);
		
		Intent newIntent = new Intent(getActivity(), ContactViewPager.class);
		
		newIntent.putExtra(ContactFragment.CONTACT_ID, clickedContact.getIdNumber());
		
		//startActivity(newIntent);
		startActivityForResult(newIntent,0);
	}
	
	


	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		((ContactAdapter) getListAdapter()).notifyDataSetChanged();
	}




	private class ContactAdapter extends ArrayAdapter<Contact>
	{
		public ContactAdapter(ArrayList<Contact> contacts)
		{
			super(getActivity(), android.R.layout.simple_list_item_1,contacts);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			if(convertView == null)
			{
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_contacts,null);
			}
			
			Contact theContact = getItem(position);
			
			TextView contactNameTextView = (TextView) convertView.findViewById(R.id.contactName);
			
			contactNameTextView.setText(theContact.getName());
			
			TextView contactStreetTextView = (TextView) convertView.findViewById(R.id.contactStreet);
			
			contactStreetTextView.setText(theContact.getStreetAddress());
			
			CheckBox contactedCheckBox = (CheckBox) convertView.findViewById(R.id.contacted_check_box);
			
			contactedCheckBox.setChecked(theContact.isContacted());
			
			return convertView;
		}
	}
	
}
