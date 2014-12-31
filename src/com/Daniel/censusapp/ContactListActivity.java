package com.Daniel.censusapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public class ContactListActivity extends FragmentActivityBuilder {

	@Override
	protected Fragment createFragment() {
		
		return new FragmentContactList();
	}
	
	
	

}
