package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductoAlCarrito implements Task {
    private String producto;

    public AgregarProductoAlCarrito(String producto) {
        this.producto = producto;
    }

    public static Performable elProducto(String producto) {
        return instrumented(AgregarProductoAlCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Object prod =LINK_PRODUCTO.of(producto);
        actor.attemptsTo(
                Open.url("https://www.demoblaze.com/#"),
                Click.on(LINK_PRODUCTO.of(producto)),
                Click.on(BOTON_AGREGAR_CARRITO),
                (new DriverTask(driver -> driver.switchTo().alert().accept())),
                Click.on(LINK_CARRITO)

        );
    }
}
