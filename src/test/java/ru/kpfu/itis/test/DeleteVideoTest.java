package ru.kpfu.itis.test;

import org.junit.Assert;
import org.junit.Test;
import ru.kpfu.itis.model.VideoCreateData;
import ru.kpfu.itis.model.VideoData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class DeleteVideoTest extends BaseTest {

    @Test
    public void testAddVideo() throws Exception {
        applicationManager.getNavigationHelper().getVideoCreationPage();

        applicationManager.getVideoHelper().clickDeleteLastVideo();
    }
}