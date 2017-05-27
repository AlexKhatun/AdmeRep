package com.example.zver.firsttry;

import android.webkit.WebViewClient;
import android.webkit.WebView;

/**
 * Created by Zver on 22.05.2017.
 */

public class MyWebClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        view.loadUrl(url);
        return true;
    }
}
