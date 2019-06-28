package com.meditation.metime;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.meditation.metime.services.GooglePlayExpansionDownloaderService;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;

public class DownloadReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            DownloaderClientMarshaller.startDownloadServiceIfRequired(context, intent, GooglePlayExpansionDownloaderService.class);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}

