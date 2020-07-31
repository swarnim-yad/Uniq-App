package com.example.uniqpaymentsapp;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity3 extends Activity {
EditText et1,et2,et3;
Button bt1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity3);
		et1=(EditText)findViewById(R.id.e41);
		et2=(EditText)findViewById(R.id.e42);
		et3=(EditText)findViewById(R.id.e43);
		bt1=(Button)findViewById(R.id.b41);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String s2=et1.getText().toString();
				String s3=et2.getText().toString();
				String s4=et3.getText().toString();
				SharedPreferences sp=getSharedPreferences("Payment",MODE_PRIVATE);
				String s1=sp.getString("Pass",null);
				if(s2.isEmpty())
					et1.setError("Mandatory Field!Can't be empty");
				if(s3.isEmpty())
					et2.setError("Mandatory Field!Can't be empty");
				if(s4.isEmpty())
					et3.setError("Mandatory Field!Can't be empty");
				else
				{
					if(s2.equals(s1)&&s3.equals(s4))
					{
						SharedPreferences.Editor ed=sp.edit();
						ed.putString("Pass",s4);
						ed.commit();
						Intent i=new Intent(MainActivity3.this,MainActivity2.class);
						startActivity(i);
						Toast a=Toast.makeText(getApplicationContext(), "Password Change Successful!",Toast.LENGTH_SHORT);
						a.setGravity(Gravity.TOP,10,50);
						a.show();
					}
					else
					{
						if(!(s2.equals(s1)))
						{
							Toast a=Toast.makeText(getApplicationContext(),"Incorrect Old Password",Toast.LENGTH_SHORT);
							a.setGravity(Gravity.TOP,10,50);
							a.show();
						}
						if(!(s3.equals(s4)))
						{
							Toast a=Toast.makeText(getApplicationContext(),"New Passwords Don't Match",Toast.LENGTH_SHORT);
							a.setGravity(Gravity.TOP,10,50);
							a.show();
						}
					}
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity3, menu);
		return true;
	}

}
