package ru.kpfu.itis.test;

import org.junit.jupiter.api.Test;

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