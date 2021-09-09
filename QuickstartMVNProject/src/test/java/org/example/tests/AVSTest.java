package org.example.tests;

import org.example.common.Web;
import org.example.screens.avs.MainPage;
import org.example.screens.avs.OfferPage;
import org.junit.After;
import org.junit.Test;

public class AVSTest {
    Web web = new Web();
    MainPage mainPage = new MainPage();
    OfferPage offerPage = new OfferPage();

    @After
    public void tearDown() {
        web.close();
    }

    @Test
    public void testMaximumNumberOfAdultsPassengers()
    {
        web.get("https://www.aviasales.ru/");
        mainPage.assertAdultPassengerCount(1)
                .clickAdditionalElement()
                .addAdultPassenger(10)
                .assertAdultPassengerCount(9);
    }

    @Test
    public void testCheckAllSpecialOfferParameters()
    {
        web.get("https://www.aviasales.ru/offers");
        offerPage
                .assertOriginSelectedValue("all")
                .assertDestinationSelectedValue("all");
    }

    @Test
    public void testOriginAirportEmptyFieldValidation()
    {
        web.get("https://www.aviasales.ru/");
        mainPage
                .search()
                .assertDepartureAirportErrorMessage("Укажите город прибытия");
    }

    @Test
    public void testOriginAirportInvalidSymbolsFieldValidation()
    {
        web.get("https://www.aviasales.ru/");
        mainPage
                .setDepartureAirport("999999")
                .search()
                .assertDepartureAirportErrorMessage("Укажите город прибытия");
    }
}
