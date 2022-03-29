package com.websolverpro.bookmanagerandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView bookWebView;
    String url = "https://websolverpro.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        bookWebView = findViewById(R.id.webViewBookManagement);
        bookWebView.getSettings().setJavaScriptEnabled(true);
        bookWebView.setWebViewClient( new WebViewClient());

        bookWebView.loadUrl(url);
    }
}