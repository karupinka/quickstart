package org.example.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.example.common.CommonTest;
import org.example.common.Web;
import org.example.screens.avs.MainPage;
import org.example.screens.avs.OfferPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AVSTest extends CommonTest {
    MainPage mainPage = new MainPage();
    OfferPage offerPage = new OfferPage();

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @AfterEach
    public void tearDown() {
        web.createBrowserLogs();
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
    @Owner("karupinka")
    @Epic("Search Form")
    @DisplayName("Валидация пустого поля Аэропорта прилета")
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
