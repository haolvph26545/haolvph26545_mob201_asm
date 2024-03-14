package vn.edu.spx.haolvph26545_mob201_asm;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        WebView webView = findViewById(R.id.web);

        Intent intent = getIntent();

        String link = intent.getStringExtra("link");

        webView.loadUrl(link);

        webView.setWebViewClient(new WebViewClient());
    }
}