package com.example.uniqpaymentsapp;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.gsm.SmsManager;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity5 extends Activity {
EditText et1,et2,et3,et4,et5,et6,et7;
Button bt1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity5);
		et1=(EditText)findViewById(R.id.e61);
		et2=(EditText)findViewById(R.id.e62);
		et3=(EditText)findViewById(R.id.e63);
		et4=(EditText)findViewById(R.id.e64);
		et5=(EditText)findViewById(R.id.e65);
		et6=(EditText)findViewById(R.id.e66);
		et7=(EditText)findViewById(R.id.e67);
		bt1=(Button)findViewById(R.id.b61);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String s1=et1.getText().toString();
				String s2=et2.getText().toString();
				String s3=et3.getText().toString();
				String s4=et4.getText().toString();
				String s5=et5.getText().toString();
				String s6=et6.getText().toString();
				String s7=et7.getText().toString();
				Float a=Float.valueOf(s6);
				SharedPreferences sp=getSharedPreferences("Payment",MODE_PRIVATE);
				String mob=sp.getString("Mobile", null);
				String acc=sp.getString("AccNo", null);
				String paa=sp.getString("Pass", null);
				Float b=sp.getFloat("Balance",5);
				if(s1.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s2.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s3.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s4.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s5.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s6.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				if(s7.isEmpty())
				{
					et1.setError("Mandatory Field!Can't be empty");
				}
				else
				{
					if(s7.equals(paa))
					{
						if(a>b)
						
						{
							Toast a1=Toast.makeText(getApplicationContext(),"Insufficient Funds!Transfer Faliure!", Toast.LENGTH_SHORT);
							a1.setGravity(Gravity.TOP,10,50);
							a1.show();
							Intent i=new Intent(MainActivity5.this,MainActivity2.class);
							startActivity(i);
							SmsManager sms = SmsManager.getDefault();
							sms.sendTextMessage(mob,null,"Fund Transfer Failure from your Account!If Not U Call your bank and block services immediatly!",null,null);
						}
						else
						{
							b-=a;
							SharedPreferences.Editor ed=sp.edit();
							ed.putFloat("Balance",b);
							ed.commit();
							Toast a1=Toast.makeText(getApplicationContext(),"Fund Transfer Successful!", Toast.LENGTH_SHORT);
							a1.setGravity(Gravity.TOP,10,50);
							a1.show();
							Intent i=new Intent(MainActivity5.this,MainActivity2.class);
							startActivity(i);
							String msg="Rs."+s6+" Debited from your account "+acc+" !If Not U Call your bank and block services immediatly!";
							SmsManager sms = SmsManager.getDefault();
							sms.sendTextMessage(mob,null,msg,null,null);
						}
					}
					else
					{
						Toast a1=Toast.makeText(getApplicationContext(),"Inncorect Password!Transfer Faliure!", Toast.LENGTH_SHORT);
						a1.setGravity(Gravity.TOP,10,50);
						a1.show();
						Intent i=new Intent(MainActivity5.this,MainActivity2.class);
						startActivity(i);
						SmsManager sms = SmsManager.getDefault();
						sms.sendTextMessage(mob,null,"Fund Transfer Failure from your Account!If Not U Call your bank and block services immediatly!",null,null);
					}
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_activity5, menu);
		return true;
	}

}
