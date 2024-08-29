package com.skryl.edu;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/**
 * @author Skryl D.V. on 2024-08-29
 */
public class WireMockRealServerMockTest {
    private static WireMockServer wireMockServer;

    @BeforeAll
    static void setupRestAssured() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @BeforeEach
    void setupProxy() {
        wireMockServer = new WireMockServer(options().port(3001));
        wireMockServer.start();
    }

    @AfterEach
    void teardownProxy() {
        wireMockServer.stop();
    }

    @Test
    void proxyGoogleSearchResponse() {
        wireMockServer.stubFor(
                get(urlMatching(".*"))
                        .willReturn(
                                aResponse()
                                        .proxiedFrom("https://google.com")
                        )
        );
        var response = RestAssured.get(wireMockServer.baseUrl());
        response.then().statusCode(200);
    }

    @Test
    void mockGoogleSearchResponse() {
        wireMockServer.stubFor(
                get(urlMatching(".*"))
                        .willReturn(
                                aResponse()
                                        .proxiedFrom("https://google.com")
                                        .withAdditionalRequestHeader("hello", "world")
                        )
                        .willReturn(
                                aResponse().withStatus(500)
                                        .withHeader("hello", "world")
                        )
        );
        var response = RestAssured.get(wireMockServer.baseUrl());
        response.then().statusCode(500);
        response.then().header("hello", "world");
    }
}
