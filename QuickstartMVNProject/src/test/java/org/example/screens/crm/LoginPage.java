package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonPage {
    // By
    By byEmailField = By.name("_username");
    By byPasswordField = By.name("_password");
    By byLogin = By.id("_submit");

    public LoginPage setLogin(String text) {
        WebElement emailField = driver.findElement(byEmailField);
        emailField.sendKeys(text);
        return this;
    }

    public LoginPage setPassword(String text) {
        WebElement passwordField = driver.findElement(byPasswordField);
        passwordField.sendKeys(text);
        return this;
    }

    public LoginPage login() {
        WebElement loginButton = driver.findElement(byLogin);
        loginButton.click();
        return this;
    }
}
