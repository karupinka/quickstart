package org.example.screens.crm;

import org.example.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends CommonPage {
    By byContractorsButton = By.xpath("//span[text()=\"Контрагенты\"]");
    By byProjectButton = By.xpath("//span[text()=\"Проекты\"]");

    public void choseContactItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(byContractorsButton));
        WebElement contractorElement = driver.findElement(byContractorsButton);
        contractorElement.click();
        String css = "//span[contains(.,\"Контактные лица\")]";
        WebElement contractorItem = driver.findElement(By.xpath(css));
        contractorItem.click();
    }

    public void choseMyProjectItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(byProjectButton));
        WebElement contractorElement = driver.findElement(byProjectButton);
        contractorElement.click();
        String css = "//span[contains(.,\"Мои проекты\")]";
        WebElement contractorItem = driver.findElement(By.xpath(css));
        contractorItem.click();
    }
}
