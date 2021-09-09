package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class NewProjectPage extends CommonPage {
    // By
    By byNameField = By.name("crm_project[name]");
    By byBusinessUnitField = By.name("crm_project[businessUnit]");
    By byOrganisationField = By.cssSelector(".select2-default > .select2-chosen");
    By byCuratorField = By.name("crm_project[curator]");
    By byRPField = By.name("crm_project[rp]");
    By byAdministratorField = By.name("crm_project[administrator]");
    By byManagerField = By.name("crm_project[manager]");
    By bySaveButton = By.cssSelector(".btn-group:nth-child(4) > .btn");

    public NewProjectPage setName() {
        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(byNameField));
        nameField.sendKeys(createUniqueName());
        return this;
    }

    public NewProjectPage setOrganisation(String text) {
        WebElement organisationElement = driver.findElement(byOrganisationField);
        String xpathItem = "//div[text()=\"" + text + "\"]";
        organisationElement.click();
        WebElement organisationItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathItem)));
        organisationItem.click();
        return this;
    }

    public NewProjectPage setBusinessUnit(int index) {
        WebElement businessUnitField = driver.findElement(byBusinessUnitField);
        businessUnitField.click();
        Select businessUnitElement = new Select(businessUnitField);
        businessUnitElement.selectByIndex(index);
        return this;
    }

    public NewProjectPage setCurator(int index) {
        WebElement curatorField = driver.findElement(byCuratorField);
        Select curatorElement = new Select(curatorField);
        curatorElement.selectByIndex(index);
        return this;
    }

    public NewProjectPage setRP(int index) {
        WebElement rp = driver.findElement(byRPField);
        Select prElement = new Select(rp);
        prElement.selectByIndex(index);
        return this;
    }

    public NewProjectPage setAdministrator(int index) {
        WebElement administratorField = driver.findElement(byAdministratorField);
        Select AdministratorElement = new Select(administratorField);
        AdministratorElement.selectByIndex(index);
        return this;
    }

    public NewProjectPage setManager(int index) {
        WebElement managerField = driver.findElement(byManagerField);
        Select managerElement = new Select(managerField);
        managerElement.selectByIndex(index);
        return this;
    }

    public NewProjectPage saveData() {
        WebElement saveButton = driver.findElement(bySaveButton);
        saveButton.click();
        return this;
    }

    private String createUniqueName() {
        String uniqueName = "";
        Date date = new Date();
        uniqueName = "Project - " + date.toString();
        return uniqueName;
    }
}
