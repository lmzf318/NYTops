package yyn.com.nytimetodaytop.server.TopsResponse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jiy on 2017-04-14.
 */
public class TopsResponse {
    public String status;
    public String copyright;
    public String section;
    public String last_updated;
    public int num_results;
    public NewsItem[] results;

    @Override
    public String toString() {
        return "TopsResponse{" +
                "status='" + status + '\'' +
                ", copyright='" + copyright + '\'' +
                ", section='" + section + '\'' +
                ", last_updated='" + last_updated + '\'' +
                ", num_results=" + num_results +
                ", results=" + Arrays.toString(results) +
                '}';
    }
}
