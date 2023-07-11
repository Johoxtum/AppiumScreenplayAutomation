package ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    public static final Target TITLE = Target.the("Titulo de inicio")
            .located(AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]"));

    public static final Target USERNAME = Target.the("Usuario")
            .located(AppiumBy.accessibilityId("test-Username"));

    public static final Target PASSWORD = Target.the("Password")
            .located(AppiumBy.accessibilityId("test-Password"));

    public static final Target BTN_LOGIN = Target.the("Boton login")
            .located(AppiumBy.accessibilityId("test-LOGIN"));

    public static final Target TITLE_PRODUCT = Target.the("Titulo de dashboard app")
            .located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));

    public static final Target ERROR_LOGIN = Target.the("credenciales incorrectas")
            .located(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));





}
