package com.sap.browser;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


public class Naruto extends AppCompatActivity {
    EditText url;
    WebView ourBrowser;
Button Go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.naruto);

        url=(EditText)findViewById(R.id.eTURL);
        Go = (Button) findViewById(R.id.bGo);
        ourBrowser = (WebView)findViewById(R.id.bWebView);
        ourBrowser.getSettings().setJavaScriptEnabled(true);
        ourBrowser.getSettings().setLoadWithOverviewMode(true);
        ourBrowser.getSettings().setUseWideViewPort(true);
        ourBrowser.setWebViewClient(new OurViewClient());
        String webUrl = ourBrowser.getUrl();
        url.setText(webUrl);
        try{
        ourBrowser.loadUrl("https://www.google.co.in");
        }catch (Exception e){
            e.printStackTrace();
        }

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yo = url.getText().toString();
                String yo1= "http://www."+yo;
                ourBrowser.loadUrl(yo1);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp= getMenuInflater();
        blowUp.inflate(R.menu.cool_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.aboutus:

                break;
            case R.id.settings:

                break;
            case R.id.bGo:
                String str = url.getText().toString();
                ourBrowser.loadUrl(str);
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(),0);
                break;
            case R.id.bBack:
                if(ourBrowser.canGoBack())
                    ourBrowser.goBack();

                break;
            case R.id.bFrwrd:
                if(ourBrowser.canGoForward())
                    ourBrowser.goForward();

                break;
            case R.id.bRefresh:
                ourBrowser.reload();

                break;
            case R.id.bClrHistory:
                ourBrowser.clearHistory();

                break;
            case R.id.Ex1:
                finish();
                System.exit(0);
                break;
            case R.id.bHome:
                String str1= "https://www.google.co.in";
                ourBrowser.loadUrl(str1);
                break;
        }return false;
    }


}
