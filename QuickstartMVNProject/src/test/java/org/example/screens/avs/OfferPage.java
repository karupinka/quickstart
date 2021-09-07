package org.example.screens.avs;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import java.util.Set;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OfferPage extends CommonPage {
    By byOriginSelectedValueElement = By.name("offers_filter_origin");
    By byDestinationSelectedValueElement = By.name("offers_filter_destination");

    public void assertOriginSelectedValue(String expected) {
        String value = driver.findElement(byOriginSelectedValueElement).getAttribute("value");
//        String value = driver.findElement(byOriginSelectedValueElement).getText();
        assertThat(value, is(expected));
    }

    public void assertDestinationSelectedValue(String expected) {
        String value = driver.findElement(byDestinationSelectedValueElement).getAttribute("value");
        //String value = driver.findElement(byDestinationSelectedValueElement).getText();

        assertThat(expected, is(expected));
    }
}
