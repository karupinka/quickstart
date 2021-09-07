package org.example.tests;

import org.example.common.Web;
import org.example.screens.avs.MainPage;
import org.example.screens.avs.OfferPage;
import org.junit.After;
import org.junit.Test;

public class AVSTest {
    Web web = new Web();
    MainPage mainScreen = new MainPage();
    OfferPage offerScreen = new OfferPage();

    @After
    public void tearDown() {
        web.close();
    }

    @Test
    public void testMaximumNumberOfAdultsPassengers()
    {
        web.get("https://www.aviasales.ru/");
        mainScreen.assertAdultPassengerCount(1);
        mainScreen.clickAdditionalElement();
        mainScreen.addAdultPassenger(10);
        mainScreen.assertAdultPassengerCount(9);
    }

    @Test
    public void testCheckAllSpecialOfferParameters()
    {
        web.get("https://www.aviasales.ru/offers");
        offerScreen.assertOriginSelectedValue("all");
        offerScreen.assertDestinationSelectedValue("all");
    }

    @Test
    public void testOriginAirportEmptyFieldValidation()
    {
        web.get("https://www.aviasales.ru/");
        mainScreen.search();
        mainScreen.assertDepartureAirportErrorMessage("Укажите город прибытия");
    }

    @Test
    public void testOriginAirportInvalidSymbolsFieldValidation()
    {
        web.get("https://www.aviasales.ru/");
        mainScreen.setDepartureAirport("999999");
        mainScreen.search();
        mainScreen.assertDepartureAirportErrorMessage("Укажите город прибытия");
    }
}
