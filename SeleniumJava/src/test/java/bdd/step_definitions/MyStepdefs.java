package bdd.step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import tasks.tLogIn;
import tasks.tMainP;
import static org.junit.Assert.assertTrue;


public class MyStepdefs implements En{
    public MyStepdefs() {
        tLogIn taskLogin = new tLogIn();
        tMainP taskMainP = new tMainP();

        Given("^The webpage \"([^\"]*)\"$", (String site) -> {
            // Write code here that turns the phrase above into concrete actions
            taskLogin.go(site);
        });

        Then("^I type \"([^\"]*)\" user$", (String user) -> {
            // Write code here that turns the phrase above into concrete actions
            taskLogin.setUSerTxt(user);
        });

        And("^I type \"([^\"]*)\" password$", (String password) -> {
            // Write code here that turns the phrase above into concrete actions
            taskLogin.setPwdTxt(password);
        });

        And("^I login$", () -> {
            // Write code here that turns the phrase above into concrete actions
            taskLogin.clickButton();
        });

        Then("^I should see an error message$", () -> {
            // Write code here that turns the phrase above into concrete actions
            taskLogin.checkUserErr();
        });
        Then("^I select brand \"([^\"]*)\"$", (String brand) -> {
            // Write code here that turns the phrase above into concrete actions
            taskMainP.selectBrand(brand);

        });
        And("^I select the model \"([^\"]*)\"$", (String model) -> {
            // Write code here that turns the phrase above into concrete actions
            taskMainP.selectModel(model);

        });
        And("^I select the year \"([^\"]*)\"$", (String year) -> {
            // Write code here that turns the phrase above into concrete actions
            taskMainP.selectYear(year);

        });
        Then("^I click to Cotizacion Gratuita$", () -> {
            // Write code here that turns the phrase above into concrete actions
            taskMainP.clickCot();
        });
        Then("^I verify the brand is the one I selected$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^Get the brand list$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertTrue("Could not get the list",taskMainP.getBrandList());
        });
        Then("^Check the brand list is correct$", () -> {
            // Write code here that turns the phrase above into concrete actions
            assertTrue("There are difference between the ui list and the RESTlist",taskMainP.compareRestDropdown());
        });

    }
}
