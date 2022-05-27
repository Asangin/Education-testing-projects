package com.skryl.edu;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/**
 * @author Skryl D.V. on 2022-05-17
 * Copyright © 2022 Perenio. All rights reserved.
 */
class WireMockTest {
    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void setUp() {
        wireMockServer = new WireMockServer(options().port(3001)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();

        wireMockServer.stubFor(get("/api/books")
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withStatusMessage("OK")
                                .withBody("""
                                        {
                                          "content": [
                                            {
                                              "category": {
                                                "id": 0,
                                                "name": "string"
                                              },
                                              "categoryId": 0,
                                              "format": {
                                                "id": 0,
                                                "name": "string"
                                              },
                                              "formatId": 0,
                                              "id": 0,
                                              "isbn": "string",
                                              "title": "string"
                                            }
                                          ],
                                          "last": true,
                                          "numberOfElements": 0,
                                          "page": 0,
                                          "size": 0,
                                          "totalElements": 0,
                                          "totalPages": 0
                                        }
                                        """)
                ));
    }

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void booksTest() {
        var response= RestAssured.given()
                .accept(ContentType.JSON)
                .get("http://localhost:3001/api/books");
        response.getBody().prettyPrint();
        response.then().statusCode(200);
    }
}