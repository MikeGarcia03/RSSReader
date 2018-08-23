package com.example.tics.rssreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;


public class ViewDataActivity extends AppCompatActivity {

    private ListView viewDataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        viewDataListView = findViewById(R.id.viewDataList);

        String url = getIntent().getExtras().getString("URL");

        Parser parser = new Parser();

        parser.onFinish(new Parser.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(ArrayList<Article> list) {
                viewDataListView.setAdapter(new FeedAdapter(ViewDataActivity.this, list));
            }

            @Override
            public void onError() {

            }
        });
        parser.execute(url);
    }
}
