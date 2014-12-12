package com.example.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobiledev.util.ConstantName;

public class SecondActivity extends Activity implements OnClickListener {
	TextView txtName;
	Button btnEvent, btnGuest;
	final int REQUEST_EVENT_ACTIVITY = 1;
	final int REQUEST_GUEST_ACTIVITY = 2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		txtName = (TextView) findViewById(R.id.textView1);
		btnEvent = (Button) findViewById(R.id.button1);
		btnGuest = (Button) findViewById(R.id.button2);

		txtName.setText(Html.fromHtml("Welcome, <b>"+ConstantName.NAMA+"</b>"));

		btnEvent.setOnClickListener(this);
		btnGuest.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		//event
		case R.id.button1: 
			Intent toEvent = new Intent(this, EventActivity.class);
			startActivityForResult(toEvent, REQUEST_EVENT_ACTIVITY);
			break;
		//guest
		case R.id.button2: 
			Intent toGuest = new Intent(this, GuestActivity.class);
			startActivityForResult(toGuest, REQUEST_GUEST_ACTIVITY);
			break;
		}
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_EVENT_ACTIVITY && resultCode == Activity.RESULT_OK){
			String name = data.getStringExtra("name_of_event");
			btnEvent.setText(name+" event");
		}
		else if(requestCode == REQUEST_GUEST_ACTIVITY && resultCode == Activity.RESULT_OK){
			String name = data.getStringExtra("name_of_biodata");
			String tanggal = data.getStringExtra("birthdate_of_biodata");
			tanggal = tanggal.substring(tanggal.length()-2, tanggal.length());
			int tgl = Integer.parseInt(tanggal);
			if(tgl%2 == 0 && tgl%3 == 0)
				Toast.makeText(getApplicationContext(), "iOS", Toast.LENGTH_SHORT).show();			
			else if(tgl%2 == 0)
				Toast.makeText(getApplicationContext(), "blackberry", Toast.LENGTH_SHORT).show();	
			else if(tgl%3 == 0)	
				Toast.makeText(getApplicationContext(), "android", Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(getApplicationContext(), "feature phone", Toast.LENGTH_SHORT).show();
					
			btnGuest.setText(name+" guest");
		}
	}
}
