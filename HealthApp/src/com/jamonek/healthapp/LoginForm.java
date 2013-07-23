package com.jamonek.healthapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginForm extends FragmentActivity {
	public final static String NAME = "";
	public final static String USERNAME = "";
	public final static String PASSWORD = "";
	private PersonLogin person = new PersonLogin();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_form);
		person.setType(getIntent().getStringExtra(MainActivity.TYPE_EXTRA));
		Button login = (Button)findViewById(R.id.login);
		login.setOnClickListener(onLogin);
	}
		
		private View.OnClickListener onLogin=new View.OnClickListener() {
			public void onClick(View v) {
				EditText name=(EditText)findViewById(R.id.name);
				EditText username=(EditText)findViewById(R.id.username);
				EditText password=(EditText)findViewById(R.id.password);
				person.setName(name.getText().toString());
				person.setUsername(username.getText().toString());
				person.setPassword(password.getText().toString());
			}
		};
}
