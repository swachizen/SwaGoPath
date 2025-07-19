
package com.swago.path;

import android.content.Context;
import android.util.Log;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Uploader {
    public static void uploadDeviceInfo(Context context) {
        new Thread(() -> {
            try {
                String name = DeviceInfo.getDeviceName();
                URL url = new URL("https://your-swago-web.com/register");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                String postData = "device_name=" + name;
                OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
                writer.write(postData);
                writer.flush();
                writer.close();

                int responseCode = conn.getResponseCode();
                Log.d("SwaGoPath", "Response: " + responseCode);
            } catch (Exception e) {
                Log.e("SwaGoPath", "Upload failed", e);
            }
        }).start();
    }
}
