package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class MyProjectPage extends CommonPage {
    By byCreateNewProjectButton = By.xpath("//a[text()=\"Создать проект\"]");
    By byCreateAlert = By.xpath("//*[text()=\"Проект сохранен\"]");

    public void clickCreateNewProjectButton() {
        WebElement createNewProjectButton = wait.until(ExpectedConditions.presenceOfElementLocated(byCreateNewProjectButton));
        createNewProjectButton.click();
    }

    public void assertCreateNewContact() {
        WebElement element = (wait.until(ExpectedConditions.elementToBeClickable(byCreateAlert)));
        assertTrue(element.isDisplayed());
    }
}
