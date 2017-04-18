package yyn.com.nytimetodaytop.ui.data;

/**
 * Created by jiy on 2017-04-12.
 */
public class TopsItem {
    private String section = null;
    private String title = null;
    private String abs = null;
    private String imageUrl = null;

    public TopsItem(String section, String title, String abs, String imageUrl) {
        this.section = section;
        this.title = title;
        this.abs = abs;
        this.imageUrl = imageUrl;
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
