package com.example.zver.firsttry;

import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by Zver on 26.05.2017.
 */

public class ArticleSaveLoader {

    public ArticleSaveLoader(SharedPreferences sPref){
        this.sPref = sPref;

    }
    GetArticles ga = new GetArticles();
    SharedPreferences sPref;

    public void SaveFavorites(String s){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("Key", s);
        ed.commit();
    }
    public String LoadFavorites(){
        String savedText = sPref.getString("Key", "");
        return savedText;
    }

    public void SaveAll(Article[] articles){
        sPref.edit().remove("Key").commit();
        String s = "";
        for(int i = 0; i < articles.length; i++)
        {
            s +=articles[i].toString();
        }
        SaveFavorites(s);
    }

    public void SaveArticle(Intent intent){
        Article resultArray[] = new Article[1];
        Article favoritesList[] = new Article[1];
        Article article = new Article();
        article.Url = intent.getStringExtra("intUrl");
        article.PictureUrl = intent.getStringExtra("text");
        article.Title = intent.getStringExtra("title");
        article.IsFavorite = true;
        try{
            resultArray = new Article[ga.GetArticlesFromRef(LoadFavorites()).length+1];
            favoritesList = ga.GetArticlesFromRef(LoadFavorites());
            for(int i = 0; i < ga.GetArticlesFromRef(LoadFavorites()).length; i++)
            {
                resultArray[i] = favoritesList[i];
            }
            resultArray[resultArray.length-1] = article;
        }
        catch (Exception e)
        {
            resultArray = new Article[1];
            resultArray[0] = article;
        }
        finally {
            SaveAll(resultArray);
        }
    }

    public void RemoveArticle(Intent intent){
        Article resultArray[] = new Article[1];
        Article favoritesList[] = new Article[1];
        String url = intent.getStringExtra("intUrl");
        try{
            resultArray = new Article[ga.GetArticlesFromRef(LoadFavorites()).length-1];
            favoritesList = ga.GetArticlesFromRef(LoadFavorites());
            for(int i = 0, j = 0; i < ga.GetArticlesFromRef(LoadFavorites()).length; i++) {
                if (favoritesList[i].Url != url) {
                    resultArray[j] = favoritesList[i];
                    j++;
                }
            }
        }
        catch (Exception e){}
        finally {
            SaveAll(resultArray);
        }
    }
}
