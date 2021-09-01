package org.example.screens.crm;

import org.example.common.CommonScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewContactScreen extends CommonScreen {
    By byLastNameField = By.name("crm_contact[lastName]");
    By byFirstNameField = By.name("crm_contact[firstName]");
    By byJobField = By.name("crm_contact[jobTitle]");
    By byOrganisations = By.cssSelector(".select2-chosen");
    By bySaveButton = By.cssSelector(".btn-group:nth-child(4) > .btn");

    public void setLastName(String text) {
        WebElement lastNameField = wait.until(ExpectedConditions.presenceOfElementLocated(byLastNameField));
        lastNameField.sendKeys(text);
    }

    public void setFirstName(String text) {
        WebElement firstNameField = wait.until(ExpectedConditions.presenceOfElementLocated(byFirstNameField));
        firstNameField.sendKeys(text);
    }

    public void setOrganisation(String text) {
        WebElement organisationElement = driver.findElement(byOrganisations);
        String xpathItem = "//div[text()=\"" + text + "\"]";
        organisationElement.click();
        WebElement organisationItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathItem)));
        organisationItem.click();
    }

    public void setJob(String text) {
        WebElement jobField = driver.findElement(byJobField);
        jobField.sendKeys(text);
    }

    public void saveData() {
        WebElement saveButton = driver.findElement(bySaveButton);
        saveButton.click();
    }
}
