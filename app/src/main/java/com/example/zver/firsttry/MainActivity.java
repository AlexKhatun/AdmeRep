package com.example.zver.firsttry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    GetArticles ga;
    EditText etText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ga = new GetArticles();
        MyAdapter adapter = new MyAdapter(this, ga.GetArticles());
        ListView listArticles = (ListView) findViewById(R.id.listArticles);
        listArticles.setAdapter(adapter);
        listArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, ArticleActivity.class);
                Article article = (Article) parent.getItemAtPosition(position);
                String url = article.Url;
                myIntent.putExtra("intUrl", url);
                myIntent.putExtra("isFavorite", article.IsFavorite.toString());
                myIntent.putExtra("text", article.PictureUrl);
                myIntent.putExtra("title", article.Title);
                startActivity(myIntent);
            }
        } );





        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
                                                          @Override
                                                          public void onClick(View view)
                                                          {
//                                                              SaveFavorites();
//                                                              LoadFavorites();
                                                              Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
                                                              startActivity(intent);

                                                          }
                                                      }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    /*@Override
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }*/

}
