package com.jamonek.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginFormActivity extends FragmentActivity {
	public final static String TYPE = "";
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
			@Override
			public void onClick(View v) {
				EditText name=(EditText)findViewById(R.id.name);
				EditText username=(EditText)findViewById(R.id.username);
				EditText password=(EditText)findViewById(R.id.password);
				person.setName(name.getText().toString());
				person.setUsername(username.getText().toString());
				person.setPassword(password.getText().toString());
				Intent i = new Intent(LoginFormActivity.this, AndroidTabActivity.class);
				i.putExtra(TYPE, person.getType());
				i.putExtra(NAME, person.getName());
				i.putExtra(USERNAME, person.getUsername());
				i.putExtra(PASSWORD, person.getPassword());
				startActivity(i);
			}
		};
}
