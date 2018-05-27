package projekt3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import projekt3.pages.PhpTravelsLoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class PhpTravelsLoginTest {

    private static WebDriver driver;

    @Test
    public void successfulLoginChromeTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        assertThat(this.getLoggedInPageTitle()).contains("My Account");
    }

    @Test
    public void successfulLoginFirefoxTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        assertThat(this.getLoggedInPageTitle()).contains("My Account");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    private String getLoggedInPageTitle()
    {
        PhpTravelsLoginPage page = PageFactory.initElements(driver, PhpTravelsLoginPage.class);
        page.enterLogin("user@phptravels.com", "demouser");
        return page.getPageTitle();
    }
}