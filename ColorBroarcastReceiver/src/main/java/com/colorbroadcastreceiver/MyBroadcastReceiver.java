package com.colorbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by raja on 17-02-2017.
 */

public class MyBroadcastReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

        int red=intent.getIntExtra("red",0);
        int green=intent.getIntExtra("green",0);
        int blue=intent.getIntExtra("blue",0);
        SharedPreferences sp = context.getSharedPreferences("colors", Context.MODE_APPEND);
        SharedPreferences.Editor ed = sp.edit();
        ed.putInt("red",red);
        ed.putInt("green",green);
        ed.putInt("blue",blue);
        ed.commit();
        //Toast.makeText(context, "red = "+green, Toast.LENGTH_SHORT).show();

        intent = new Intent(context,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
