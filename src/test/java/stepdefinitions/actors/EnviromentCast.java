package stepdefinitions.actors;


import abilities.UseAMobileDevice;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;

public class EnviromentCast extends Cast {
    public final EnvironmentVariables environmentVariables;

    public EnviromentCast(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Override
    public Actor actorNamed(String actorName, Ability... abilities) {
        return super.actorNamed(actorName, UseAMobileDevice.with(theDefaultDriverFor(actorName)));
    }


    private WebDriver theDefaultDriverFor(String actorName) {
        return ThucydidesWebDriverSupport.getWebdriverManager().getWebdriverByName(actorName);
    }
}
