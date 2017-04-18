package yyn.com.nytimetodaytop.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import yyn.com.nytimetodaytop.TopsApp;

import java.util.UUID;

/**
 * Created by jiy on 2017-04-14.
 */
public class DeviceUtil {
    public static String getDeviceID() {
        final TelephonyManager tm = (TelephonyManager) TopsApp.getInstance().getContext().getSystemService(Context.TELEPHONY_SERVICE);

        final String tmDevice, tmSerial, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(
                TopsApp.getInstance().getContext().getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID
        );

        UUID deviceUuid = new UUID(androidId.hashCode(), ((long) tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString();
    }

    // get current network availablity
    public static boolean isNetworkConnected(Context ctx) {
        ConnectivityManager connManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = connManager.getActiveNetworkInfo();
        return (null != ni) && ni.isAvailable();
    }
}
