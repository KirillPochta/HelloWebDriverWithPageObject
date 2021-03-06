package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver = new ChromeDriver();
    private WebElement loginFiled = driver.findElement(By.id("textfield-1015-inputEl"));
    private WebElement passwordField = driver.findElement(By.id("textfield-1017-inputEl"));
    private WebElement signButton = driver.findElement(By.id("button-1021-btnIconEl"));
/*
    @FindBy(xpath = "//*[@id=\"textfield-1015-inputEl\"]")
    private WebElement loginFiled;

    @FindBy(xpath = "//*[@id=\"textfield-1017-inputEl\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"button-1021-btnIconEl\"]")
    private WebElement signButton;
*/
    public LoginPage(WebDriver driver) {
        this.driver=driver;

       // PageFactory.initElements(driver, this);
    }

    public void singIntoSystemAsUser(String login,String password) {
        //WebElement loginField = (new WebDriverWait(driver, 15))
         //       .until(ExpectedConditions.presenceOfElementLocated(By
        //                .xpath("//*[@id=\"textfield-1015-inputEl\"]")));
          //  loginField.sendKeys(login);
            loginFiled.sendKeys(login);
            passwordField.sendKeys(password);
            signButton.click();
    }
}
