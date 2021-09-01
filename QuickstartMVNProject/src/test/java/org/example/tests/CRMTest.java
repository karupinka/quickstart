package org.example.tests;
import org.example.common.CommonScreen;
import org.example.screens.crm.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CRMTest
{
    CommonScreen commonScreen = new CommonScreen();
    LoginScreen loginScreen = new LoginScreen();
    MainScreen mainScreen = new MainScreen();
    ContactScreen contactScreen = new ContactScreen();
    NewContactScreen newContactScreen = new NewContactScreen();
    MyProjectScreen myProjectScreen = new MyProjectScreen();
    NewProjectScreen newProjectScreen = new NewProjectScreen();

    @Before
    public void setUp() {
        commonScreen.get("https://crm.geekbrains.space/");
        loginScreen.setLogin("Applanatest1");
        loginScreen.setPassword("Student2020!");
        loginScreen.login();
    }

    @After
    public void tearDown() {
        commonScreen.close();
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
