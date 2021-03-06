package org.ironworkschurch.eli.churchapp.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.ironworkschurch.eli.churchapp.activities.TimeSetActivity;

/**
 * Created by Eli on 2/2/2018.
 */
public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction() != null && intent.getAction().equalsIgnoreCase("BOOT_COMPLETED"))
            return;

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);

        //Just set them all. The method is engineered to deal with any odd cases.
        TimeSetActivity.setThreeAlarms(context, sp.getString("morningTime", ""), sp.getString("afternoonTime", ""), sp.getString("eveningTime", ""));
    }
}