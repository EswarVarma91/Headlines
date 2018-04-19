package com.amigoentertainments.apps.headlinessizeminimize;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


public class Abcnews extends AppCompatActivity {

    private ListView lv;
    ArrayList<Actors> actorsList;
    static final String TextUrl = "url";

    ActorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abcnews);
        actorsList = new ArrayList<Actors>();
        new JSONAsyncTask().execute();

        ListView listview = (ListView)findViewById(R.id.listabc);
        adapter = new ActorAdapter(getApplicationContext(), R.layout.row, actorsList);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
                // TODO Auto-generated method stub
                // click on item to navigate to browser page
                String tvurl=actorsList.get(position).getUrl();
                // Starting new intent
                Intent in=new Intent(Abcnews.this,WebviewActivity.class);
                in.putExtra(TextUrl,tvurl);
                startActivity(in);


                }
        });


    }


    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(Abcnews.this);
            dialog.setMessage("Loading, please wait");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("articles");

                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        Actors actor = new Actors();

                      //  actor.setAuthor(object.getString("author"));
                      //  actor.setDescription(object.getString("description"));
                        actor.setPublishedAt(object.getString("publishedAt"));
                      //  actor.setUrl(object.getString("url"));
                        actor.setTitle(object.getString("title"));
                        actor.setImage(object.getString("urlToImage"));

                        actorsList.add(actor);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "Please Check Your Internet Connection..!!", Toast.LENGTH_LONG).show();

        }
    }







}

