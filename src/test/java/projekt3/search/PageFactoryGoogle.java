package projekt3.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryGoogle {

    private String searchPhrase;

    @FindBy(name = "q")
    private WebElement q;
    private WebDriver driver;
    private WebDriverWait wait;
  
    public PageFactoryGoogle(WebDriver driver)
    {
        this.driver = driver;
        driver.get("http://www.google.com/");
        wait = new WebDriverWait(driver,30);
    }
  
    void search(String text)
    {
        searchPhrase = text;
        q.sendKeys(text);
        q.submit();
    }
  
    boolean titleContainsSearchPhrase()
    {
        q = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("q")));
        Boolean result = driver.getTitle().contains(searchPhrase);
        System.out.println(driver.getTitle());
        return (result);
    }
}
