package edu.ufm.qa.tests;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class BaseTest {
    protected WebDriver driver;

    // alwaysRun: without it, a run filtered by groups skips the setup.
    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void openBrowser(@Optional("chrome") String browser) {
        driver = browser.equals("firefox") ? firefox() : chrome();
        driver.get("https://www.saucedemo.com/");
    }

    // -Dpause.ms deja el navegador abierto un rato antes de cerrarlo (para verlo).
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(Long.getLong("pause.ms", 0));
        if (driver != null) driver.quit();
    }

    private static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "true"));
    }

    private static WebDriver chrome() {
        ChromeOptions options = new ChromeOptions();
        if (headless()) options.addArguments("--headless=new");
        // Chrome's password-leak popup blocks clicks after login.
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.password_manager_leak_detection", false));
        return new ChromeDriver(options);
    }

    private static WebDriver firefox() {
        FirefoxOptions options = new FirefoxOptions();
        if (headless()) options.addArguments("-headless");
        return new FirefoxDriver(options);
    }
}
