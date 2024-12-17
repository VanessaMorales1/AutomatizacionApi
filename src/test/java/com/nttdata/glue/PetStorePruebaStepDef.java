package com.nttdata.glue;

import com.nttdata.steps.PetStorePruebaStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStorePruebaStepDef {
    @Steps
    PetStorePruebaStep tienda;

    @Given("la url base del servicio es {string}")
    public void laUrlBaseDelServicioEs(String url) {
        tienda.definirUrl(url);
    }

    @And("el usuario tiene los datos de una nueva orden con {string}")
    public void elUsuarioTieneLosDatosDeUnaNuevaOrdenCon(String arg0) {

    }


    @When("creacion de una nueva orden con los siguientes datos {string}, {string},{string},{string},{string} , {string}")
    public void creacionDeUnaNuevaOrdenConLosSiguientesDatos(String id, String petId, String quantity, String shipDate, String status, String complete) {
    tienda.crearOrden(id,petId,quantity,shipDate,status,complete);
    }

    @Then("valido que el codigo de respuesta sea {int}")
    public void validoQueElCodigoDeRespuestaSea(int statusCode) {
    tienda.validarRespuesta(statusCode);
    }

    @And("el body de la respuesta contiene los siguientes datos {string}, {string},{string},{string},{string} , {string}")
    public void elBodyDeLaRespuestaContieneLosSiguientesDatos(String id, String petId, String quantity, String shipDate, String status, String complete) {
    tienda.validarBody(id,petId,quantity,shipDate,status,complete);
    }

    @When("se consulta el pedido con ID {string}")
    public void seConsultaElPedidoConID(String orderId) {
        tienda.consultarPedido(orderId);

    }

    @And("el body de la respuesta contiene el Id de la orden {string}")
    public void elBodyDeLaRespuestaContieneElIdDeLaOrden(String orderId) {
        tienda.validarBodyId(orderId);
    }

    @And("el body de la respuesta no es nulo")
    public void elBodyDeLaRespuestaNoEsNulo() {
        tienda.validarNulo();
    }

    @And("la ruta del enpoint para crear una orden es {string}")
    public void laRutaDelEnpointParaCrearUnaOrdenEs(String endpoint) {
        tienda.definirEndpoint(endpoint);
    }

    @And("la ruta del enpoint para consultar una orden es {string}")
    public void laRutaDelEnpointParaConsultarUnaOrdenEs(String endpointCon) {
        tienda.definirEndpointCon(endpointCon);
    }
}