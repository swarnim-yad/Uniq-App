package com.example.uniqpaymentsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {
Button bt11,bt12,bt13,bt14;
TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity2);
		bt11=(Button)findViewById(R.id.b31);
		bt12=(Button)findViewById(R.id.b32);
		bt13=(Button)findViewById(R.id.b33);
		bt14=(Button)findViewById(R.id.b34);
		tv1=(TextView)findViewById(R.id.t31);
		SharedPreferences sp=getSharedPreferences("Payment", MODE_PRIVATE);
		String nm=sp.getString("Name",null);
		tv1.setText("Welcome "+nm);
		bt11.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity2.this,MainActivity3.class);
				startActivity(i);
				Toast a=Toast.makeText(getApplicationContext(), "Privileged Page!", Toast.LENGTH_SHORT);
				a.setGravity(Gravity.TOP, 10, 50);
				a.show();
			}
		});
		
		bt12.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity2.this,MainActivity4.class);
				startActivity(i);
				Toast a=Toast.makeText(getApplicationContext(), "Privileged Page!", Toast.LENGTH_SHORT);
				a.setGravity(Gravity.TOP, 10, 50);
				a.show();
			}
		});
		
		bt13.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity2.this,MainActivity5.class);
				startActivity(i);
				Toast a=Toast.makeText(getApplicationContext(), "Privileged Page!", Toast.LENGTH_SHORT);
				a.setGravity(Gravity.TOP, 10, 50);
				a.show();
			}
		});
		
		bt14.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity2.this,MainActivity.class);
				startActivity(i);
				Toast a=Toast.makeText(getApplicationContext(), "Logout Successful!", Toast.LENGTH_SHORT);
				a.setGravity(Gravity.TOP, 10, 50);
				a.show();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity2, menu);
		return true;
	}

}
