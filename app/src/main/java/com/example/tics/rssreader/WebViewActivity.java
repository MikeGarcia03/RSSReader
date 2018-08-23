package com.example.tics.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        String url = getIntent().getExtras().getString("URL");

        WebView webView = findViewById(R.id.articleWebView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        //Toast.makeText(this,"Esto fue lo que llego"+url, Toast.LENGTH_LONG).show();
    }
}
