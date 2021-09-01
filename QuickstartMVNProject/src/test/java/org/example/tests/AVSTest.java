package org.example.tests;

import org.example.common.CommonScreen;
import org.example.screens.avs.MainScreen;
import org.example.screens.avs.OfferScreen;
import org.junit.After;
import org.junit.Test;

public class AVSTest {
    CommonScreen commonScreen = new CommonScreen();
    MainScreen mainScreen = new MainScreen();
    OfferScreen offerScreen = new OfferScreen();

    @After
    public void tearDown() {
        commonScreen.close();
    }

    @Test
    public void testMaximumNumberOfAdultsPassengers()
    {
        commonScreen.get("https://www.aviasales.ru/");
        mainScreen.clickAdditionalElement();
        mainScreen.addAdultPassenger(10);
        mainScreen.assertAdultPassengerCount(9);
    }

    @Test
    public void testCheckAllSpecialOfferParameters()
    {
        commonScreen.get("https://www.aviasales.ru/offers");
        offerScreen.assertOriginSelectedValue("all");
        offerScreen.assertDestinationSelectedValue("all");
    }
}
