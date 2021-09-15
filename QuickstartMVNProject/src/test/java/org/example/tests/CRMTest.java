package org.example.tests;

import org.example.common.CommonTest;
import org.example.common.TestWebDriverEventListener;
import org.example.common.Web;
import org.example.screens.crm.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class CRMTest extends CommonTest
{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ContactPage contactPage = new ContactPage();
    NewContactPage newContactPage = new NewContactPage();
    MyProjectPage myProjectPage = new MyProjectPage();
    NewProjectPage newProjectPage = new NewProjectPage();
    private WebDriverEventListener webDriverEventListener = new TestWebDriverEventListener();

    @BeforeEach
    public void setUp() {
        super.setUp();
        web.get("https://crm.geekbrains.space/");
        loginPage
                .setLogin("Applanatest1")
                .setPassword("Student2020!")
                .login();
    }

    @AfterEach
    public void tearDown() {
        web.close();
    }

    @Test
    public void testAddNewContact()
    {
        mainPage.choseContactItem();
        contactPage.clickAddContactButton();
        newContactPage.setLastName("Тестовый")
                .setFirstName("Юзер")
                .setOrganisation("«Все организации»")
                .setJob("qa")
                .saveData();
        contactPage.assertCreateNewContact();
    }

    @Test
    public void testCreateNewProject()
    {
        mainPage.choseMyProjectItem();
        myProjectPage.clickCreateNewProjectButton();
        newProjectPage.setName()
                .setOrganisation("«Все организации»")
                .setBusinessUnit(1)
                .setCurator(1)
                .setRP(1)
                .setAdministrator(1)
                .setManager(1)
                .saveData();
        myProjectPage.assertCreateNewContact();
    }
}
