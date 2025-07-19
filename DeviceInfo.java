
package com.swago.path;

public class DeviceInfo {
    public static String getDeviceName() {
        return android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
    }
}
