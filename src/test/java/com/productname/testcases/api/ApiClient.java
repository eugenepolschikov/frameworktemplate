package com.productname.testcases.api;

import static io.restassured.RestAssured.given;


public class ApiClient {
    public static String restAssuredGet(String baseUrl) {
        // restasured client init, GET
        String myJson = given()
            .when()
            .get(baseUrl)
            .then()
            .statusCode(200)
            .extract().response().asString();

        return myJson;

    }

}
