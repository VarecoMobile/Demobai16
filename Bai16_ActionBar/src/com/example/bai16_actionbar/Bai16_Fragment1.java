package com.example.bai16_actionbar;

import com.example.bai16_actionbar.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai16_Fragment1 extends Fragment {
	EditText etText;
	Button btOk;
	TextView tvResult;
	View view;
	String text;
	String TAG = "Huy";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.bai16_fragment1, container, false);
		etText = (EditText) view.findViewById(R.id.etText);
		btOk = (Button) view.findViewById(R.id.btOk);
		tvResult = (TextView) view.findViewById(R.id.tvResult);
		btOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (text == null || text.isEmpty()) {
					text = etText.getText().toString();
				} else {
					text = etText.getText().toString() + "\n" + text;
				}
				etText.setText("");
				Log.d(TAG, "text: " + text);
				Toast.makeText(
						getActivity(),
						"Inputting successfully. \nClick ''Refresh Button'' to update!",
						1000 * 1).show();
			}
		});
		return view;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_refresh:
			Toast.makeText(getActivity(), "Updated successfully!",
					Toast.LENGTH_SHORT).show();
			tvResult.setText(text);
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}
}
