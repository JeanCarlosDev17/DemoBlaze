package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_DELETE_PRODUCTO_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EliminarDelCarrito implements Task {
    private String producto;


    public EliminarDelCarrito(String producto) {
        this.producto = producto;
    }

    public static Performable elProducto(String producto) {
        return instrumented(EliminarDelCarrito.class, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(LINK_DELETE_PRODUCTO_CARRITO.of(producto))
        );

    }
}
