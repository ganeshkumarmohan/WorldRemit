package pageObjects;

import org.openqa.selenium.WebDriver;

public class MoneyTransferPage extends AbstractBasePage {

    MoneyTransferPage(WebDriver driver) {
        super(driver, "WorldRemit");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
