package org.example.tests;
import org.example.common.Web;
import org.example.screens.crm.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CRMTest
{
    Web web = new Web();
    LoginPage loginScreen = new LoginPage();
    MainPage mainScreen = new MainPage();
    ContactPage contactScreen = new ContactPage();
    NewContactPage newContactScreen = new NewContactPage();
    MyProjectPage myProjectScreen = new MyProjectPage();
    NewProjectPage newProjectScreen = new NewProjectPage();

    @Before
    public void setUp() {
        web.get("https://crm.geekbrains.space/");
        loginScreen.setLogin("Applanatest1");
        loginScreen.setPassword("Student2020!");
        loginScreen.login();
    }

    @After
    public void tearDown() {
        web.close();
    }

    @Test
    public void testAddNewContact()
    {
        mainScreen.choseContactItem();
        contactScreen.clickAddContactButton();
        newContactScreen.setLastName("Тестовый");
        newContactScreen.setFirstName("Юзер");
        newContactScreen.setOrganisation("«Все организации»");
        newContactScreen.setJob("qa");
        newContactScreen.saveData();
        contactScreen.assertCreateNewContact();
    }

    @Test
    public void testCreateNewProject()
    {
        mainScreen.choseMyProjectItem();
        myProjectScreen.clickCreateNewProjectButton();
        newProjectScreen.setName();
        newProjectScreen.setOrganisation("«Все организации»");
        newProjectScreen.setBusinessUnit(1);
        newProjectScreen.setCurator(1);
        newProjectScreen.setRP(1);
        newProjectScreen.setAdministrator(1);
        newProjectScreen.setManager(1);
        newProjectScreen.saveData();
        myProjectScreen.assertCreateNewContact();
    }
}
