package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactPage extends CommonPage {
    // By
    By byLastNameField = By.name("crm_contact[lastName]");
    By byFirstNameField = By.name("crm_contact[firstName]");
    By byJobField = By.name("crm_contact[jobTitle]");
    By byOrganisations = By.cssSelector(".select2-chosen");
    By bySaveButton = By.cssSelector(".btn-group:nth-child(4) > .btn");

    public NewContactPage setLastName(String text) {
        WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(byLastNameField));
        lastNameField.sendKeys(text);
        return this;
    }

    public NewContactPage setFirstName(String text) {
        WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(byFirstNameField));
        firstNameField.sendKeys(text);
        return this;
    }

    public NewContactPage setOrganisation(String text) {
        WebElement organisationElement = driver.findElement(byOrganisations);
        String xpathItem = "//div[text()=\"" + text + "\"]";
        organisationElement.click();
        WebElement organisationItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathItem)));
        organisationItem.click();
        return this;
    }

    public NewContactPage setJob(String text) {
        WebElement jobField = driver.findElement(byJobField);
        jobField.sendKeys(text);
        return this;
    }

    public NewContactPage saveData() {
        WebElement saveButton = driver.findElement(bySaveButton);
        saveButton.click();
        return this;
    }
}
