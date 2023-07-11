package abilities;


import exceptions.NotFoundUserAbility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.webdriver.RemoteDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Objects;

public class UseAMobileDevice extends BrowseTheWeb {
    protected UseAMobileDevice(WebDriver browser) {
        super(browser);
    }

    public static UseAMobileDevice likeActor (Actor actor){
        UseAMobileDevice ability = actor.abilityTo(UseAMobileDevice.class);
        if(ability!= null){
            return ability.asActor(actor);
        }
        else {
            throw new NotFoundUserAbility();
        }
    }

    @Override
    public String toString() {
        return "Usar un dispositivo movil";
    }

    public static UseAMobileDevice with(WebDriver driver){
        return new UseAMobileDevice(driver);
    }


}
