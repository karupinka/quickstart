package org.example.screens.crm;

import org.example.common.CommonScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class ContactScreen extends CommonScreen {
    By byAddContactButton = By.xpath("//a[text()=\"Создать контактное лицо\"]");
    By byCreateAlert = By.xpath("//*[text()=\"Контактное лицо сохранено\"]");


    public void clickAddContactButton() {
        WebElement addContactButton = wait.until(ExpectedConditions.presenceOfElementLocated(byAddContactButton));
        addContactButton.click();
    }

    public void assertCreateNewContact() {
        WebElement element = (wait.until(ExpectedConditions.elementToBeClickable(byCreateAlert)));
        assertTrue(element.isDisplayed());
    }
}
