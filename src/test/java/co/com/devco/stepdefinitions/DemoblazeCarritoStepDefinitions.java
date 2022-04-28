package co.com.devco.stepdefinitions;

import co.com.devco.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.Alert;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeCarritoStepDefinitions {

    @Dado("que {string} se loguea como {string}")
    public void loguin(String actor, String rol) {
        theActorCalled(actor).attemptsTo(
                AbrirPagina.enElNavegador(),
                Loguearse.como(rol),
                LimpiarCarrito.completamente()
        );
    }

    @Cuando("agrega el {string} al carrito vacio")
    public void agregarObjetoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(producto),
                IrAlCarrito.enElNavegador()
        );
    }

    @Entonces("debe ver como unico elemento el {string}")
    public void verificarObjetoCarrito(String producto) {

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRODUCTOS_CARRITO).values().hasSize(1),
                Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).isEnabled()
        );
    }
    //    hasta aqui funciona


    @Cuando("{string} agrega el {string} al carrito vacio")
    public void agregarObjetoEjemploAlCarrito(String actor, String producto) {
        // Write code here that turns the phrase above into concrete actions
        theActorCalled(actor).attemptsTo(
                AbrirPagina.enElNavegador(),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto),
                IrAlCarrito.enElNavegador()
        );
    }

    @Dado("{string} agrega {string} y {string} al carrito vacio")
    public void agregarDosProductosDistintos(String actor, String producto1, String producto2) {
        theActorCalled(actor).attemptsTo(
                AbrirPagina.enElNavegador(),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto1),
                IrAlHome.enElNavegador(),
                AgregarAlCarrito.elProducto(producto2),
                IrAlCarrito.enElNavegador()
        );

    }

    //        eliminar el samsung


    @Cuando("elimina el {string}")
    public void EliminarObjetoDelCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.elProducto(producto)

        );
    }

    //        assert nexus


}
