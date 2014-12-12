package com.example.moviledev.adapter;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.mobiledev.R;
import com.example.project1.library.GPlusListAdapter;
import com.example.project1.library.SpeedScrollListener;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends GPlusListAdapter{
	static ArrayList<Event> data;
	Context ctx;
	public EventAdapter(Context context,
			SpeedScrollListener scrollListener) {
		super(context, scrollListener, Arrays.asList(data));
		// TODO Auto-generated constructor stub

		ctx = context;
		data = new ArrayList<EventAdapter.Event>();
		data.add(new Event(R.drawable.miranda, "Miranda Kerr", "20 April 1983"));
		data.add(new Event(R.drawable.kobe, "Kobe Bryant", "23 Agustus 1978"));
		data.add(new Event(R.drawable.edsheeran, "Ed Sheeran", "17 Februari 1991"));
		data.add(new Event(R.drawable.mj, "Michael Jackson", "29 Agustus 1958"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
		data.add(new Event(R.drawable.m, "tes", "30 November 1994"));
	}
	
	public static String getData(int pos) {
		return data.get(pos).sNama;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
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

	
	private class Event{
		int ImageId; 
		String sNama, sTanggal;
		public Event(int ImageId, String sNama, String sTanggal) {
			this.ImageId = ImageId;
			this.sNama = sNama;
			this.sTanggal = sTanggal;
		}
		
	}

	@Override
	protected View getRowView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView==null){
			convertView = View.inflate(ctx, R.layout.child_list_view, null);
		}
		ImageView image = (ImageView) convertView.findViewById(R.id.imageView1);
		TextView name = (TextView) convertView.findViewById(R.id.textView1);
		TextView birthdate = (TextView) convertView.findViewById(R.id.textView2);
		
		image.setImageResource(data.get(position).ImageId);
		name.setText(data.get(position).sNama);
		birthdate.setText(data.get(position).sTanggal);
		
		
		return convertView;
	}
}
