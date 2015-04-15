package com.example.bai16_actionbar;

import com.example.bai16_actionbar.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class Bai16_FavoriteActivity extends ActionBarActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bai16_favorite_layout);
		getSupportActionBar().setTitle("Favorite");
	}

}
