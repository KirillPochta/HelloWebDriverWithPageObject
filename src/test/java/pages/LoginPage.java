package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginPage {
    private WebDriver driver;
/*
    private WebElement loginFiled = driver.findElement(By.xpath("//*[@id=\"textfield-1015-inputEl\"]"));
    private WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"textfield-1017-inputEl\"]"));
    private WebElement signButton = driver.findElement(By.xpath("//*[@id=\"button-1021-btnIconEl\"]"));
*/
    @FindBy(xpath = "//*[@id=\"textfield-1015-inputEl\"]")
    private WebElement loginFiled;

    @FindBy(xpath = "//*[@id=\"textfield-1017-inputEl\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"button-1021-btnIconEl\"]")
    private WebElement signButton;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void init(){
        PageFactory.initElements(driver, this);
    }
    public void singIntoSystemAsUser(String login,String password) {

            Logger logger = Logger.getLogger(LoginPage.class.getName());
            logger.log(Level.INFO,"zdes");
            loginFiled.sendKeys(login);
            passwordField.sendKeys(password);
            signButton.click();


    }
}
