package ru.kpfu.itis.model;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class VideoCreateData {
    private String url;

    public VideoCreateData(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
