package utils.data;


import interactions.Pause;
import models.UserLoginData;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static ui.LoginPage.TITLE;
import static utils.constants.Constants.*;

public class DataManager {

    enum Users {

        CARLOS("Carlos", "Usuario para login exitoso") {
            @Override
            public UserLoginData loginData() {
                return new UserLoginData( "standard_user", "secret_sauce");
            }
        },

        JUAN ("Juan", "Usuario para login fallido") {
            @Override
            public UserLoginData loginData() {
                return new UserLoginData( "standard_user", "1234");
            }
        },
        KEVIN("Kevin", "Usuario de banca movil BDB") {
            @Override
            public UserLoginData loginData() {
                return null;
            }
        };
        public final String userName;
        public final String description;

        private Users(String userName, String description) {
            this.userName = userName;
            this.description = description;
        }

        public String getUserName() {
            return userName;
        }

        public String getDescription() {
            return description;
        }

        public abstract UserLoginData loginData();

        public static Users fromUserName(String actorName) {
            return Arrays.stream(values())
                .filter(users -> users.userName.equals(actorName))
                .findFirst()
                .orElse(KEVIN);
        }

    }

    public static void initActorWithName(String actorName) {
        Users user = Users.fromUserName(actorName);
        theActorCalled(actorName)
            .describedAs(user.description)
            .remember(DATA, user.loginData());
        withCurrentActor(Pause.withDuration(10));
        Check.whether(the(TITLE), isVisible());
        WaitUntil.the(TITLE,isVisible()).forNoMoreThan(30).seconds();
        withCurrentActor(Pause.withDuration(5000));
    }


}
