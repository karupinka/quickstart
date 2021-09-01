package org.example.screens.avs;

import org.example.common.CommonScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;

public class MainScreen extends CommonScreen {
    By byAdditionalElement = By.cssSelector(".additional-fields");
    By byAddAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > div:nth-child(3) > a");
    By byCountAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > span");
    By byOfferHeaderElement = By.cssSelector(".page-header__form-set");

    public void clickAdditionalElement() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byAdditionalElement));
        element.click();
    }

    public void clickHeaderElement() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byOfferHeaderElement));
        element.click();
    }

    public void assertAdultPassengerCount(int count) {
        WebElement element = driver.findElement(byCountAdultPassengerElement);
        assertEquals("" + count, element.getText());
    }

    public void addAdultPassenger(int count) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byAddAdultPassengerElement));
        for (int i = 0; i < count; i++) {
            element.click();
        }
    }
}
