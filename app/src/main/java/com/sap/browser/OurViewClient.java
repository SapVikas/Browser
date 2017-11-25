package com.sap.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class OurViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url){
        v.loadUrl(url);
        return true;
    }
}
