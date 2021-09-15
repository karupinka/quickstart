package org.example.screens.avs;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MainPage extends CommonPage {
    // By
    By byAdditionalElement = By.cssSelector(".additional-fields");
    By byAddAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > div:nth-child(3) > a");
    By byCountAdultPassengerElement = By.cssSelector("div.additional-fields__passengers-wrap > div:nth-child(1) > div.additional-fields__passenger-control-wrap > span");
    By bySearchButton = By.className("avia-form__submit");
    By byDepartureAirportValidator = By.cssSelector("form > div.avia-form__field.--destination > div > div");
    By byDepartureAirportField = By.id("destination");

    public MainPage clickAdditionalElement() {
        WebElement additionalElement = wait.until(ExpectedConditions.presenceOfElementLocated(byAdditionalElement));
        additionalElement.click();
        return this;
    }

    public MainPage search() {
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(bySearchButton));
        searchButton.click();
        return this;
    }

    public MainPage assertDepartureAirportErrorMessage(String error) {
        WebElement departureAirportValidator = wait.until(ExpectedConditions.presenceOfElementLocated(byDepartureAirportValidator));
        assertEquals(error, departureAirportValidator.getAttribute("data-error-message"));
        return this;
    }

    public MainPage setDepartureAirport(String text) {
        WebElement departureAirportField = wait.until(ExpectedConditions.elementToBeClickable(byDepartureAirportField));
        departureAirportField.sendKeys(text);
        return this;
    }

    public MainPage assertAdultPassengerCount(int count) {
        WebElement countAdultPassengerElement = driver.findElement(byCountAdultPassengerElement);
        assertEquals("" + count, countAdultPassengerElement.getText());
        return this;
    }

    public MainPage addAdultPassenger(int count) {
        WebElement addAdultPassengerElement =  wait.until(ExpectedConditions.presenceOfElementLocated(byAddAdultPassengerElement));
        for (int i = 0; i < count; i++) {
            addAdultPassengerElement.click();
        }
        return this;
    }
}
