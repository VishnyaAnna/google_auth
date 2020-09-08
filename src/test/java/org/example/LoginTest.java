package org.example;

import org.example.pages.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import util.Browsers;
import util.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static WebDriver driver;


    @BeforeClass
    public static void setUpBrowser () {
        driver = WebDriverFactory.getDriver(Browsers.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PersonalInformationPage personalInformationPage = new PersonalInformationPage(driver);
        PersonalizationPage personalizationPage = new PersonalizationPage(driver);
        SafetyPage safetyPage = new SafetyPage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);
        loginPage.onPage();
        loginPage.fillLoginField();
        loginPage.clickNextButton();
        loginPage.fillPasswordField();
        loginPage.fillEntranceField();
        homePage.pageisDisplayed();
        personalInformationPage.clickPersonalInformationMenuSelector();
        personalInformationPage.profileTextisDisplayed();
        personalizationPage.clickPersonalizationMenuSelector();
        personalizationPage.PersonalizationTextisDisplayed();
        safetyPage.clickSafetyMenu();
        safetyPage.safetyMenuTextisDisplayed();
        settingsPage.clickSettingsMenuSelector();
        settingsPage.settingsMenuTextisDisplayed();

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}


