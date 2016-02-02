package com.example.pizzastore;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";
	private ListView mListView;
	private List<String> mTestStrings = new ArrayList<String>();
	private List<Product> mProductList = new ArrayList<Product>();
	private Product[] mProducts;

	private class DataLoadingTask extends AsyncTask<Integer, Integer, Integer> {
		@Override
		protected void onPreExecute() {

		}

		@Override
		protected Integer doInBackground(Integer... arg0) {

			try {
				read();
			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// Do nothing
		}

		@Override
		protected void onPostExecute(Integer result) {
			display();
		}

	}

	public void read() {
		Log.d(TAG, "read was called");
		final String jsonFileUrl = "http://192.168.2.15:9090/culebrastore/product/index.json";

		InputStream source = retrieveStream(jsonFileUrl);
		Reader reader = new InputStreamReader(source);
		Gson gson = new Gson();

		Type listType = new TypeToken<ProductResponse>()
		{
		}.getType();

		mProducts = gson.fromJson(reader, Product[].class);

		mProductList = new ArrayList<Product>(Arrays.asList(mProducts));

		// mProductList = response.getProductList();
		for (Product p : mProductList) {
			Log.d(TAG, "product name : " + p.getName());
		}
	}

	public void display() {
		MyCustomAdapter adapter = new MyCustomAdapter(this, 0, mProductList);
		mListView.setAdapter(adapter);
	}

	public class MyCustomAdapter extends ArrayAdapter<Product> {

		public MyCustomAdapter(Context context, int textViewResourceId,
				List<Product> mProductList) {
			super(context, textViewResourceId, mProductList);
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			// TODO Fix compile errors in this class

			final int rownumber = position;
			View row = convertView;

			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.row_item, parent, false);
			}

			row.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("PRODUCT_NAME", mProductList.get(position).getName());
                    startActivity(intent);

				}

			});

			TextView list_name = (TextView) row.findViewById(R.id.list_name);

			TextView list_description = (TextView) row
					.findViewById(R.id.list_description);

			TextView list_price = (TextView) row.findViewById(R.id.list_price);

			list_name.setText(mProductList.get(position).getName());
			list_description.setText(mProductList.get(position)
					.getDescription());
			// list_price.setText(mProductList.get(position).getPrice());

			// ImageView imageView1 = (ImageView)
			// row.findViewById(R.id.imageView1);

			// mImageCacheLoader.DisplayImage(mListOfPhotos.get(position).getPhotoURL(Photo.PhotoSize.t),
			// imageView1);

			return row;

		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String a = "Test1";
		String b = "Test2";
		String c = "Test3";
		mTestStrings.add(a);
		mTestStrings.add(b);
		mTestStrings.add(c);

		mListView = (ListView) findViewById(R.id.listView);

		new DataLoadingTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private static InputStream retrieveStream(String url)
	{

		DefaultHttpClient client = new DefaultHttpClient();

		HttpGet getRequest = new HttpGet(url);

		try
		{

			HttpResponse getResponse = client.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK)
			{
				Log.w(TAG, "Error " + statusCode + " for URL " + url);
				return null;
			}
			else{
				Log.d(TAG, "Status code: " + statusCode);
			}

			HttpEntity getResponseEntity = getResponse.getEntity();
			return getResponseEntity.getContent();

		} catch (IOException e)
		{
			getRequest.abort();
			Log.w(TAG, "Error for URL " + url, e);
		}

		return null;

	}
}
