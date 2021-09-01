package org.example.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInstance {
    private static WebDriver driver = null;

    private DriverInstance() {
    }

    public static WebDriver getInstance() {
        if(driver == null) {
            driver = new ChromeDriver();
        }

        return driver;
    }
}
