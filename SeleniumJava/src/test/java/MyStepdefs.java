import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tasks.tLogIn;
import cucumber.api.java8.En

public class MyStepdefs {
    tLogIn task = new tLogIn();

    @Given("^I go to \"([^\"]*)\"$")
    public void iGoTo(String site) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        task.go(site);
    }

    @Then("^I type \"([^\"]*)\" user$")
    public void iTypeUser(String user) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        task.setUSerTxt(user);
    }

    @And("^I type \"([^\"]*)\" password$")
    public void iTypePassword(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        task.setPwdTxt(password);
    }

    @And("^I login$")
    public void iLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        task.clickButton();
    }

    @Then("^I should see an error message$")
    public void iShouldSeeAnErrorMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        task.checkUserErr();
    }
}
