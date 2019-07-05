package stepDefinitions;

import configuration.PageNavigator;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import pageObjects.HomePage;
import pageObjects.MoneyTransferPage;

public class StepDefinitions {

    private PageNavigator navigator;
    private HomePage homePage;
    private MoneyTransferPage moneyTransferPage;

    @Before
    public void setUp() {
        navigator = new PageNavigator();
    }

    @Given("^I navigate to WorldRemit home page$")
    public void iNavigateToWorldRemitHomePage() {
        homePage = navigator.launchApplication();
    }

    @When("^I select country (.*)")
    public void iSelectCountryPhilippines(String country) {
        homePage.chooseCountry(country);
    }

    @And("^I start the money sending process$")
    public void iStartTheMoneySendingProcess() {
        moneyTransferPage = homePage.getStarted();
    }

    @Then("^I should see the Money Transfer Page for (.*)$")
    public void iShouldSeeTheMoneyTransferPageForPhilippines(String country) {
        Assertions.assertThat(moneyTransferPage.getPageTitle()).containsIgnoringCase(country);
    }

    @After
    public void tearDown() {
        navigator.closeBrowser();
    }

}
