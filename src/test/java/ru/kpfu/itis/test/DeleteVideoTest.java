package ru.kpfu.itis.test;

import org.junit.jupiter.api.Test;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class DeleteVideoTest extends AuthBase {

    @Test
    public void testAddVideo() {
        applicationManager.getNavigationHelper().getVideoCreationPage();

        applicationManager.getVideoHelper().clickDeleteLastVideo();
    }
}