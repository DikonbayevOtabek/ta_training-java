package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailMainPage extends AbstractPage{
    private final String BASE_URL = "https://mail.ru/login";
    private WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    @FindBy(xpath = "//span[@class='badge badge_size_m']")
    WebElement numberOfUnreadMessages;
    private final By newMessageButtonMailLocator = By.xpath("//span[@class='compose-button__wrapper']");



    public MailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public EmailReceivePage invokeEmailReceivePage() {
        return new EmailReceivePage(driver);
    }
    public boolean isMessageArrived(){
        wait.until(ExpectedConditions.visibilityOf(numberOfUnreadMessages));
        int numberOfReceivedMessage = Integer.parseInt(numberOfUnreadMessages.getText());
        return numberOfReceivedMessage >= 1;
    }

    public boolean isButtonVisible(){
        try{
            WebElement newMessageButton = wait.until(ExpectedConditions.presenceOfElementLocated(newMessageButtonMailLocator));
            return newMessageButton.isDisplayed();
        }catch (Exception exception){
            return false;
        }
    }

    @Override
    public MailMainPage openPageGmail() {
        return null;
    }

    @Override
    public MailMainPage openPageMail() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
