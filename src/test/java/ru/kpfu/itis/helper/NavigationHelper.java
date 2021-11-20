package ru.kpfu.itis.helper;

import ru.kpfu.itis.ApplicationManager;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class NavigationHelper extends BaseHelper {
    private final String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }

    public void getHomePage() {
        this.driver.get(baseUrl);
    }

    public void getLoginPage() {
        this.driver.get(baseUrl + "/login");
    }

    public void getLogoutPage() {
        this.driver.get(baseUrl + "/logout");
    }

    public void getVideoCreationPage() {
        this.driver.get(baseUrl + "/teacher/video/subject-0");
    }
}
