package task;

import models.UserLoginData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static ui.LoginPage.*;

public class LoginTask implements Task {

    private final UserLoginData userData;

    public LoginTask(UserLoginData userData) {
        this.userData = userData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(userData.getUsername()).into(USERNAME),
                Enter.theValue(userData.getPassword()).into(PASSWORD),
                Click.on(BTN_LOGIN)
        );
    }
    public static LoginTask withData(UserLoginData userData){
        return instrumented(LoginTask.class,userData);
    }
}
