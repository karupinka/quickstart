package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends CommonPage {
    // By
    By byContractorsButton = By.xpath("//span[text()=\"Контрагенты\"]");
    By byProjectButton = By.xpath("//span[text()=\"Проекты\"]");
    By byContactItem = By.xpath("//span[contains(.,\"Контактные лица\")]");
    By byMyProjectItem = By.xpath("//span[contains(.,\"Мои проекты\")]");

    public MainPage choseContactItem() {
        WebElement contractorElement = driver.findElement(byContractorsButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(byContractorsButton));
        contractorElement.click();
        WebElement contactItem = driver.findElement(byContactItem);
        contactItem.click();
        return this;
    }

    public MainPage choseMyProjectItem() {
        WebElement projectElement = driver.findElement(byProjectButton);
        wait.until(ExpectedConditions.presenceOfElementLocated(byProjectButton));
        projectElement.click();
        WebElement myProjectItem = driver.findElement(byMyProjectItem);
        myProjectItem.click();
        return this;
    }
}
