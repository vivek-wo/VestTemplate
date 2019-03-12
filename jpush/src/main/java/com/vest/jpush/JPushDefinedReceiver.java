package com.vest.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

public class JPushDefinedReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.w("[JPushDefinedReceiver]", "-->> onReceive: " + intent.getAction());
        if (intent.getAction().equals(JPushInterface.ACTION_NOTIFICATION_OPENED)) {
            Intent intentMain = new Intent("com.vest.template.sample.intent.NOTIFICATION_OPENED");
            context.startActivity(intentMain);
        }
    }
}
