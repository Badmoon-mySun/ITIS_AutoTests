package ru.kpfu.itis.test;

import org.junit.jupiter.api.Test;
import ru.kpfu.itis.model.VideoData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class UpdateVideoTest extends AuthBase {

    @Test
    public void testEditVideo() throws Exception {
        applicationManager.getNavigationHelper().getVideoCreationPage();
        applicationManager.getVideoHelper().clickEditLastVideo();

        VideoData videoData = new VideoData("Test", "https://www.youtube.com/embed/JRHUJdRZM-E");
        applicationManager.getVideoHelper().editVideo(videoData);

        applicationManager.getNavigationHelper().getVideoCreationPage();
        VideoData updatedVideoData = applicationManager.getVideoHelper().getLastVideoData();

        assertEquals(videoData.getTitle(), updatedVideoData.getTitle());
        assertEquals(videoData.getUrl(), updatedVideoData.getUrl());
    }
}
