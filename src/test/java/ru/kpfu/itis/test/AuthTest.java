package ru.kpfu.itis.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.kpfu.itis.model.AccountData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class AuthTest extends BaseTest {

    @Test
    public void testAuth() throws Exception {
        applicationManager.getNavigationHelper().getLoginPage();
        AccountData accountData = new AccountData("admin@admin.ru", "Admin123");
        applicationManager.getLoginHelper().doLogin(accountData);
    }
}
