package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class WebDriverConfiguration {

    WebDriver driver;

    private enum OS {
        WINDOWS,
        MAC,
        LINUX
    }

    WebDriver intializeDriver() {
        return spinDriverInstanceFor(OS.valueOf(System.getProperty("platform").toUpperCase()));
    }

    private WebDriver spinDriverInstanceFor(OS platform) {
        switch (platform) {
            case WINDOWS:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/webDrivers/chromedriver-win.exe");
                driver = spinChromeDriver();
                break;
            case MAC:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/webDrivers/chromedriver-mac");
                driver = spinChromeDriver();
                break;
            case LINUX:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/webDrivers/chromedriver-linux");
                driver = spinChromeDriver();
                break;
        }
        return driver;
    }

    private WebDriver spinChromeDriver() {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
