package com.colorbroadcastsender;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class MainActivity extends AppCompatActivity {

    DiscreteSeekBar seekRed,seekGreen,seekBlue;
    ImageView img;
    Button setColor;
    //TextView valueRed,valueGreen,valueBlue;
    static int red,green,blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*valueRed = (TextView) findViewById(R.id.valueRed);
        valueGreen = (TextView) findViewById(R.id.valueGreen);
        valueBlue = (TextView) findViewById(R.id.valueBlue);*/

        seekRed = (org.adw.library.widgets.discreteseekbar.DiscreteSeekBar) findViewById(R.id.seekRed);
        seekGreen = (org.adw.library.widgets.discreteseekbar.DiscreteSeekBar) findViewById(R.id.seekGreen);
        seekBlue = (org.adw.library.widgets.discreteseekbar.DiscreteSeekBar) findViewById(R.id.seekBlue);



        seekRed.setMax(255);
        seekGreen.setMax(255);
        seekBlue.setMax(255);
        seekRed.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                red = value;
               // valueRed.setText(String.valueOf(value));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
        seekGreen.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                green = value;
               // valueGreen.setText(String.valueOf(value));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
        seekBlue.setOnProgressChangeListener(new DiscreteSeekBar.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(DiscreteSeekBar seekBar, int value, boolean fromUser) {
                blue = value;
               // valueBlue.setText(String.valueOf(value));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

            }
        });
       /* seekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                red = i;
                valueRed.setText(String.valueOf(i));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                green = i;
                valueGreen.setText(String.valueOf(i));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                blue = i;
                valueBlue.setText(String.valueOf(i));
                img.setBackgroundColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });*/
        img = (ImageView) findViewById(R.id.setImg);
        setColor = (Button) findViewById(R.id.buttonSetColor);
        setColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColor();
            }
        });
    }

    private void setColor()
    {
        Toast.makeText(this, "red = "+red+" green = "+green+" blue = "+blue, Toast.LENGTH_SHORT).show();
        Intent i = new Intent();
        i.putExtra("red",red);
        i.putExtra("green",green);
        i.putExtra("blue",blue);
        i.setAction("colorChange");

        sendBroadcast(i);
    }
}
