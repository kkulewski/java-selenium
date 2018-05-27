package projekt3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import projekt3.pages.GoogleSearchPage;

public class GoogleSearchPageTest
{
    private static WebDriver driver;

    @Test
    public void searchSuccessfulChromeTest()
    {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("Hello world");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @Test
    public void searchFailedChromeTest()
    {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("asdfghjkasdfghmnnvxxzqwertyuasdfgh");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @Test
    public void searchSuccessfulFirefoxTest()
    {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("Hello world");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @Test
    public void searchFailedFirefoxTest()
    {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("asdfghjkasdfghmnnvxxzqwertyuasdfgh");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @AfterEach
    public void tearDownAfterClass()
    {
        driver.quit();
    }
}
