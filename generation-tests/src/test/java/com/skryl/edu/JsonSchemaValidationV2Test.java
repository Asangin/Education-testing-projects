package com.skryl.edu;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.skryl.edu.model.v2.Input;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2022-05-27
 */
@WireMockTest(httpPort = 8090)
public class JsonSchemaValidationV2Test {


    @Test
    public void givenUrl_whenJsonResponseConformsToSchema_thenCorrect() {
        stubFor(
                WireMock.get("/events?id=390")
                        .willReturn(
                                aResponse()
                                        .withStatus(200)
                                        .withStatusMessage("OK")
                                        .withHeader("Content-Type", "application/json; charset=utf-8")
                                        .withBodyFile("v2/input.json")
                        )

        );
        RestAssured.baseURI = "http://localhost:8090";
        Response response = RestAssured.get("/events?id=390");
        response.then().assertThat()
                .body(matchesJsonSchemaInClasspath("schema/v2/input.json"));
        Input input = response.as(Input.class);

        System.out.println(input);
        assertThat(input.getName()).isEqualTo("Skryl");
    }
}
