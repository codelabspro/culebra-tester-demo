package com.example.pizzastore;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailActivity extends Activity {
    private TextView mDetailTitle;
    private String mProductName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mProductName = extras.getString("PRODUCT_NAME");
        }
        mDetailTitle = (TextView) this.findViewById(R.id.detailTitle);
        mDetailTitle.setText(mProductName);

    }
}
