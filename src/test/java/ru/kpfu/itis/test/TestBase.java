package ru.kpfu.itis.test;

import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.ApplicationManager;
import ru.kpfu.itis.TestDataGenerator;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class TestBase {
    protected static ApplicationManager applicationManager;

    @BeforeAll
    protected static void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
