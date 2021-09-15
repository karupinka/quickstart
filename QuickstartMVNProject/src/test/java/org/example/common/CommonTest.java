package org.example.common;

import org.openqa.selenium.support.events.WebDriverEventListener;

public abstract class CommonTest {
    public Web web = new Web();
    private WebDriverEventListener webDriverEventListener = new TestWebDriverEventListener();

    public void setUp() {
        web.getWebDriver().register(webDriverEventListener);
    }
}
