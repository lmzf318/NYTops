package yyn.com.nytimetodaytop.server.TopsResponse;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jiy on 2017-04-14.
 */
public class NewsItem {
    public String section;
    public String subsection;
    public String title;
    public String abstractStr;
    public String url;
    public String byline;
    public String item_type;
    public String updated_date;
    public String created_date;
    public String published_date;
    public String material_type_facet;
    public String kicker;
    public String[] des_facet;
    public String[] org_facet;
    public String[] per_facet;
    public String[] geo_facet;
    public NewsItemImage[] multimedia;

    @Override
    public String toString() {
        return "NewsItem{" +
                "section='" + section + '\'' +
                ", subsection='" + subsection + '\'' +
                ", title='" + title + '\'' +
                ", abstractStr='" + abstractStr + '\'' +
                ", url='" + url + '\'' +
                ", byline='" + byline + '\'' +
                ", item_type='" + item_type + '\'' +
                ", updated_date='" + updated_date + '\'' +
                ", created_date='" + created_date + '\'' +
                ", published_date='" + published_date + '\'' +
                ", material_type_facet='" + material_type_facet + '\'' +
                ", kicker='" + kicker + '\'' +
                ", des_facet=" + Arrays.toString(des_facet) +
                ", org_facet=" + Arrays.toString(org_facet) +
                ", per_facet=" + Arrays.toString(per_facet) +
                ", geo_facet=" + Arrays.toString(geo_facet) +
                ", multimedia=" + Arrays.toString(multimedia) +
                '}';
    }
}
