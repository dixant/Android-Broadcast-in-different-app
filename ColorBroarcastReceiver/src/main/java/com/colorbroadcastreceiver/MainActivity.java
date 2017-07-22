package com.colorbroadcastreceiver;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int red,green,blue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = this.getSharedPreferences("colors", 0);
        red=settings.getInt("red",0);
        green=settings.getInt("green",0);
        blue=settings.getInt("blue",0);
        //Toast.makeText(this, "red = "+red, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "red = "+red, Toast.LENGTH_SHORT).show();

        ImageView im = (ImageView) findViewById(R.id.img);
        im.setBackgroundColor(Color.rgb(red,green,blue));
    }
}
