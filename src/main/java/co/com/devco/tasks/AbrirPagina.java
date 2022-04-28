package co.com.devco.tasks;

import co.com.devco.model.UsuarioFactory;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_LOGIN;
import static co.com.devco.userinterfaces.DemoblazeLoginPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AbrirPagina implements Task {


    public static Performable enElNavegador()  {
        return instrumented(AbrirPagina.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url("https://www.demoblaze.com/#")
        );
    }
}
