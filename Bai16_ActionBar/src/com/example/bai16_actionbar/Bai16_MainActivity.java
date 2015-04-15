package com.example.bai16_actionbar;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Bai16_MainActivity extends ActionBarActivity implements
		ActionBar.TabListener {
	private Bai16_FragPagerAdapter pagerAdapter;
	private MenuItem searchItem;
	ListView lvList;
	TextView tvResult;
	String text;
	SearchView searchView;
	ActionBar mActionBar;
	ViewPager mPager;
	Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bai16_activity_main);
		mActionBar = getSupportActionBar();
		mActionBar.setIcon(R.drawable.ic_launcher);
		mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME
				| ActionBar.DISPLAY_SHOW_TITLE);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		pagerAdapter = new Bai16_FragPagerAdapter(getSupportFragmentManager(),
				getApplicationContext());
		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(pagerAdapter);
		mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				mActionBar.setSelectedNavigationItem(position);
				spinner.setSelection(position);
			}
		});

		for (int i = 0; i < pagerAdapter.getCount(); i++) {
			mActionBar.addTab(mActionBar.newTab()
					.setText(pagerAdapter.getTitle(i)).setTabListener(this));
		}

		mActionBar.setCustomView(R.layout.bai16_layout_spinner);
		mActionBar.setDisplayShowCustomEnabled(true);

		spinner = (Spinner) findViewById(R.id.spinner);
		final String[] spinner_array = getResources().getStringArray(
				R.array.spinner_arrays);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Toast.makeText(getApplicationContext(),
						"You choose: " + spinner_array[arg2],
						Toast.LENGTH_SHORT).show();
				mActionBar.setSelectedNavigationItem(arg2);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.bai16_main, menu);
		searchItem = menu.findItem(R.id.action_search);
		searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String arg0) {
				Toast.makeText(getApplicationContext(), "Result: " + arg0,
						Toast.LENGTH_LONG).show();
				return false;
			}

			@Override
			public boolean onQueryTextChange(String arg0) {
				return false;
			}
		});

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		case R.id.action_search:
			searchView.setIconified(false);
			return true;
		case R.id.action_favorite:
			Intent intent = new Intent(Bai16_MainActivity.this,
					Bai16_FavoriteActivity.class);
			startActivity(intent);
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.bai16_fragment_main,
					container, false);
			return rootView;
		}
	}

	@Override
	public void onTabReselected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
		mPager.setCurrentItem(arg0.getPosition());
		switch (arg0.getPosition()) {
		case 0:
			mActionBar.setTitle("TAB 1");
			break;
		case 1:
			mActionBar.setTitle("TAB 2");
			break;
		case 2:
			mActionBar.setTitle("TAB 3");
			break;
		default:
			break;
		}
	}

	@Override
	public void onTabUnselected(android.support.v7.app.ActionBar.Tab arg0,
			android.support.v4.app.FragmentTransaction arg1) {
	}
}
