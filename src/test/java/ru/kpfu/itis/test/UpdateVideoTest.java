package ru.kpfu.itis.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.model.VideoData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class UpdateVideoTest extends BaseTest {

    @Test
    public void testEditVideo() throws Exception {
        applicationManager.getNavigationHelper().getVideoCreationPage();
        applicationManager.getVideoHelper().clickEditLastVideo();

        VideoData videoData = new VideoData("Test", "https://www.youtube.com/embed/JRHUJdRZM-E");
        applicationManager.getVideoHelper().editVideo(videoData);

        applicationManager.getNavigationHelper().getVideoCreationPage();
        VideoData updatedVideoData = applicationManager.getVideoHelper().getLastVideoData();

        Assert.assertEquals(videoData.getTitle(), updatedVideoData.getTitle());
        Assert.assertEquals(videoData.getUrl(), updatedVideoData.getUrl());
    }
}
