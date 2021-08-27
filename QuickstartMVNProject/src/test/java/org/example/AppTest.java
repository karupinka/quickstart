package org.example;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    WebDriverWait wait;
    String expectedEmail = "repinanr@yandex.ru";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testEnterEmailInLoginInput()
    {
        driver.get("https://crm.geekbrains.space/");

        WebElement emailField = driver.findElement(By.name("_username"));
        emailField.sendKeys(expectedEmail);
        String resultString = emailField.getAttribute("value");
        assertEquals(expectedEmail, resultString);
    }
}
