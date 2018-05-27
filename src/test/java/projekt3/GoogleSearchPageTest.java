package projekt3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import projekt3.pages.GoogleSearchPage;

public class GoogleSearchPageTest
{

    private static WebDriver driver;

    @BeforeAll
    public static void setUpBeforeClass()
    {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void searchTest()
    {
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("Hello world");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @AfterAll
    public static void tearDownAfterClass()
    {
        driver.quit();
    }
}
