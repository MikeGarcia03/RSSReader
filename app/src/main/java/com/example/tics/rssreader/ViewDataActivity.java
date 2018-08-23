package com.example.tics.rssreader;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.prof.rssparser.Article;
import com.prof.rssparser.Parser;

import java.util.ArrayList;
import java.util.List;


public class ViewDataActivity extends AppCompatActivity {

    private ListView viewDataListView;
    private ArrayList<Article> list2;

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
                list2 = list;
                viewDataListView.setAdapter(new FeedAdapter(ViewDataActivity.this, list));
            }
            @Override
            public void onError() {
                //For the errors
            }
        });
        parser.execute(url);

        viewDataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pairOddItemValidation(i);
            }
        });
    }

    public void pairOddItemValidation(int index){
        String url = list2.get(index).getLink();
        if (index % 2 == 0){launchWebView(url);}else{launchBrowser(url);}
    }

    public void launchWebView (String urlWebView){
        Intent i = new Intent(this, WebViewActivity.class);
        i.putExtra("URL", urlWebView);
        startActivity(i);
    }
    public void launchBrowser (String urlBrowser){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(urlBrowser));
        startActivity(i);
        //Toast.makeText(this,"Funciona la validacion", Toast.LENGTH_LONG).show();
    }
}
