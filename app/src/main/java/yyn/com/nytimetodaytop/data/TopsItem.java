package yyn.com.nytimetodaytop.data;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsItem {
    private String section = null;
    private String title = null;
    private String abs = null;
    private String imageUrl = null;
    private String url = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TopsItem(String section, String title, String abs, String imageUrl, String url) {
        this.section = section;
        this.title = title;
        this.abs = abs;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
