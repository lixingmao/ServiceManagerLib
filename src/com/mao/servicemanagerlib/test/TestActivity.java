package com.mao.servicemanagerlib.test;

import com.mao.servicemanagerlib.R;
import com.mao.servicemanagerlib.R.layout;
import com.mao.servicemanagerlib.service.core.ServiceManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
	}
	
	
	
	
	private void doServer(){
		try {
			UserService service = (UserService)ServiceManager.getService(UserService.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
