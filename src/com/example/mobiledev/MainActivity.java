package com.example.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mobiledev.util.ConstantName;

public class MainActivity extends Activity implements OnClickListener{
	EditText edtName;
	ImageView imgNext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edtName = (EditText) findViewById(R.id.editText1);
		imgNext = (ImageView) findViewById(R.id.imageView2);
		
		imgNext.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.imageView2){
			ConstantName.NAMA = edtName.getText().toString().trim();
			if(ConstantName.NAMA.equals(""))
				Toast.makeText(getApplicationContext(), "Please Insert Your Name", Toast.LENGTH_SHORT).show();
			else{
				Intent i = new Intent(this, SecondActivity.class);
				startActivity(i);
			}
		}
	}
}
