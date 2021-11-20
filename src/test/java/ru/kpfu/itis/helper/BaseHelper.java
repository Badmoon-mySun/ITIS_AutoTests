package ru.kpfu.itis.helper;

import org.openqa.selenium.*;
import ru.kpfu.itis.ApplicationManager;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class BaseHelper {
    protected boolean acceptNextAlert = true;
    protected ApplicationManager applicationManager;
    protected WebDriver driver;

    public BaseHelper(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
        this.driver = applicationManager.getDriver();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
