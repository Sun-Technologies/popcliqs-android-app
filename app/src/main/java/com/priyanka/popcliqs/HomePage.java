package com.priyanka.popcliqs;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class HomePage extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        webView = (WebView) findViewById(R.id.webView1);
        webView.loadUrl("http://popcliqs.com/beta/home.php");
    }
}