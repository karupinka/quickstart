package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonPage {
    By byEmailField = By.name("_username");
    By byPasswordField = By.name("_password");
    By byLogin = By.id("_submit");

    public void setLogin(String text) {
        WebElement emailField = driver.findElement(byEmailField);
        emailField.sendKeys(text);
    }

    public void setPassword(String text) {
        WebElement passwordField = driver.findElement(byPasswordField);
        passwordField.sendKeys(text);
    }

    public void login() {
        WebElement loginButton = driver.findElement(byLogin);
        loginButton.click();
    }
}
