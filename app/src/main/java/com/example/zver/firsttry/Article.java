package com.example.zver.firsttry;

/**
 * Created by Zver on 24.05.2017.
 */

public class Article {
    public String Title;
    public String PictureUrl;
    public Boolean IsFavorite;
    public String Url;

    @Override
    public String toString(){
        return Title + "-" + PictureUrl + "-" + IsFavorite + "-" + Url + "*";
    }
}
