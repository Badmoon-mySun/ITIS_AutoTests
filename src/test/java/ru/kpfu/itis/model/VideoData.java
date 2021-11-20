package ru.kpfu.itis.model;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class VideoData {
    private String title;
    private String url;

    public VideoData(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
