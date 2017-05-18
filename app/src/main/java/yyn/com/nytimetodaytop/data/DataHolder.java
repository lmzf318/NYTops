package yyn.com.nytimetodaytop.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimi on 2017-05-17.
 */
public class DataHolder {
    private final static String TAG = "DataHolder";
    private List<TopsItem> tops = new ArrayList<>();
    private static DataHolder mInstance = null;

    public DataHolder() {

    }

    public static synchronized DataHolder getInstance(){
        if(mInstance == null){
            mInstance = new DataHolder();
        }

        return mInstance;
    }

    public void update(List<TopsItem> items) {
        tops = items;
    }

    public void append(List<TopsItem> items) {
        tops.addAll(0, items);
    }

    public int topsSize(){
        return tops.size();
    }

    public List<TopsItem> getTops() {
        return tops;
    }
}
