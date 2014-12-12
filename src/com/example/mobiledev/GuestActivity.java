package com.example.mobiledev;


import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobiledev.datamodel.Biodata;
import com.example.moviledev.adapter.GuestAdapter;

public class GuestActivity extends ActionBarActivity{
	GridView gvData;
	ArrayList<Biodata> arrayList;	
	GuestAdapter mGuest;
	ProgressDialog pDialog;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guest_activity);
		
		gvData = (GridView) findViewById(R.id.gridView1);
		arrayList = new ArrayList<Biodata>();
		mGuest = new GuestAdapter(this, arrayList);
		gvData.setAdapter(mGuest);
		gvData.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent returnIntent = new Intent();
				returnIntent.putExtra("name_of_biodata", arrayList.get(position).getNama()); 
				returnIntent.putExtra("birthdate_of_biodata", arrayList.get(position).getTanggal());
				setResult(GuestActivity.this.RESULT_OK,returnIntent);     
				finish();
				
			}
		});
		new getBiodata().execute();
		
		pDialog = new ProgressDialog(GuestActivity.this);
		pDialog.setMessage("Processing...");
		pDialog.show();
		
	}
	
	private class getBiodata extends AsyncTask<Void, Void, Boolean>{

		@Override
		protected Boolean doInBackground(Void... params) {
			JsonArrayRequest request = new JsonArrayRequest("http://dry-sierra-6832.herokuapp.com/api/people"
					, new Listener<JSONArray>() {

						@Override
						public void onResponse(JSONArray response) {

							pDialog.dismiss();
							for(int i = 0 ; i < response.length() ; i++){
								try {
									JSONObject obj = response.getJSONObject(i);
									Biodata bio = new Biodata();
									bio.setId(obj.getString("id"));
									bio.setNama(obj.getString("name"));
									bio.setTanggal(obj.getString("birthdate"));
									
									arrayList.add(bio);
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							mGuest.notifyDataSetChanged();
							//System.out.println("BERHASIL");
						}
			}, new ErrorListener() {

				@Override
				public void onErrorResponse(VolleyError error) {

					pDialog.dismiss();
					Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
					//System.out.println("GAGAL");
					error.printStackTrace();
				}
			});

			int socketTimeout = 30000;
			RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
			request.setRetryPolicy(policy);
			Volley.newRequestQueue(GuestActivity.this).add(request);

			return true;
		}
		
	}
	
	
}
