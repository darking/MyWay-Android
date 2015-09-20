package com.pifss.myway;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParentMonitoring_Pairing_DriverPairing extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent_monitoring__pairing__driver_pairing);
		
		// content holder for the pairing request on the drivers device
		
		TextView username = (TextView) findViewById(R.id.textView_ParentControl_AddDriverUsername);
		TextView userEmail = (TextView) findViewById(R.id.textView_ParentControl_AddDriverUserEmail);
		
		//Code to get the extra info from intent
		
		final String newString;
		if (savedInstanceState == null) {
		    Bundle extras = getIntent().getExtras();
		    if(extras == null) {
		        newString= null;
		    } else {
		        newString= extras.getString("username");
		    }
		} else {
		    newString= (String) savedInstanceState.getSerializable("username");
		}
		
		// change the data source to info from database
		
		username.setText(newString);
		userEmail.setText(newString);
		
		Button add = (Button) findViewById(R.id.button_AddDriver);
		
		add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ParentalMonitoringConnectionManager.addDriver(new Driver(newString));
				
				Intent intent = new Intent(ParentMonitoring_Pairing_DriverPairing.this, ParentalMonitoringActivity.class);
	        	startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.parent_monicoting__pairing__driver_pairing, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		return super.onOptionsItemSelected(item);
	}
}
