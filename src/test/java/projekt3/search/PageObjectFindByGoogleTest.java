package projekt3.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectFindByGoogleTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception
    {
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        driver = new FirefoxDriver();
    }

    @Test
    public void searchTest() throws Exception
    {
        PageFactoryGoogle page = PageFactory.initElements(driver, PageFactoryGoogle.class);
        page.search("Hello world");
        assertTrue(page.titleContainsSearchPhrase());
    }

    @AfterAll
    public static void tearDownAfterClass() throws Exception
    {
        driver.quit();
    }
}
