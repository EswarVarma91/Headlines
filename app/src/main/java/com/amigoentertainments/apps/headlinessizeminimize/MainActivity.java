package com.amigoentertainments.apps.headlinessizeminimize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String[] names = {"Abc news(AU)", "Associated Press", "BBC news", "Bild", "CNN",
            "Der Tagessipiegel", "Focus", "Google News", "Independent", "Metro",
            "Mirror", "Newsweek", "Reddit", "Reuters", "Sky News", "Spiegel Online",
            "The guardian (AU)", "The guardian (UK)", "The Hindu", "The Huffington Post",
            "The New York Times", "The Telegraph", "The Times of India", "The Washinton Post", "Time", "USA Today"};
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listView1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 1:
                        String AbcUrl="https://newsapi.org/v1/articles?source=abc-news-au&sortBy=top&apiKey=f95ac369aef148e29d6bf0766c8b2715";
                        Intent i0=new Intent(MainActivity.this,Abcnews.class);
                        i0.putExtra("ONE_URL",AbcUrl);
                        startActivity(i0);
                        break;
                    case 2:
                        String AbcUrl1="https://newsapi.org/v1/articles?source=associated-press&sortBy=top&apiKey=f95ac369aef148e29d6bf0766c8b2715";
                        Intent i1=new Intent(MainActivity.this,Abcnews.class);
                        i1.putExtra("ONE_URL",AbcUrl1);
                        startActivity(i1);
                        break;
                }
            }
        });
    }
}
