package com.example.pizzastore;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ObjectsReader
{

    private static final String TAG = "PizzaStore";
    
    private static ProductResponse responseObject = null;
   
    public static ProductResponse readResponse(String jsonFileUrl)
    {
    	Log.d(TAG, "---------------- JSON URL: " + jsonFileUrl);
        InputStream source = retrieveStream(jsonFileUrl);
        
        if(source != null){
        	Log.d(TAG, "InputStream NOT null");
        }
        
        Reader reader = new InputStreamReader(source);

        Log.d(TAG, reader.toString());
        
        Gson gson = new Gson();
        
        Log.d(TAG, "getting TypeToken");
        Type listType = new TypeToken<ProductResponse>()
        {
        }.getType();
        
        Log.d(TAG, "listType is: " + listType.toString());

        responseObject = gson.fromJson(reader, listType);
        
        if(responseObject != null){
        	Log.d(TAG, "responseObject is NOT NULL");
        }
        
        return responseObject;
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