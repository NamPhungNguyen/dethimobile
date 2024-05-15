package com.example.dethimobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplanMode extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

        // Hiển thị Toast Message tương ứng
        if (isAirplaneModeOn) {
            Toast.makeText(context, "airplane mode vua bat", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "airplane mode vua tat", Toast.LENGTH_SHORT).show();
        }
    }
}
