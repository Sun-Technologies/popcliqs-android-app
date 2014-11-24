package com.priyanka.popcliqs;

import android.app.Activity;

import android.R.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Popcliqs extends Activity {
    public static final String TAG = Popcliqs.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popcliqs);

        final EditText emailId       = (EditText) findViewById(R.id.editText);
        final EditText passwordField = (EditText) findViewById(R.id.editText3);

        final TextView login = (TextView) findViewById(R.id.textView2);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final String email    = emailId.getText().toString();
                final String password = passwordField.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(getApplicationContext(), "please fill the form", Toast.LENGTH_LONG).show();
                } if(email.equals("tahir@popcliqs.com")&& password.equals("123456")) {
                    try {
                        GetDataFromBlog getDataFromBlog = new GetDataFromBlog();
                        getDataFromBlog.execute();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect Credential", Toast.LENGTH_LONG).show();
                }
            }
        });

        final TextView forgotPassword = (TextView) findViewById(R.id.textView4);
        forgotPassword.setText(Html.fromHtml(getResources().getString(R.string.forgotPassword)));
        forgotPassword.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView signUp = (TextView) findViewById(R.id.textView7);
        signUp.setText(Html.fromHtml(getResources().getString(R.string.signUp)));
        signUp.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView howItWorks = (TextView) findViewById(R.id.textView8);
        howItWorks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(context, WebActivity.class);
                startActivity(intent);
            }
        });
    }
    private class GetDataFromBlog extends AsyncTask<Object,Void, String> {
        @Override
        protected String doInBackground(Object[] arg0) {
            int responseCode = -1;
            final Context context = Popcliqs.this;
            try {
                URL blogFeed = new URL("http://popcliqs.com/beta/login.service.php?usernm=tahir@popcliqs.com&pwd=123456");
                //to make connection to the url
                HttpURLConnection urlConnection = (HttpURLConnection) blogFeed.openConnection();
                urlConnection.connect();
                //to get response code from url
                responseCode = urlConnection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK){
                    InputStream is = urlConnection.getInputStream();
                    Reader reader  = new InputStreamReader(is);

                    int nextCharacter;
                    String responseData = "";
                    while(true){
                        nextCharacter = reader.read();
                        if(nextCharacter == -1)
                            break;
                        responseData += (char) nextCharacter;
                    }

                    JSONObject jsonResponse = new JSONObject(responseData);
                    int exitCode = jsonResponse.getInt("exit_cd");
                    if(exitCode == 0){
                        Intent intent = new Intent(context, LoginActivity.class);
                        startActivity(intent);
                    }
                }else {
                    Log.i(TAG, "Unresponsive Code" + responseCode);
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "Malformed Exception caught", e);
            } catch (IOException e) {
                Log.e(TAG, "IOException caught", e);
            } catch (Exception e) {
                Log.e(TAG, "Exception caught", e);
            }
            return "Response Data:" +responseCode;
        }
    }
}

