package ru.kpfu.itis.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.kpfu.itis.ApplicationManager;

/**
 * @author Anvar Khasanov
 * student of ITIS KFU
 */
public class BaseTest {
    protected static ApplicationManager applicationManager;

    @BeforeAll
    protected static void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }


//    protected static void down() {
//        applicationManager.stop();
//    }
}
