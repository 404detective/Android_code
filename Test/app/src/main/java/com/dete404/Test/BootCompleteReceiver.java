package com.dete404.Test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompleteReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_LONG).show();
//        //TODO: This method is called when the BroadcastReceiver is receiving
//        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}