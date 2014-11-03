package com.priyanka.popcliqs;

import android.app.Activity;
import android.R.*;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class popcliqs extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popcliqs);

        final TextView forgotPassword = (TextView) findViewById(R.id.textView4);
        forgotPassword.setText(Html.fromHtml(getResources().getString(R.string.Forgot_Password)));
        forgotPassword.setMovementMethod(LinkMovementMethod.getInstance());

        final TextView signUp = (TextView) findViewById(R.id.textView7);
        signUp.setText(Html.fromHtml(getResources().getString(R.string.sign_up)));
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
