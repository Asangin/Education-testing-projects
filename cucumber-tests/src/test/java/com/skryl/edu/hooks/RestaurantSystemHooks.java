package com.skryl.edu.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * @author Skryl D.V. on 2024-02-17
 */
public class RestaurantSystemHooks {

    @Before("@SmokeTests")
    public void BeforeDisplayMessage(Scenario scenario) {
        System.out.println("before " + scenario.getName());
    }

    @After("@SmokeTests")
    public void AfterDisplayMessage(Scenario scenario) {
        System.out.println("after " + scenario.getName());
    }

}
