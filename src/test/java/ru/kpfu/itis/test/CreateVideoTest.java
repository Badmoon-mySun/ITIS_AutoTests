package ru.kpfu.itis.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.model.VideoCreateData;
import ru.kpfu.itis.model.VideoData;


public class CreateVideoTest extends BaseTest {

    @Test
    public void testAddVideo() throws Exception {
        applicationManager.getNavigationHelper().getVideoCreationPage();
        VideoCreateData videoData = new VideoCreateData("https://www.youtube.com/embed/JRHUJdRZM-E");

        applicationManager.getVideoHelper().addVideo(videoData);

        VideoData createdVideoData = applicationManager.getVideoHelper().getLastVideoData();

        Assert.assertEquals(videoData.getUrl(), createdVideoData.getUrl());
    }
}

