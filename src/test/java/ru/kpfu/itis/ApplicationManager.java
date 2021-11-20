package ru.kpfu.itis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.kpfu.itis.helper.LoginHelper;
import ru.kpfu.itis.helper.NavigationHelper;
import ru.kpfu.itis.helper.VideoHelper;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class ApplicationManager {
    private WebDriver driver;
    private final StringBuffer verificationErrors;
    private final String baseUrl;
    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private VideoHelper videoHelper;
    private static ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private ApplicationManager() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        verificationErrors = new StringBuffer();
        baseUrl = "https://school-sotka.herokuapp.com";

        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        videoHelper = new VideoHelper(this);
    }

    public static ApplicationManager getInstance() {
        ApplicationManager applicationManager = applicationManagerThreadLocal.get();

        if (applicationManager == null) {
            applicationManager = new ApplicationManager();
            applicationManager.getNavigationHelper().getHomePage();
            applicationManagerThreadLocal.set(applicationManager);
        }

        return applicationManager;
    }

    public void stop() {
        try {
            driver.quit();
        } catch (Exception ignore) {}

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public VideoHelper getVideoHelper() {
        return videoHelper;
    }
}