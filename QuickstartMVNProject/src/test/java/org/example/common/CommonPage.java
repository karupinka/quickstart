package org.example.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.common.DriverInstance;

public abstract class CommonPage {
    protected WebDriver driver = DriverInstance.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);
}
