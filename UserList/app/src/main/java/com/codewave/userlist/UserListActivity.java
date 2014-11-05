package com.codewave.userlist;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class UserListActivity extends ListActivity {

	private ProgressDialog pDialog;

	static String response = null;
	public final static int GET = 1;
	public final static int POST = 2;

	// URL to get user JSON
	private static String url = "http://codewave.co.in/bni/restful/index.php/users_list/particular_chapter/user/QWJoaWppdGggSCBLIzkw@jamhtdk6gung6hi9kj93ef8lp7";

	// JSON Node names
	private static final String TAG_ID = "id";
	public static final String TAG_USER_FIRST_NAME = "user_first_name";
	public static final String TAG_USER_PHONE_NO = "user_phone_no";
	public static final String TAG_USER_EMAIL_ID = "user_email_id";
	public static final String TAG_USER_PROFILE_IMAGE = "user_profile_image";

	// users JSONArray
	JSONArray users = null;

	// Hashmap for ListView
	ArrayList<HashMap<String, String>> usersList;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		usersList = new ArrayList<HashMap<String, String>>();

		ListView lv = getListView();

		// Listview on item click listener
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				Intent clickedUser = new Intent(UserListActivity.this, UserProfileActivity.class);
				try {
					clickedUser.putExtra("user", users.getJSONObject(position).toString());
				} catch (JSONException e) {

					e.printStackTrace();
				}
				startActivity(clickedUser);
			}
		});

		// Calling async task to get json
		new GetUsers().execute();
	}

	/**
	 * Async task class to get json by making HTTP call
	 * */
	private class GetUsers extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(UserListActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			// Creating service handler class instance

			// Making a request to url and getting response
			String jsonStr = makeServiceCall(url, GET, null);

			Log.d("Response: ", "> " + jsonStr);

			if (jsonStr != null) {
				try {

					// Getting JSON Array node
					users = new JSONArray(jsonStr);

					// looping through All Users
					for (int i = 0; i < users.length(); i++) {
						JSONObject c = users.getJSONObject(i);

						String id = c.getString(TAG_ID);
						String name = c.getString(TAG_USER_FIRST_NAME);
						String email = c.getString(TAG_USER_EMAIL_ID);
						String mobile = c.getString(TAG_USER_PHONE_NO);
						String profile_image_url = c.getString(TAG_USER_PROFILE_IMAGE);

						// tmp hashmap for single user
						HashMap<String, String> user = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						user.put(TAG_ID, id);
						user.put(TAG_USER_FIRST_NAME, name);
						user.put(TAG_USER_EMAIL_ID, email);
						user.put(TAG_USER_PHONE_NO, mobile);
						user.put(TAG_USER_PROFILE_IMAGE, profile_image_url);

						// adding user to users list
						usersList.add(user);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} else {
				Log.e("HTTP Request", "Couldn't get any data from the url");
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			ListAdapter adapter = new SimpleAdapter(UserListActivity.this, usersList, R.layout.list_item, new String[] { TAG_USER_FIRST_NAME, TAG_USER_EMAIL_ID, TAG_USER_PHONE_NO }, new int[] {
					R.id.name, R.id.email, R.id.mobile });

			setListAdapter(adapter);
		}

		public String makeServiceCall(String url, int method, List<NameValuePair> params) {
			try {
				// http client
				DefaultHttpClient httpClient = new DefaultHttpClient();
				HttpEntity httpEntity = null;
				HttpResponse httpResponse = null;

				// Checking http request method type
				if (method == POST) {
					HttpPost httpPost = new HttpPost(url);
					// adding post params
					if (params != null) {
						httpPost.setEntity(new UrlEncodedFormEntity(params));
					}

					httpResponse = httpClient.execute(httpPost);

				} else if (method == GET) {
					// appending params to url
					if (params != null) {
						String paramString = URLEncodedUtils.format(params, "utf-8");
						url += "?" + paramString;
					}
					HttpGet httpGet = new HttpGet(url);

					httpResponse = httpClient.execute(httpGet);

				}
				httpEntity = httpResponse.getEntity();
				response = EntityUtils.toString(httpEntity);

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return response;

		}

	}
}
