package edu.nd.crc.tutorialapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "edu.nd.crc.tutorialapp.MESSAGE";
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        //TODO Enable default caching mode for release version
        //settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //settings.setAppCacheEnabled(false);
        //webView.clearCache(true);

        webView.loadUrl("file:///android_asset/map.html");
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view){
        //Toggle circle drawing when send button is pushed
        if(!this.isFinishing())
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl("javascript:if(mymap.hasLayer(mycircle)){mymap.removeLayer(mycircle);} else {mymap.addLayer(mycircle);}");
                }
            });
    }
}
