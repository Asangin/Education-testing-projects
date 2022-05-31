package com.skryl.edu;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;

import static org.hamcrest.Matchers.equalTo;

/**
 * @author Skryl D.V. on 2022-05-26
 */
@ExtendWith(MockServerExtension.class)
@MockServerSettings(ports = {8787, 8888})
public class ServerMockTest {
    private MockServerClient client;

    @BeforeEach
    public void beforeEachLifecyleMethod(MockServerClient client) {
        this.client = client;
    }

    @Test
    void testSomething() {
        client.when(HttpRequest.request()
                .withMethod("GET")
                .withPath("/view/cart")
                .withQueryStringParameter("cartId", "055CA455-1DF7-45BB-8535-4F83E7266092")
        ).respond(
                HttpResponse.response()
                        .withBody("some_response_body")
        );

        RestAssured.given()
                .log().all()
                .queryParam("cartId", "055CA455-1DF7-45BB-8535-4F83E7266092")
                .get("http://localhost:8787/view/cart")
                .then()
                .log().all()
                .statusCode(200)
                .body(equalTo("some_response_body"));
    }
}
