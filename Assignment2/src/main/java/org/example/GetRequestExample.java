package org.example;

import io.restassured.RestAssured;

import static junit.framework.Assert.assertEquals;

public class GetRequestExample {

    public static void main(String[] args) {
        String baseUri = "https://api.opap.gr/draws/v3.0/1100/active";


        ActiveDraw activeDraw = RestAssured.get(baseUri)
                .then()
                .extract()
                .as(ActiveDraw.class);

        System.out.println("Deserialized Object: " + activeDraw);

        System.out.println("Draw ID: " + activeDraw.getDrawId());


        String expectedStatus = "active";
        assertEquals("Draw status does not match!", expectedStatus, activeDraw.getStatus());
    }
}
