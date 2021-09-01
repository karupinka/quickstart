package org.example.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonScreen {
    protected WebDriver driver = DriverInstance.getInstance();
    protected WebDriverWait wait = new WebDriverWait(driver, 10);

    public void get(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }
}
