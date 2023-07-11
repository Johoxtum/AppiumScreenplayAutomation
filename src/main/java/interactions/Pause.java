package interactions;


import abilities.UseAMobileDevice;
import net.serenitybdd.markers.IsHidden;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Pause implements Interaction, IsHidden {

  private final int duration;

  public Pause(int duration) {
    this.duration = duration;
  }

  public static Interaction withDuration(int duration) {
    return new Pause(duration);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    UseAMobileDevice.likeActor(actor).waitFor(duration).milliseconds();
  }
}
