package com.priyanka.popcliqs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import org.apache.http.HttpRequest;
import org.json.*;
import java.net.URL;

public class WebActivityLogin extends Activity {

    private WebView webView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        final Context context = this;

        String url = "http://popcliqs.com/beta/login.service.php?usernm=tahir@popcliqs.com&pwd=123456";

        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
    }
}