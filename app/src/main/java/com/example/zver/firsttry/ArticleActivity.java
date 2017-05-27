package com.example.zver.firsttry;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class ArticleActivity extends AppCompatActivity {

    SharedPreferences sPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        MyWebClient mwc = new MyWebClient();
        final WebView webView = (WebView) findViewById(R.id.articleView);
        webView.setWebViewClient(mwc);
        sPref = getPreferences(MODE_PRIVATE);
        final Intent intent = getIntent();
        final String url = intent.getStringExtra("intUrl");
        final ArticleSaveLoader articleSaveLoader = new ArticleSaveLoader(sPref);
        final Button saveButton = (Button) findViewById(R.id.saveDeleteButton);
        String isFavotire = intent.getStringExtra("isFavorite");
        if (isFavotire.equals("true")) {
            saveButton.setText("Удалить из избранного");
        } else {
            saveButton.setText("Сохранить");
        }
        saveButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View view) {
                                              if (intent.getStringExtra("isFavorite").equals("true")) {
                                                  articleSaveLoader.RemoveArticle(intent);

                                                  saveButton.setText("Сохранить");
                                              } else {
                                                  articleSaveLoader.SaveArticle(intent);
                                                  Toast.makeText(ArticleActivity.this, sPref.getString("Key", "") +"привет", Toast.LENGTH_LONG).show();
                                                  saveButton.setText("Удалить из избранного");
                                              }
                                          }
                                      }
        );
        webView.loadUrl(url);
    }

}


