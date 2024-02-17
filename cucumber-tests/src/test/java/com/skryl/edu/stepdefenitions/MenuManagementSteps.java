package com.skryl.edu.stepdefenitions;

import com.skryl.edu.LocationMenu;
import com.skryl.edu.RestaurantMenuItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2024-02-15
 */
public class MenuManagementSteps {
    RestaurantMenuItem menuItem;
    LocationMenu locationMenu;
    @Given("I have a menu item with name {string} and price {int}")
    public void i_have_a_menu_item_with_name_and_price(String newMenuItemName, Integer price) {
        menuItem = new RestaurantMenuItem(newMenuItemName, price);
        System.out.println("step 1");
    }

    @When("I add that menu item")
    public void i_add_that_menu_item() {
        locationMenu = new LocationMenu();
        locationMenu.addMenuItem(menuItem);
        System.out.println("step 2");
    }

    @Then("Menu Item with name {string} should be added")
    public void menu_item_with_name_should_be_added(String menuItemName) {
        assertThat(locationMenu.getMenuItems())
                .map(RestaurantMenuItem::getItemName)
                .contains(menuItemName);
        System.out.println("step 3");
    }
}
