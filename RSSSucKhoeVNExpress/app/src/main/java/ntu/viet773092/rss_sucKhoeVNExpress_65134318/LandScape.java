package ntu.viet773092.rss_sucKhoeVNExpress_65134318;

public class LandScape {
    private String imageUrl; // URL Image
    private String title;
    private String summary;

    // Constructor
    public LandScape(String imageUrl, String title, String summary) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.summary = summary;
    }

    // Getters và Setters
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}