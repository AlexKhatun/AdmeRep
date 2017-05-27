package com.example.zver.firsttry;

/**
 * Created by Zver on 24.05.2017.
 */

public class GetArticles {
    Article a1 = new Article();
    Article a2 = new Article();
    Article a3 = new Article();
    Article a4 = new Article();
    Article a5 = new Article();
    Article[] articles = new Article[5];
    public GetArticles(){
        a1.Title = "Статья 1";
        a1.PictureUrl = "Норм такая статья";
        a1.IsFavorite = true;
        a1.Url = "http://www.adme.ru";
        a2.Title = "Статья 2";
        a2.PictureUrl = "";
        a2.IsFavorite = false;
        a3.Title = "Статья 3";
        a3.PictureUrl = "";
        a3.IsFavorite = true;
        a4.Title = "Статья 5";
        a4.PictureUrl = "Неожиданно так";
        a4.IsFavorite = false;
        a5.Title = "Статья 5.5";
        a5.PictureUrl = "";
        a5.IsFavorite = false;
        articles[0] = a1;
        articles[1] = a2;
        articles[2] = a3;
        articles[3] = a4;
        articles[4] = a5;
    }
    public Article[] GetArticles(){
        return articles;
    }

    public Article[] GetFavorites(){
        int countFavorites = 0;
        for(int i = 0, j = 0; i < articles.length; i++)
        {
            if(articles[i].IsFavorite){
                countFavorites++;
            }
        }
        Article[] favorites = new Article[countFavorites];
        for(int i = 0, j = 0; i < articles.length; i++)
        {
            if(articles[i].IsFavorite){
                favorites[j] = articles[i];
                j++;
            }
        }
        return favorites;
    }

    public Article[] GetArticlesFromRef(String cache)
    {
        char[] cacheChar = cache.toCharArray();
        int counter = 0;
        for(int i = 0; i < cacheChar.length; i++)
        {
            if(cacheChar[i] == '*')
            {
                counter++;
            }
        }
        Article[] result = new Article[counter];
        int countWords = 0;
        Article article = new Article();
        String word = "";
        for(int i = 0; i < cacheChar.length; i++)
        {
            if(cacheChar[i] == '*')
            {
                counter--;
                result[counter] = article;
                article = new Article();
                countWords = 0;
            }
            else {
                 if (cacheChar[i] == '-') {
                    countWords++;
                    switch (countWords) {
                        case 0:
                            article.Title = word;
                            break;
                        case 1:
                            article.PictureUrl = word;
                            break;
                        case 2:
                            if (word == "true") {
                                article.IsFavorite = true;
                            } else article.IsFavorite = false;
                            break;
                        case 3:
                            article.Url = word;
                            break;
                    }
                    word = "";
                } else {
                    word += cacheChar[i];
                }
            }
        }
        return result;
    }
}
