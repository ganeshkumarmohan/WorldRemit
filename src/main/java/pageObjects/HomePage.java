package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractBasePage {

    private By COUNTRY_SELECTION_DROPDOWN = By.id("selectTo");
    private By GET_STARTED_BUTTON = By.id("sendTargetHREF");

    public HomePage(WebDriver driver) {
        super(driver, "Money Transfer - Send Money Online | WorldRemit");
    }

    public HomePage chooseCountry(String country) {
        Select dropdownSelection = new Select(driver.findElement(COUNTRY_SELECTION_DROPDOWN));
        dropdownSelection.selectByVisibleText(country);
        return this;
    }

    public MoneyTransferPage getStarted() {
        driver.findElement(GET_STARTED_BUTTON).click();
        return new MoneyTransferPage(driver);
    }

}
