package com.skryl.edu.preconditions;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/**
 * @author Skryl D.V. on 2023-03-03
 */
public class FakeServerExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private WireMockServer wireMockServer;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        wireMockServer = new WireMockServer(options().port(3001)); //No-args constructor will start on port 8080, no HTTPS
        wireMockServer.start();
        wireMockServer.stubFor(get("/json/structure")
                .willReturn(
                        aResponse()
                                .withStatus(200)
                                .withStatusMessage("OK")
                                .withBodyFile("fake_response.json")
                ));
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        wireMockServer.stop();
    }

}
