package com.codewave.userlist;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class UserProfileActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_profile);

		String userJSON = getIntent().getExtras().getString("user");
		TextView name = (TextView) findViewById(R.id.name);
		TextView email = (TextView) findViewById(R.id.email);
		TextView mobile = (TextView) findViewById(R.id.mobile);

		try {
			JSONObject user = new JSONObject(userJSON);
			name.setText(user.getString(UserListActivity.TAG_USER_FIRST_NAME));
			email.setText(user.getString(UserListActivity.TAG_USER_EMAIL_ID));
			mobile.setText(user.getString(UserListActivity.TAG_USER_PHONE_NO));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
