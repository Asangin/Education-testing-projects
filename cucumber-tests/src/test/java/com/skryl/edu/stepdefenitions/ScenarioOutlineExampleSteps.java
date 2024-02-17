package com.skryl.edu.stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2024-02-17
 */
public class ScenarioOutlineExampleSteps {
    Integer initialBillAmount;
    Double taxRate;

    @Given("I have a Customer")
    public void i_have_a_customer() {
    }
    @Given("user enters intial bill amount as {int}")
    public void user_enters_intial_bill_amount_as(Integer initialBillAmount) {
        this.initialBillAmount = initialBillAmount;
        System.out.println("Initial bill amount: " + initialBillAmount);
    }
    @Given("Sales Tax Rate is {double} Percent")
    public void sales_tax_rate_is_percent(Double taxRate) {
        this.taxRate = taxRate;
        System.out.println("Tax Rate: " + taxRate);
    }

    @Then("final bill amount calculate is {double}")
    public void final_bill_amount_calculate_is(Double expectedValue) {
        var actualValue = this.initialBillAmount + this.taxRate;
        assertThat(actualValue).isEqualTo(expectedValue);
    }


}
