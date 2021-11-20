package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kpfu.itis.ApplicationManager;
import ru.kpfu.itis.model.QuestionData;
import ru.kpfu.itis.model.TestData;

import java.util.concurrent.TimeUnit;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class TestHelper extends BaseHelper {
    public TestHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void addTest(TestData testData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.id("id_name")).click();
        driver.findElement(By.id("id_name")).clear();
        driver.findElement(By.id("id_name")).sendKeys(testData.getTitle());
        driver.findElement(By.id("id_theme")).click();
        driver.findElement(By.id("id_theme")).clear();
        driver.findElement(By.id("id_theme")).sendKeys(testData.getTheme());
        driver.findElement(By.id("id_subject")).click();
        new Select(driver.findElement(By.id("id_subject"))).selectByVisibleText(testData.getSubject());

        int i = 0;
        for (QuestionData question : testData.getQuestions()) {
            driver.findElement(By.id("addButton")).click();
            i++;
            Thread.sleep(1000);

            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(1000);
            driver.findElement(By.id("question_text_" + i)).click();
            driver.findElement(By.id("question_text_" + i)).clear();
            driver.findElement(By.id("question_text_" + i)).sendKeys(question.getQuestion());

            driver.findElement(By.id("answer_" + i)).click();
            driver.findElement(By.id("answer_" + i)).clear();
            driver.findElement(By.id("answer_" + i)).sendKeys(question.getAnswer());

            driver.findElement(By.id("source_" + i)).click();
            driver.findElement(By.id("source_" + i)).clear();
            driver.findElement(By.id("source_" + i)).sendKeys(question.getMark());
        }

        js.executeScript("window.scrollTo(0, 0);");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div[2]/button")).click();
    }
}
