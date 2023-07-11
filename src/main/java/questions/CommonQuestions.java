package questions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.serenitybdd.screenplay.targets.Target;
import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsIterableContainingInOrder;

import java.util.List;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


public class CommonQuestions {
  private CommonQuestions() {}

  public static void textEquals(Target target, String label) {

    OnStage.theActorInTheSpotlight()
        .should(
            eventually(
                    seeThat(
                        TheTarget.textOf(target), CoreMatchers.containsStringIgnoringCase(label)))
                .waitingForNoLongerThan(10)
                .seconds());
  }
    public static void compareTextVsText(String target, String label) {
        OnStage.theActorInTheSpotlight().attemptsTo(
            Ensure.that(target).contains(label)
        );
    }

  public static void allText(Target target, List<String> labels) {
    OnStage.theActorInTheSpotlight()
        .should(
            eventually(
                    seeThat(
                        TheTarget.textValuesOf(target).withNoSurroundingWhiteSpace(),
                        IsIterableContainingInOrder.contains(labels)))
                .waitingForNoLongerThan(10)
                .seconds());
  }
}
