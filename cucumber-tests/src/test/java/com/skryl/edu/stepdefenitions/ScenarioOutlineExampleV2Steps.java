package com.skryl.edu.stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2024-02-27
 */
@Slf4j
public class ScenarioOutlineExampleV2Steps {
    private String permission;
    @Given("I am {string} user")
    public void i_am_user(String user) {
        log.info(user);
        switch (user) {
            case "admin":
                this.permission = "Yes";
                break;
            case "manager":
                this.permission = "No";
                break;
            case "user":
                this.permission = "No";
                break;
            default:
                this.permission = "Undefined";
                break;
        }
    }
    @When("Create a new entity")
    public void create_a_new_entity() {
        log.info("some action");
    }
    @Then("{string} I am permitted to use this Feature")
    public void i_am_permitted_to_use_this_feature(String permission) {
        log.info("Actual permission: " + this.permission);
        assertThat(this.permission).isEqualTo(permission);
    }
}
