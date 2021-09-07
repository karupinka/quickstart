package org.example.common;

public class Web extends CommonPage{
    public void get(String url) {
        driver.get(url);
    }

    public void close() {
        driver.close();
    }
}
