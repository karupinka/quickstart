package org.example.common;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/" + fileName);
        try {
            FileUtils.copyFile(tmp, destination);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @Attachment
    public static byte[] takeScreenshotByte(WebDriver driver, String fileName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
