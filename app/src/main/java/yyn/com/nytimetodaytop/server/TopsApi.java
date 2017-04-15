package yyn.com.nytimetodaytop.server;

import android.util.Log;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;
import yyn.com.nytimetodaytop.server.TopsResponse.TopsResponse;
import yyn.com.nytimetodaytop.values.Constants;

import java.util.ArrayList;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsApi {
    public interface TopsResListener {
        void onSuccess(TopsResponse response);

        void onFailure(int status);
    }

    private final static String TAG = "TopsApi";
    private static AsyncHttpClient client = new AsyncHttpClient();
    private static TopsResListener mListener = null;

    public static synchronized void setResListener(TopsResListener listener) {
        mListener = listener;
    }

    public static void getHomeTops() {
        getTops(Constants.CAT_HOME);
    }

    private static void getTops(String type) {
        RequestParams params = new RequestParams();
        params.put("api-key", Constants.NYTOPS_API_KEY);

        client.get(Constants.BASE_URL + type + "." + Constants.FORMAT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (responseBody != null && responseBody.length > 0) {
                    String response = new String(responseBody);
                    Log.d(TAG, "onSuccess: status: " + statusCode + ", response: " + response);
                    TopsResponse topsResponse = new Gson().fromJson(response.replace(Constants.JSON_STR_TARGET, Constants.JSON_STR_DESTINATION), TopsResponse.class);
                    Log.d(TAG, "onSuccess: json obj " + topsResponse.toString());

                    if (mListener != null) {
                        mListener.onSuccess(topsResponse);
                    }
                } else {
                    if (mListener != null) {
                        mListener.onFailure(statusCode);
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "onFailure: status: " + statusCode);
                if (responseBody != null && responseBody.length > 0) {
                    String response = new String(responseBody);
                    Log.d(TAG, "response: " + response);
                }

                if (mListener != null) {
                    mListener.onFailure(statusCode);
                }
            }
        });
    }
}
