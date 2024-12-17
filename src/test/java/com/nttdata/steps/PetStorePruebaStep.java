package com.nttdata.steps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.time.Instant;



public class PetStorePruebaStep {
    Response response;
    private String  URL_BASE;
    private  String  ENDPOINT;
    private  String  ENDPOINT_CON;
    public void definirUrl(String url) {
        URL_BASE=url;
    }

    public void definirEndpoint(String endpoint) {
        ENDPOINT=endpoint;
    }

    public void definirEndpointCon(String endpointCon) {
        ENDPOINT_CON=endpointCon;

    }
    public void crearOrden(String id, String petId, String quantity, String shipDate, String status, String complete) {
    String body ="{\n" +
            "  \"id\":"+id+",\n" +
            "  \"petId\":"+petId+",\n" +
            "  \"quantity\":"+quantity+",\n" +
            "  \"shipDate\": \""+shipDate+"\",\n" +
            "  \"status\": \""+status+"\",\n" +
            "  \"complete\":"+complete+"\n" +
            "}";

        response= RestAssured
                .given()
                .baseUri(URL_BASE)
                .header("Content-Type","application/json")
                .relaxedHTTPSValidation()
                .body(body)
                .post(ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response()
        ;

    }

    public void validarRespuesta(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }

    public void validarBody(String id, String petId, String quantity, String shipDate, String status, String complete) {
        Assert.assertEquals(response.jsonPath().getString("id"),id);
        Assert.assertEquals(response.jsonPath().getString("petId"),petId);
        Assert.assertEquals(response.jsonPath().getString("quantity"),quantity);
        Assert.assertEquals(response.jsonPath().getString("shipDate"),shipDate);
        Assert.assertEquals(response.jsonPath().getString("status"),status);
        Assert.assertEquals(response.jsonPath().getString("complete"), complete);

    }

    public void consultarPedido(String orderId) {
        response= RestAssured.given()
                .relaxedHTTPSValidation()
                .baseUri(URL_BASE)
                //.log().all()
                .get(ENDPOINT_CON)
                .then()
                .log()
                .all()
                .extract()
                .response()
                ;
    }


    public void validarBodyId(String orderId) {
        Assert.assertEquals(response.jsonPath().getString("id"),orderId);    }

    public void validarNulo() {
        Assert.assertNotNull("El objeto no debería ser nulo", response);
    }



}
