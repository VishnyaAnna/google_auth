package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage extends AbsPage {

    @FindBy(xpath = "//c-wiz[@data-savescroll = \"0\" and not(@data-savedfocusid)] //a[@href=\"people-and-sharing\" and .//div[contains(text(), \"Настройки доступа\")] and .//img[@data-atf=\"true\"]]")
    private WebElement settingsMenu;
    By settingsMenuSelector = By.xpath("//c-wiz[@data-savescroll = \"0\" and not(@data-savedfocusid)] //a[@href=\"people-and-sharing\" and .//div[contains(text(), \"Настройки доступа\")] and .//img[@data-atf=\"true\"]]");

    By settingsMenuTextSelector = By.xpath("//div[text() = 'Люди, с которыми вы общаетесь, и настройки доступа к вашей информации в сервисах Google.']");

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForVisisbility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public void waitForPageLoaded(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoaded(url));
    }

    public void clickSettingsMenuSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        waitForVisisbility(settingsMenuSelector);
        settingsMenu.click();
    }

    public void settingsMenuTextisDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(settingsMenuTextSelector));
        waitForPageLoaded(driver.getCurrentUrl());
        waitForVisisbility(settingsMenuTextSelector);
    }

    private ExpectedCondition<Boolean> pageLoaded(String pagePartialUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return driver -> (js.executeScript("return window.location.href").toString().contains(pagePartialUrl) &&
                js.executeScript("return document.readyState").equals("complete"));
    }
}
