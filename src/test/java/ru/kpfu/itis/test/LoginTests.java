package ru.kpfu.itis.test;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.kpfu.itis.Settings;
import ru.kpfu.itis.model.AccountData;
import ru.kpfu.itis.model.TestData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class LoginTests extends TestBase {
    @BeforeEach
    public void logout() {
        applicationManager.getLoginHelper().logout();
    }

    @Test
    public void loginWithValidData() throws Exception {
        AccountData accountData = new AccountData(Settings.getLogin(), Settings.getPassword());

        applicationManager.getLoginHelper().doLogin(accountData);

        assertTrue(applicationManager.getLoginHelper().isLoggedIn(accountData.getEmail()));
    }

    @Test
    public void loginWithInvalidData() throws Exception {
        AccountData accountData = new AccountData("test@test.ru", "123");

        applicationManager.getLoginHelper().doLogin(accountData);

        assertFalse(applicationManager.getLoginHelper().isLoggedIn());
    }
}
