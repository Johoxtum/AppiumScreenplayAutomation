package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserLoginData;
import questions.CommonQuestions;
import task.LoginTask;
import utils.data.DataManager;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static ui.LoginPage.ERROR_LOGIN;
import static ui.LoginPage.TITLE_PRODUCT;
import static utils.constants.Constants.DATA;


public class SwagStep {

    @Given("{string} on the login page")
    public void onTheLoginPage(String actorName) {
        DataManager.initActorWithName(actorName);
    }
    @When("enter valid credentials")
    public void enterValidCredentials() {
        UserLoginData userData = theActorInTheSpotlight().recall(DATA);
        withCurrentActor(
                LoginTask.withData(userData)
        );


    }
    @Then("he should be logged in successfully with message {string}")
    public void heShouldBeLoggedInSuccessfullyWithMessage(String products) {
                CommonQuestions.textEquals(TITLE_PRODUCT,products);
    }

    @When("enter invalid credentials")
    public void enterInvalidCredentials() {

        UserLoginData userData = theActorInTheSpotlight().recall(DATA);
        withCurrentActor(
                LoginTask.withData(userData)
        );

    }
    @Then("He should see an error message {string}")
    public void heShouldSeeAnErrorMessage(String error) {

        CommonQuestions.textEquals(ERROR_LOGIN,error);
    }
}
