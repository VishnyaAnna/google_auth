package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalInformationPage extends AbsPage {

    @FindBy(xpath = "//a[contains(@data-nav-type, '9')]/div[contains(text(), 'Личная информация')]")
    private WebElement personalInformationMenu;
    By personalInformationMenuSelector = By.xpath("//a[contains(@data-nav-type, '9')]/div[contains(text(), 'Личная информация')]");

    @FindBy (xpath = "//h2[text() = 'Профиль']")
    private WebElement profileText;
    By profileTextSelector = By.xpath("//h2[text() = 'Профиль']");

    public PersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    public void waitForVisibility(By selector) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    public void waitForPageLoaded(String url) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoaded(url));
    }

    public void clickPersonalInformationMenuSelector() {
        ExpectedConditions.elementToBeClickable(personalInformationMenuSelector);
        personalInformationMenu.click();
    }

    public void profileTextisDisplayed() {
        waitForPageLoaded(driver.getCurrentUrl());
        waitForVisibility(profileTextSelector);
    }

    private ExpectedCondition<Boolean> pageLoaded(String pagePartialUrl) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return driver -> (js.executeScript("return window.location.href").toString().contains(pagePartialUrl) &&
                js.executeScript("return document.readyState").equals("complete"));
    }


}
