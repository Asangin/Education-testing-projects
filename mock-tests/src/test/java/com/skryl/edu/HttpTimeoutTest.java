package com.skryl.edu;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Skryl D.V. on 2022-06-09
 */
public class HttpTimeoutTest {
    private static WireMockServer wireMockServer;
    @BeforeAll
    public static void setUp() {
        wireMockServer = new WireMockServer(options().port(3002));
        wireMockServer.start();
    }

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }


    @Test
    void noDefaultTimeoutInRestAssuredTest() {
        wireMockServer.stubFor(get(urlEqualTo("/delayed")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withFixedDelay(35000)));

        RestAssured.get("http://localhost:3002/delayed")
                .then().statusCode(200);
    }

    @Test
    void customTimeoutInRestAssuredTest() {
        wireMockServer.stubFor(get(urlEqualTo("/delayed2")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withFixedDelay(5000)));

        RestAssuredConfig config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout",6)); // 6 sec timeout
        RestAssured
                .given()
                .config(config)
                .get("http://localhost:3002/delayed2")
                .then().statusCode(200);
    }

    @Test
    void failedTimeoutInRestAssuredTest() {
        wireMockServer.stubFor(get(urlEqualTo("/delayed2")).willReturn(
                aResponse()
                        .withStatus(200)
                        .withFixedDelay(5000)));

        RestAssuredConfig config = RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout",2)); // 2 sec timeout

        assertThatThrownBy(() -> {
            RestAssured.given()
                    .config(config)
                    .get("http://localhost:3002/delayed2");
        }).isInstanceOf(ConnectTimeoutException.class);
    }
}
