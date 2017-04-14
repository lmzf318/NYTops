package yyn.com.nytimetodaytop.server;

import android.util.Log;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;
import cz.msebera.android.httpclient.Header;
import yyn.com.nytimetodaytop.values.Constants;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsApi {
    private final static String TAG = "TopsApi";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void getHomeTops(){
        getTops(Constants.CAT_HOME);
    }

    private static void getTops(String type){
        RequestParams params = new RequestParams();
        params.put("api-key", Constants.NYTOPS_API_KEY);

        client.get(Constants.BASE_URL + type + "." + Constants.FORMAT, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(responseBody!=null&&responseBody.length>0){
                    String response = new String(responseBody);
                    Log.d(TAG,"onSuccess: status: " + statusCode + ", response: " + response);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG,"onFailure: status: " + statusCode);
                if(responseBody!=null&&responseBody.length>0){
                    String response = new String(responseBody);
                    Log.d(TAG,"response: " + response);
                }
            }
        });
    }
}
