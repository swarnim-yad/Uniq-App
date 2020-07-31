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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
TextView tv1,tv2;
EditText et1,et2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1=(TextView)findViewById(R.id.t11);
		et1=(EditText)findViewById(R.id.e11);
		et2=(EditText)findViewById(R.id.e12);
		tv2=(TextView)findViewById(R.id.t12);
		tv2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String s1=et1.getText().toString();
				String s2=et2.getText().toString();
				SharedPreferences sp=getSharedPreferences("Payment",MODE_PRIVATE);
				String c1=sp.getString("User",null);
				String c2=sp.getString("Pass",null);
				if(s1.isEmpty())
					et1.setError("Field Required");
				if(s2.isEmpty())
					et2.setError("Field Required");
				else if(s1.equals(c1)&&s2.equals(c2))
				{
					Toast a=Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
					a.setGravity(Gravity.TOP,10,50);
					a.show();
					Intent i=new Intent(MainActivity.this,MainActivity2.class);
					startActivity(i);
				}
				else
				{
					Toast a=Toast.makeText(getApplicationContext(), "Login Failure!Try Again", Toast.LENGTH_SHORT);
					a.setGravity(Gravity.TOP,10,50);
					a.show();
				}
				
			}
		});
		
		tv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i=new Intent(MainActivity.this,MainActivity1.class);
				startActivity(i);
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
