package com.example.rasel.alertdialogandwebview;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static Button alertButton;
    private static WebView webHtmlCssView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertButton = findViewById(R.id.buttonAlert);
        alertButton.setOnClickListener(this);


        webHtmlCssView = findViewById(R.id.webSiteView);

//        WebSettings webSettings = webHtmlCssView.getSettings();
//        webSettings.setJavaScriptEnabled(true);

        //webHtmlCssView.loadUrl("file:///android_asset/index.html");
        //webHtmlCssView.loadUrl("http://www.facebook.com/");

        String data = "<html> <body><h1>Hello Android Developers!</h1></body> </html>";
        webHtmlCssView.loadData(data, "text/html", "UTF-8");



    }

    @Override
    public void onClick(View view) {

        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("Do you really want to close this app? :/ ")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                        //Toast.makeText(MainActivity.this, "You choose YES action for alertbox", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                //Toast.makeText(MainActivity.this, "You choose NO action for alertbox", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = alert_builder.create();
        alertDialog.setTitle("Alert !!!");
        alertDialog.show();




    }
}
