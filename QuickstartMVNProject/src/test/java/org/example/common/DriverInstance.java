package org.example.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverInstance {
    private static WebDriver driver = null;
    private static EventFiringWebDriver eventFiringWebDriver = null;


    private DriverInstance() {
    }

    public static EventFiringWebDriver getInstance() {
        if(driver == null) {
            driver = new ChromeDriver();
            eventFiringWebDriver = new EventFiringWebDriver(driver);
        }

        return eventFiringWebDriver;
    }
}
