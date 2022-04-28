package co.com.devco.interactions;

import co.com.devco.tasks.IrAlHome;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_PRIMER_DELETE_PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;

public class AgregarMuchosProductos implements Interaction {

    private int cantidad;
    private String producto;

    public AgregarMuchosProductos(String cantidad,String producto) {
        this.cantidad =Integer.parseInt(cantidad);
        this.producto=producto;
    }

    public static AgregarMuchosProductos delTipo(String cantidad, String producto){

        return new AgregarMuchosProductos(cantidad,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (cantidad > 0){
            for (int i = 0; i < cantidad; i++){
                actor.attemptsTo(
                        IrAlHome.enElNavegador(),
                        Click.on(LINK_PRODUCTO.of(producto)),
                        Click.on(BOTON_AGREGAR_CARRITO)

                );
            }
        }
    }
}
