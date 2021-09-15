package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactPage extends CommonPage {
    // By
    By byAddContactButton = By.xpath("//a[text()=\"Создать контактное лицо\"]");
    By byCreateAlert = By.xpath("//*[text()=\"Контактное лицо сохранено\"]");

    public ContactPage clickAddContactButton() {
        WebElement addContactButton = wait.until(ExpectedConditions.presenceOfElementLocated(byAddContactButton));
        addContactButton.click();
        return this;
    }

    public ContactPage assertCreateNewContact() {
        WebElement createAlert = (wait.until(ExpectedConditions.elementToBeClickable(byCreateAlert)));
        assertTrue(createAlert.isDisplayed());
        return this;
    }
}
