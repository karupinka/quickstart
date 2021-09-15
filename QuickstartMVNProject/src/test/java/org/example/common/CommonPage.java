package org.example.common;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage {
    protected EventFiringWebDriver driver = DriverInstance.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);
}
