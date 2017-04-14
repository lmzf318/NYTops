package yyn.com.nytimetodaytop;

import android.app.Application;
import android.content.Context;
import yyn.com.nytimetodaytop.util.DeviceUtil;

/**
 * Created by jiy on 2017-04-14.
 */
public class TopsApp extends Application {
    private final static String TAG = "TopsApp";
    private static TopsApp mInstance = null;
    private String deviceId = "unknown";

    public TopsApp() {
        mInstance = this;
    }

    public static synchronized TopsApp getInstance() {
        if (mInstance == null) {
            mInstance = new TopsApp();
        }

        return mInstance;
    }

    public static Context getContext(){
        return mInstance.getApplicationContext();
    }

    public void extractDeviceID(){
        deviceId = DeviceUtil.getDeviceID();
    }

    public String getDeviceID(){ return deviceId;}
}
