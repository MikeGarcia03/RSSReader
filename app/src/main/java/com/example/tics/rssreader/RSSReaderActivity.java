package com.example.tics.rssreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RSSReaderActivity extends AppCompatActivity {

    private Button btnWired, btnDiarioLibre;
    private String urlDiarioLibre = "https://www.diariolibre.com/rss/portada.xml";
    private String urlWired = "https://www.wired.com/feed/rss";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rssreader);

        btnDiarioLibre = findViewById(R.id.lisinDiarioButton);
        btnWired = findViewById(R.id.wiredButton);
    }

    public void callViewDataActivity(View v){

        Intent i = new Intent(this, ViewDataActivity.class);

        if (btnDiarioLibre.isPressed()) {
            i.putExtra("URL", urlDiarioLibre);
            startActivity(i);
        }

        if (btnWired.isPressed()){
            i.putExtra("URL",urlWired);
            startActivity(i);
        }
    }
}

