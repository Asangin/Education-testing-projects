package com.skryl.edu.stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;

import java.util.List;
import java.util.Map;

/**
 * @author Skryl D.V. on 2024-02-17
 */
public class DataTablesSteps {
    @Given("I placed an order for the following items")
    public void i_placed_an_order_for_the_following_items(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            System.out.println(columns);
        }
    }
    @When("I generate the bill")
    public void i_generate_the_bill() {
    }
    @Then("a bill for ${int} should be generated")
    public void a_bill_for_$_should_be_generated(Integer int1) {
    }

    @Given("I placed an order for the following items table")
    public void iPlacedAnOrderForTheFollowingItemsTable(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> billData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> billItems : billData) {
            for (Map.Entry<String, String> billItem: billItems.entrySet()) {
                System.out.printf("Key: %s Value: %s%n", billItem.getKey(), billItem.getValue());
            }
        }
    }
}
