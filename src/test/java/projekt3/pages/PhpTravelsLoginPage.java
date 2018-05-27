package projekt3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhpTravelsLoginPage {

    @FindBy(name = "username")
    private WebElement loginField;
    @FindBy(name = "password")
    private WebElement passwordField;

    public WebDriver driver;
    public WebDriverWait wait;

    public PhpTravelsLoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.phptravels.net/login");
        wait = new WebDriverWait(driver, 30);
    }

    public void enterLogin(String username, String password) {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.RETURN);
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.titleContains("Account"));
        return driver.getTitle();
    }

}