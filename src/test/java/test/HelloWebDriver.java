package test;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;


public class HelloWebDriver {
    private WebDriver driver;
    private ChromeOptions options;
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.get("https://junior.webquik.ru/");

    }
    @Test(description = "Sign into account")
    public  void signIntoSystem() throws InterruptedException {
         loginPage = new LoginPage(driver);
         loginPage.init();
         loginPage.singIntoSystemAsUser("U0191767","06258");
         Thread.sleep(5000);
         Assert.assertEquals(driver.getTitle(),"webQUIK 7.6.2");
    }
    @Test(description = "Create new ticket with limits")
    public  void createNewTicketWithLimits() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.init();
        loginPage.singIntoSystemAsUser("U0191767","06258");

        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"webQUIK 7.6.2");

        homePage = new HomePage(driver);
        homePage.init();
        homePage.createNewTicketWithlimits("CNYRUB_SPT","5","1");
    }
    @Test(description = "Create new ticket with marketable price")
    public  void createNewTicketWithMarketablePrice() throws InterruptedException {
        loginPage = new LoginPage(driver);
        Thread.sleep(5000);
        loginPage.init();
        loginPage.singIntoSystemAsUser("U0191767","06258");

        Thread.sleep(5000);
        Assert.assertEquals(driver.getTitle(),"webQUIK 7.6.2");

        homePage = new HomePage(driver);
        homePage.init();
        homePage.createNewTicketWithMarket("CHMF","5");
    }
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

