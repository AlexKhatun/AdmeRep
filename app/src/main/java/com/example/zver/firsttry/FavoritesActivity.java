package com.example.zver.firsttry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class FavoritesActivity extends AppCompatActivity {

    SharedPreferences sPref;
    GetArticles ga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        GetArticles ga = new GetArticles();
        MyAdapter adapter = new MyAdapter(this, ga.GetArticlesFromRef(LoadFavorites()));
        ListView listArticles = (ListView) findViewById(R.id.favoritesList);
        listArticles.setAdapter(adapter);
        listArticles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(FavoritesActivity.this, ArticleActivity.class);
                Article article = (Article) parent.getItemAtPosition(position);
                String url = article.Url;
                myIntent.putExtra("intUrl", url);
                startActivity(myIntent);
            }
        } );
    }
    public void SaveFavorites(String s){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("Key", s);
        ed.commit();
    }
    public String LoadFavorites(){
        sPref =getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString("Key", "");
        return savedText;
    }

    public void SaveAll(){
        sPref.edit().remove("Key").commit();
        String s = "";
        for(int i = 0; i < ga.GetFavorites().length; i++)
        {
            s += ga.GetFavorites()[i].toString();
        }
        SaveFavorites(s);
    }

}
