package co.com.devco.tasks;

import co.com.devco.interactions.ClickPrimerDeleteCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class LimpiarCarrito implements Task {

    public static Performable completamente() {
        return instrumented(LimpiarCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        //si sale is not attacht usar  posible espera
//        WaitUntil.the(LINK_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(6)),
        actor.attemptsTo(
                WaitUntil.the(LINK_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(6)),
                Click.on(LINK_CARRITO),
                ClickPrimerDeleteCarrito.elementos(PRODUCTOS_CARRITO),
                Click.on(LINK_HOME)
        );
    }
}
