package com.priyanka.popcliqs;

import android.app.Activity;

import android.R.*;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Popcliqs extends Activity {

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

                if( email.equals("")|| password.equals("")){
                    Toast.makeText(getApplicationContext(),"please fill the form", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(context, WebActivityLogin.class);
                    startActivity(intent);
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
 }

