package org.example.common;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Web extends CommonPage{
    private BufferedWriter bufferedWriter;

    public void get(String url) { driver.get(url); }

    public void createBrowserLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = logEntries.getAll();
        String filename = "browser.log";
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filename));
            if(allLogRows.size() > 0) {
                for (LogEntry log: allLogRows) {
                    bufferedWriter.write(log.getMessage() + "\n");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void close() {
        if (driver != null) {
            driver.close();
        }
    }

    public EventFiringWebDriver getWebDriver() {
        return driver;
    }
}
