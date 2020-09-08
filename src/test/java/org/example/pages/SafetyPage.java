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

public class SafetyPage {

    public final WebDriver driver;

    @FindBy(xpath = "(//a[contains(@data-nav-type, '9')]/div[contains(text(), 'Безопасность')])[3]")
    private WebElement safetyMenu;
    By safetyMenuSelector = By.xpath("(//a[contains(@data-nav-type, '9')]/div[contains(text(), 'Безопасность')])[3]");

    @FindBy (xpath = "//div[text() = 'Настройки и рекомендации, которые помогают защитить аккаунт.']")
    private WebElement safetyMenuText;
    By safetyMenuTextSelector = By.xpath("//div[text() = 'Настройки и рекомендации, которые помогают защитить аккаунт.']");

    public SafetyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitForVisisbility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public void waitForPageLoaded(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoaded(url));
    }

    public void clickSafetyMenu() {
        safetyMenu.click();
    }

    public void safetyMenuTextisDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(safetyMenuTextSelector));
        waitForPageLoaded(driver.getCurrentUrl());
        waitForVisisbility(safetyMenuTextSelector);
    }

    private ExpectedCondition<Boolean> pageLoaded(String pagePartialUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return driver -> (js.executeScript("return window.location.href").toString().contains(pagePartialUrl) &&
                js.executeScript("return document.readyState").equals("complete"));
    }

}
