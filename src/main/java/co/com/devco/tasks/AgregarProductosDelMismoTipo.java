package co.com.devco.tasks;

import co.com.devco.interactions.AgregarMuchosProductos;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarProductosDelMismoTipo implements Task {
    private String producto;
    private String cantidad;

    public AgregarProductosDelMismoTipo(String cantidad,String producto) {
        this.cantidad=cantidad;
        this.producto = producto;
    }

    public static Performable alCarrito(String cantidad, String producto) {
        return instrumented(AgregarProductosDelMismoTipo.class,cantidad, producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                AgregarMuchosProductos.delTipo(cantidad,producto),
                IrAlCarrito.enElNavegador()


        );

    }
}
