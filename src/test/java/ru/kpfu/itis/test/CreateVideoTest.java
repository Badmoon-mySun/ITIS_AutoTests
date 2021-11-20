package ru.kpfu.itis.test;

import org.junit.jupiter.api.Test;
import ru.kpfu.itis.model.VideoCreateData;
import ru.kpfu.itis.model.VideoData;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class CreateVideoTest extends BaseTest {

    @Test
    public void testAddVideo() throws Exception {
        applicationManager.getNavigationHelper().getVideoCreationPage();
        VideoCreateData videoData = new VideoCreateData("https://www.youtube.com/embed/JRHUJdRZM-E");

        applicationManager.getVideoHelper().addVideo(videoData);

        VideoData createdVideoData = applicationManager.getVideoHelper().getLastVideoData();

        assertEquals(videoData.getUrl(), createdVideoData.getUrl());
    }
}

