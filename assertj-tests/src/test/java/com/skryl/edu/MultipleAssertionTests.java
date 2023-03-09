package com.skryl.edu;

import com.skryl.edu.preconditions.StartFakeServer;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

/**
 * @author Skryl D.V. on 2023-03-03
 */
@StartFakeServer
public class MultipleAssertionTests {

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    @Test
    void multipleAssertionFofJsonFields() throws Exception {
        var response = RestAssured.get("http://localhost:3001/json/structure");
        var softAssertion = new SoftAssertions();
        try {
            softAssertion.assertThat(response.jsonPath().getString("manufacturerModel")).isEqualTo("test-model-skryl");
            if (System.getProperty("heelo") == null) {
                throw new Exception("Heeelo");
            }
            softAssertion.assertThat(response.jsonPath().getInt("totalCount")).isEqualTo(1);
            softAssertion.assertThat(response.jsonPath().getString("manufacturer")).isEqualTo("!");
        } finally {
            // soft assertion will not throw any error due to another exception that happened during test
            softAssertion.assertAll();
            System.out.println("Finally block");
        }
    }
}
