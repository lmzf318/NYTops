package yyn.com.nytimetodaytop.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Jimi on 2017-05-17.
 */
public class ActionUtil {
    public static void openUrl(Context context, String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }
}
