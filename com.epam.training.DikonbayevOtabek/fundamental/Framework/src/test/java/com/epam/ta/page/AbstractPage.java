package com.epam.ta.page;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPageGmail();

    protected abstract AbstractPage openPageMail();


}
