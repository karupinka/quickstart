package org.example.screens.avs;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OfferPage extends CommonPage {
    // By
    By byOriginSelectedValueElement = By.name("offers_filter_origin");
    By byDestinationSelectedValueElement = By.name("offers_filter_destination");

    public OfferPage assertOriginSelectedValue(String expected) {
        WebElement originSelectedValueElement = driver.findElement(byOriginSelectedValueElement);
        String value = originSelectedValueElement.getAttribute("value");
        assertThat(value, is(expected));
        return this;
    }

    public OfferPage assertDestinationSelectedValue(String expected) {
        WebElement destinationSelectedValueElement = driver.findElement(byDestinationSelectedValueElement);
        String value = destinationSelectedValueElement.getAttribute("value");
        assertThat(expected, is(expected));
        return this;
    }
}
