package yyn.com.nytimetodaytop.util;

import yyn.com.nytimetodaytop.server.TopsResponse.NewsItem;
import yyn.com.nytimetodaytop.server.TopsResponse.TopsResponse;
import yyn.com.nytimetodaytop.ui.data.TopsItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiy on 2017-04-18.
 */
public class DataUtil {
    // convert received data to list view items
    public static List<TopsItem> TopsToListItem(NewsItem[] source){
        List<TopsItem> desList = new ArrayList<>();
        for(NewsItem item:source){
            desList.add(new TopsItem(item.section,item.title,item.abstractStr,item.multimedia.length==0?null:item.multimedia[0].url));
        }
        return desList;
    }

    public static boolean isEmpty(String str){
        return ((null == str) || (str.length() < 1));
    }
}
