package co.com.devco.tasks;

import co.com.devco.interactions.ClickPrimerDeleteCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_HOME;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarAlerta implements Task {
    private DriverTask alerta;
    public SeleccionarAlerta() {
        this.alerta=new DriverTask(driver -> driver.switchTo().alert() );
    }

    public static Performable toAlert() {
        return new DriverTask(driver -> driver.switchTo().alert() );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LINK_CARRITO),
                ClickPrimerDeleteCarrito.elementos(PRODUCTOS_CARRITO),
                Click.on(LINK_HOME)
        );
    }
}
