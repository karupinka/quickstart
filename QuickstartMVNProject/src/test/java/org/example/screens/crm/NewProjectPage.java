package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;

public class NewProjectPage extends CommonPage {
    By byNameField = By.name("crm_project[name]");
    By byBusinessUnitField = By.name("crm_project[businessUnit]");
    By byOrganisationField = By.cssSelector(".select2-default > .select2-chosen");
    By byCuratorField = By.name("crm_project[curator]");
    By byRPField = By.name("crm_project[rp]");
    By byAdministratorField = By.name("crm_project[administrator]");
    By byManagerField = By.name("crm_project[manager]");
    By bySaveButton = By.cssSelector(".btn-group:nth-child(4) > .btn");

    public void setName() {
        WebElement nameField = wait.until(ExpectedConditions.presenceOfElementLocated(byNameField));
        nameField.sendKeys(createUniqueName());
    }

    public void setOrganisation(String text) {
        WebElement organisationElement = driver.findElement(byOrganisationField);
        String xpathItem = "//div[text()=\"" + text + "\"]";
        organisationElement.click();
        WebElement organisationItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathItem)));
        organisationItem.click();
    }

    public void setBusinessUnit(int index) {
        WebElement element = driver.findElement(byBusinessUnitField);
        element.click();
        Select businessUnitElement = new Select(element);
        businessUnitElement.selectByIndex(index);
    }

    public void setCurator(int index) {
        WebElement element = driver.findElement(byCuratorField);
        Select curatorElement = new Select(element);
        curatorElement.selectByIndex(index);
    }

    public void setRP(int index) {
        WebElement element = driver.findElement(byRPField);
        Select prElement = new Select(element);
        prElement.selectByIndex(index);
    }

    public void setAdministrator(int index) {
        WebElement element = driver.findElement(byAdministratorField);
        Select AdministratorElement = new Select(element);
        AdministratorElement.selectByIndex(index);
    }

    public void setManager(int index) {
        WebElement element = driver.findElement(byManagerField);
        Select managerElement = new Select(element);
        managerElement.selectByIndex(index);
    }

    public void saveData() {
        WebElement saveButton = driver.findElement(bySaveButton);
        saveButton.click();
    }

    private String createUniqueName() {
        String uniqueName = "";
        Date date = new Date();
        uniqueName = "Project - " + date.toString();
        return uniqueName;
    }
}
