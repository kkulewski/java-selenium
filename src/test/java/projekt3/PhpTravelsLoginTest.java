package projekt3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import projekt3.pages.PhpTravelsLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

class PhpTravelsLoginTest {

    private static WebDriver driver;
    private PhpTravelsLoginPage page;

    @Test
    void successfulLoginChromeTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        loginWithCorrectCredentials();
        assertThat(page.getPageTitle()).contains("My Account");
    }

    @Test
    void successfulLoginFirefoxTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        loginWithCorrectCredentials();
        assertThat(page.getPageTitle()).contains("My Account");
    }

    @Test
    void failedLoginChromeTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        loginWithIncorrectCredentials();
        assertThat(page.invalidLoginMessageAppeared()).isTrue();
    }

    @Test
    void failedLoginFirefoxTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        loginWithIncorrectCredentials();
        assertThat(page.invalidLoginMessageAppeared()).isTrue();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    private void loginWithCorrectCredentials()
    {
        page = PageFactory.initElements(driver, PhpTravelsLoginPage.class);
        page.enterLogin("user@phptravels.com", "demouser");
    }

    private void loginWithIncorrectCredentials()
    {
        page = PageFactory.initElements(driver, PhpTravelsLoginPage.class);
        page.enterLogin("user@phptravels.com", "wrongPassword");
    }
}
