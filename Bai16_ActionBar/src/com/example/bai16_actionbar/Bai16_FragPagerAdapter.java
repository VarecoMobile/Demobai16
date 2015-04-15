package com.example.bai16_actionbar;

import java.util.Locale;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Bai16_FragPagerAdapter extends FragmentPagerAdapter {
	final int PAGE_COUNT = 3;
	final int FRAGMENT1 = 0;
	final int FRAGMENT2 = 1;
	final int FRAGMENT3 = 2;
	Context mContext;

	public Bai16_FragPagerAdapter(FragmentManager fm, Context context) {
		super(fm);
		mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		Fragment frag = null;
		switch (position) {
		case FRAGMENT1:
			frag = new Bai16_Fragment1();
			break;
		case FRAGMENT2:
			frag = new Bai16_Fragment2();
			break;
		case FRAGMENT3:
			frag = new Bai16_Fragment3();
			break;
		}
		return frag;
	}

	@Override
	public int getCount() {
		return PAGE_COUNT;
	}
	
	public String getTitle(int position) {
		Locale l = Locale.getDefault();

		switch (position) {
		case 0:
			return "TAB 1";
		case 1:
			return "TAB 2";
		case 2:
			return "TAB 3";
		}
		return null;
	}

}
