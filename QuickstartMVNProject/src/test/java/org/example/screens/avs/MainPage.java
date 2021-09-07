package org.example.screens.avs;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertEquals;

public class MainPage extends CommonPage {
    By byAdditionalElement = By.cssSelector(".additional-fields");
    By byAddAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > div:nth-child(3) > a");
    By byCountAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > span");
    By bySearchButton = By.className("avia-form__submit");
    By byDepartureAirportValidator = By.cssSelector("form > div.avia-form__field.--destination > div > div");
    By byDepartureAirportField = By.id("destination");

    public void clickAdditionalElement() {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byAdditionalElement));
        element.click();
    }

    public void search() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(bySearchButton));
        element.click();
    }

    public void assertDepartureAirportErrorMessage(String error) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(byDepartureAirportValidator));
        assertEquals(error, element.getAttribute("data-error-message"));
    }

    public void setDepartureAirport(String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(byDepartureAirportField));
        element.sendKeys(text);
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
