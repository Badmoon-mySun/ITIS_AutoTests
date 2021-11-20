package ru.kpfu.itis.helper;

import org.openqa.selenium.By;
import ru.kpfu.itis.ApplicationManager;
import ru.kpfu.itis.model.AccountData;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class LoginHelper extends BaseHelper {
    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void doLogin(AccountData accountData) {
        driver.findElement(By.id("id_username")).click();
        driver.findElement(By.id("id_username")).clear();
        driver.findElement(By.id("id_username")).sendKeys(accountData.getUsername());
        driver.findElement(By.id("id_password")).click();
        driver.findElement(By.id("id_password")).clear();
        driver.findElement(By.id("id_password")).sendKeys(accountData.getPassword());
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
