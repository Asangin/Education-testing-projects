package com.skryl.edu.scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

/**
 * Before running this scenario. clone and run this repository
 * <a href=https://github.com/Asangin/python-application-under-test>Python AUT</a>
 * @author Skryl D.V. on 2022-10-03
 */
public class SoakSimulation extends Simulation {
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://127.0.0.1:5000")
            .acceptHeader("application/json")
            .contentTypeHeader("application/json");

    ScenarioBuilder scn = scenario("Get all users")
            .exec(http("User list")
                    .get("/public/api/v1/users"));

    ScenarioBuilder foreverScn = scenario("Get all users")
            .forever() // scenario that runs forever
            .on(exec(http("User list")
                    .get("/public/api/v1/users")));

    ScenarioBuilder soakScnWithDuration = scenario("Get all users")
            .during( 500) // add duration for stability testing (in seconds)
            .on(exec(http("User list")
                    .get("/public/api/v1/users")));

    {
        setUp(scn.injectOpen(rampUsers(10).during(10)))
                .protocols(httpProtocol);
    }
}
