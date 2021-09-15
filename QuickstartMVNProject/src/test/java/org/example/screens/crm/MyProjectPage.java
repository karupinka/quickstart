package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyProjectPage extends CommonPage {
    // By
    By byCreateNewProjectButton = By.xpath("//a[text()=\"Создать проект\"]");
    By byCreateAlert = By.xpath("//*[text()=\"Проект сохранен\"]");

    public MyProjectPage clickCreateNewProjectButton() {
        WebElement createNewProjectButton = wait.until(ExpectedConditions.presenceOfElementLocated(byCreateNewProjectButton));
        createNewProjectButton.click();
        return this;
    }

    public MyProjectPage assertCreateNewContact() {
        WebElement createdAlert = (wait.until(ExpectedConditions.elementToBeClickable(byCreateAlert)));
        assertTrue(createdAlert.isDisplayed());
        return this;
    }
}
