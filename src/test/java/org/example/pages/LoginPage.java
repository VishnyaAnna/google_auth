package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public final WebDriver driver;
    private static final String login = ""; //put your gmail login
    private static final String password = ""; // put gmail password

    @FindBy (id = "identifierId")
    private WebElement loginInput;

    @FindBy (id = "identifierNext")
    private WebElement buttonNext;

    @FindBy (css = "#password input")
    private WebElement passwordInput;

    @FindBy (id = "passwordNext")
    private WebElement buttonEntrance;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void onPage() {
        driver.get("https://accounts.google.com/signin/v2");
    }
    public void fillLoginField() {
        loginInput.sendKeys(login);
    }
    public void clickNextButton() {
        buttonNext.click();
    }

    public void fillPasswordField() {
        passwordInput.sendKeys(password);
    }
    public void fillEntranceField() {
        buttonEntrance.click();
    }
}
