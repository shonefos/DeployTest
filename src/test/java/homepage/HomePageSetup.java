package homepage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSetup {

    private HomePage homePage;

    public HomePageSetup() { this.homePage = new HomePage(); }

    @Given("User navigate to home page")
    public void userNavigateToHomePage() { this.homePage.goToHomePage(); }

    @Then("Deploy logo is displayed")
    public void deployLogoIsDisplayed() { this.homePage.checkLogoDisplay(); }

    @And("Click on GetinTouch")
    public void clickOnGetinTouch() throws InterruptedException
    {
        this.homePage.clickOnChat();
        this.homePage.Sleep(8000);
    }

    @And("Check title is {string}")
    public void checkTitleIs(String title) { this.homePage.checkTitle(title);}

    @Then("Add email and name")
    public void addEmailAndName() throws InterruptedException {
        this.homePage.inputEmailandName();
        this.homePage.Sleep(3000);
    }
}
