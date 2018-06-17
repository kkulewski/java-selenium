package projekt3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import projekt3.pages.GoogleSearchPage;

import static org.assertj.core.api.Assertions.assertThat;

class GoogleSearchPageTest {

    private static WebDriver driver;
    private GoogleSearchPage page;

    @Test
    void searchSuccessfulChromeTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        successfulSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchFailedChromeTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        driver = new ChromeDriver();
        failedSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchSuccessfulFirefoxTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        successfulSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchFailedFirefoxTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        driver = new FirefoxDriver();
        failedSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchSuccessfulChromeHeadlessTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1600x900");
        driver = new ChromeDriver(options);

        successfulSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchFailedChromeHeadlessTest() {
        BrowserHandler.setBrowser(Browser.Chrome);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1600x900");
        driver = new ChromeDriver(options);

        failedSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchSuccessfulFirefoxHeadlessTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);

        successfulSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    @Test
    void searchFailedFirefoxHeadlessTest() {
        BrowserHandler.setBrowser(Browser.Firefox);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);

        failedSearch();
        assertThat(page.titleContainsSearchPhrase()).isTrue();
    }

    private void successfulSearch() {
        page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("Hello world");
    }

    private void failedSearch() {
        page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.search("asdfghjkasdfghmnnvxxzqwertyuasdfgh");
    }

    @AfterEach
    void tearDownAfterClass() {
        driver.quit();
    }
}
