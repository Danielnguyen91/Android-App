package com.Daniel.censusapp;

import java.util.UUID;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class CensusApp extends FragmentActivityBuilder {


	@Override
	protected Fragment createFragment() {
		UUID contactIdNumber = (UUID) getIntent().getSerializableExtra(ContactFragment.CONTACT_ID);
		return new ContactFragment().newContactFragment(contactIdNumber);
	}


	

	

}
