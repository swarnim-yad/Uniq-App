package com.example.uniqpaymentsapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends Activity {
	TextView tv1;
	Button bt1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity4);
		tv1=(TextView)findViewById(R.id.t51);
		bt1=(Button)findViewById(R.id.b51);
		SharedPreferences sp=getSharedPreferences("Payment",MODE_PRIVATE);
		Float b=sp.getFloat("Balance",5);
		String e=String.valueOf(b);
		tv1.setText(e);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity4.this,MainActivity2.class);
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity4, menu);
		return true;
	}

}
