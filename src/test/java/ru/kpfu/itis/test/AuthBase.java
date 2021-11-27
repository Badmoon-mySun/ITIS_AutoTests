package ru.kpfu.itis.test;

import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.Settings;
import ru.kpfu.itis.model.AccountData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class AuthBase extends TestBase {

    @BeforeAll
    protected static void setUpAuth() {
        applicationManager.getNavigationHelper().getLoginPage();
        AccountData accountData = new AccountData(Settings.getLogin(), Settings.getPassword());
        applicationManager.getLoginHelper().doLogin(accountData);
    }
}
