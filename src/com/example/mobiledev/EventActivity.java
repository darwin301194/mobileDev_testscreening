package com.example.mobiledev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.moviledev.adapter.EventAdapter;
import com.example.project1.library.SpeedScrollListener;

public class EventActivity extends ActionBarActivity {
	EventAdapter mEvent;
	ListView lvList;
	private SpeedScrollListener listener;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		listener = new SpeedScrollListener();
		lvList = (ListView) findViewById(R.id.listView1);
		mEvent = new EventAdapter(this, listener);
		lvList.setAdapter(mEvent);
		lvList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent returnIntent = new Intent();
				returnIntent.putExtra("name_of_event", mEvent.getData(position)); 
				setResult(EventActivity.this.RESULT_OK,returnIntent);     
				finish();
				
			}
		});
	}
}
