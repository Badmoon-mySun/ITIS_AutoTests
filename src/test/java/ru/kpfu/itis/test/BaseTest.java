package ru.kpfu.itis.test;


import org.junit.After;
import org.junit.Before;
import ru.kpfu.itis.ApplicationManager;

public class BaseTest {
    protected ApplicationManager applicationManager;

    @Before
    public void setUp() {
        applicationManager = ApplicationManager.getInstance();
    }
}
