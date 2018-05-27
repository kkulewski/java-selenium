package projekt3;

public class BrowserHandler
{
    public static void setBrowser(Browser browser)
    {
        if (System.getProperty("os.name").contains("Windows"))
        {
            setWindowsBrowser(browser);
        }
        else
        {
            setLinuxBrowser(browser);
        }
    }

    private static void setWindowsBrowser(Browser browser)
    {
        switch (browser)
        {
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                break;

            case Firefox:
                break;

            case InternetExplorer:
                break;

            case Opera:
                break;
        }
    }

    private static void setLinuxBrowser(Browser browser)
    {
        switch (browser)
        {
            case Chrome:
                break;

            case Firefox:
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                break;

            case InternetExplorer:
                break;

            case Opera:
                break;
        }
    }
}
