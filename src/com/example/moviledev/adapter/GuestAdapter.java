package com.example.moviledev.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mobiledev.R;
import com.example.mobiledev.datamodel.Biodata;

public class GuestAdapter extends BaseAdapter{
	Context ctx;
	ArrayList<Biodata> list;
	public GuestAdapter(Context context,
			ArrayList<Biodata> arrayList) {
		ctx = context;
		list = arrayList;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView = View.inflate(ctx, R.layout.child_grid_view, null);
		}
		TextView name = (TextView) convertView.findViewById(R.id.textView1);
		TextView birthdate = (TextView) convertView.findViewById(R.id.textView2);
		
		name.setText(list.get(position).getNama());
		birthdate.setText(list.get(position).getTanggal());
		
		
		return convertView;
	}

}
