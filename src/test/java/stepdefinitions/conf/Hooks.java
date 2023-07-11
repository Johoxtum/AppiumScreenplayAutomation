package stepdefinitions.conf;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.util.EnvironmentVariables;
import stepdefinitions.actors.EnviromentCast;

public class Hooks {
    private EnvironmentVariables environmentVariables;


    @Before
    public void setup(Scenario scenario) {

        OnStage.setTheStage(new EnviromentCast(environmentVariables));
        Serenity.setSessionVariable("ScenarioName").to(scenario.getName());
    }
}
