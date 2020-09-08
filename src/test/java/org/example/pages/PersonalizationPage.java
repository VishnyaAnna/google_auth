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

public class PersonalizationPage extends AbsPage {


    @FindBy(xpath = "(//a[contains(@data-nav-type, '9')][./div[contains(text(), 'Данные и персонализация')]])[2]")
    private WebElement personalizationMenu;
    By personalizationMenuSelector = By.xpath("(//a[contains(@data-nav-type, '9')][./div[contains(text(), 'Данные и персонализация')]])[2]");

    @FindBy (xpath = "//div[text() = 'Ваши данные и действия, а также настройки, которые помогают делать сервисы Google более полезными для вас.']")
    private WebElement personalizationText;
    By personalizationTextSelector = By.xpath("//div[text() = 'Ваши данные и действия, а также настройки, которые помогают делать сервисы Google более полезными для вас.']");

    public PersonalizationPage(WebDriver driver) {
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

    public void clickPersonalizationMenuSelector() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(personalizationMenuSelector));
        waitForVisisbility(personalizationMenuSelector);
        personalizationMenu.click();
    }

    public void PersonalizationTextisDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(personalizationTextSelector));
        waitForPageLoaded(driver.getCurrentUrl());
        waitForVisisbility(personalizationTextSelector);
    }

    private ExpectedCondition<Boolean> pageLoaded(String pagePartialUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return driver -> (js.executeScript("return window.location.href").toString().contains(pagePartialUrl) &&
                js.executeScript("return document.readyState").equals("complete"));
    }
}
