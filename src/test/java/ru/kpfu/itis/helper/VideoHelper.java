package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import ru.kpfu.itis.ApplicationManager;
import ru.kpfu.itis.model.VideoCreateData;
import ru.kpfu.itis.model.VideoData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class VideoHelper extends BaseHelper {

    public VideoHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addVideo(VideoCreateData videoData) {
        driver.findElement(By.name("new_video")).click();
        driver.findElement(By.name("new_video")).clear();
        driver.findElement(By.name("new_video")).sendKeys(videoData.getUrl());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void editVideo(VideoData videoData) {
        driver.findElement(By.id("id_url")).click();
        driver.findElement(By.id("id_url")).clear();
        driver.findElement(By.id("id_url")).sendKeys(videoData.getUrl());
        driver.findElement(By.id("id_title")).click();
        driver.findElement(By.id("id_title")).clear();
        driver.findElement(By.id("id_title")).sendKeys(videoData.getTitle());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void clickEditLastVideo() {
        driver.findElement(By.linkText("Редактировать")).click();
    }

    public void clickDeleteLastVideo() {
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)=" +
                        "'Редактировать'])[1]/following::button[1]")
        ).click();
    }

    public VideoData getLastVideoData() {
        String title = driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/div/strong")).getText();
        String url = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[2]/div[1]/p/a")).getText();

        return new VideoData(title, url);
    }
}
