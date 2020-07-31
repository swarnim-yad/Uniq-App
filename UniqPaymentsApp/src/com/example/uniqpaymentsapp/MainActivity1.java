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
public class MainActivity1 extends Activity {
	EditText et1,et2,et3,et4,et5,et6,et7;
	Button bt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);
		et1=(EditText)findViewById(R.id.e21);
		et2=(EditText)findViewById(R.id.e22);
		et3=(EditText)findViewById(R.id.e23);
		et4=(EditText)findViewById(R.id.e24);
		et5=(EditText)findViewById(R.id.e25);
		et6=(EditText)findViewById(R.id.e26);
		et7=(EditText)findViewById(R.id.e27);
		bt2=(Button)findViewById(R.id.b21);
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				String st1=et1.getText().toString();
				String st2=et2.getText().toString();
				String st3=et3.getText().toString();
				String st4=et4.getText().toString();
				String st5=et5.getText().toString();
				String st6=et6.getText().toString();
				String st7=et7.getText().toString();
				if(st1.isEmpty())
				{
					et1.setError("Mandatory Field!Can't Be Empty");
				}
				if(st2.isEmpty())
				{
					et2.setError("Mandatory Field!Can't Be Empty");
				}
				if(st3.isEmpty())
				{
					et3.setError("Mandatory Field!Can't Be Empty");
				}
				if(st4.isEmpty())
				{
					et4.setError("Mandatory Field!Can't Be Empty");
				}
				if(st5.isEmpty())
				{
					et5.setError("Mandatory Field!Can't Be Empty");
				}
				if(st6.isEmpty())
				{
					et6.setError("Mandatory Field!Can't Be Empty");
				}
				if(st6.isEmpty())
				{
					et7.setError("Mandatory Field!Can't Be Empty");
				}
				else 
				{
					if(st6.equals(st7))
					{
						SharedPreferences sp=getSharedPreferences("Payment",MODE_PRIVATE);
						SharedPreferences.Editor ed=sp.edit();
						ed.putString("User", st2);
						ed.putString("Pass", st7);
						ed.putString("Name", st1);
						ed.putString("Mobile", st3);
						ed.putString("AccNo", st5);
						ed.putFloat("Balance",1500);
						ed.commit();
						Intent i=new Intent(MainActivity1.this,MainActivity.class);
						startActivity(i);
						Toast a=Toast.makeText(getApplicationContext(), "Registration Successful!",Toast.LENGTH_SHORT);
						a.setGravity(Gravity.TOP,10,50);
						a.show();
						
					}
					else
					{
						Toast a=Toast.makeText(getApplicationContext(), "Passwords Dont Match!",Toast.LENGTH_SHORT);
						a.setGravity(Gravity.TOP,10,50);
						a.show();
					}
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity1, menu);
		return true;
	}

}
