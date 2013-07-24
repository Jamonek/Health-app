package com.jamonek.healthapp;

import android.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

// Quick edit

public class MainActivity extends FragmentActivity implements
		ActionBar.OnNavigationListener {
	PersonLogin person = new PersonLogin();
	/**
	 * The serialization (saved instance state) Bundle key representing the
	 * current dropdown position.
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	public final static String TYPE_EXTRA="apt.tutorial._ID";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		// Set up the dropdown list navigation in the action bar.
		actionBar.setListNavigationCallbacks(
		// Specify a SpinnerAdapter to populate the dropdown list.
				new ArrayAdapter<String>(actionBar.getThemedContext(),
						android.R.layout.simple_list_item_1,
						android.R.id.text1, new String[] {
								getString(R.string.title_section1),
								getString(R.string.title_section2),
								getString(R.string.title_section3), }), this);
		Button button1 = (Button)findViewById(R.id.twitter);
		button1.setOnClickListener(onTwitter);
		Button button2 = (Button)findViewById(R.id.facebook);
		button2.setOnClickListener(onFacebook);
		Button button3 = (Button)findViewById(R.id.account);
		button3.setOnClickListener(onAccount);
	}
	private View.OnClickListener onTwitter=new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			person.setType("Twitter");
			Intent i = new Intent(MainActivity.this, LoginFormActivity.class);
			i.putExtra(TYPE_EXTRA, person.getType());
			startActivity(i);	
		}
	};
	private View.OnClickListener onFacebook=new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			person.setType("Facebook");
			Intent i = new Intent(MainActivity.this, LoginFormActivity.class);
			i.putExtra(TYPE_EXTRA, person.getType());
			startActivity(i);
		}
	};
	private View.OnClickListener onAccount=new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			person.setType("Account");
			Intent i = new Intent(MainActivity.this, LoginFormActivity.class);
			i.putExtra(TYPE_EXTRA, person.getType());
			startActivity(i);
		}
	};

	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		// Restore the previously serialized current dropdown position.
		if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			getActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// Serialize the current dropdown position.
		outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar()
				.getSelectedNavigationIndex());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		// When the given dropdown item is selected, show its contents in the
		// container view.
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
		fragment.setArguments(args);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, fragment).commit();
		return true;
	}

	/**
	 * A dummy fragment representing a section of the app, but that simply
	 * displays dummy text.
	 */
	public static class DummySectionFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main_dummy,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(Integer.toString(getArguments().getInt(
					ARG_SECTION_NUMBER)));
			return rootView;
		}
	}

}
