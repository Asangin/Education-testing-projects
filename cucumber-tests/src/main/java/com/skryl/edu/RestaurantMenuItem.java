package com.skryl.edu;

import lombok.Data;

/**
 * @author Skryl D.V. on 2024-02-15
 */
@Data
public class RestaurantMenuItem {
    private String itemName;
    private Integer price;
    private String description;
    private Integer calories;
    public RestaurantMenuItem(String menuItemName, Integer price) {
        this.price = price;
        this.itemName = menuItemName;
    }

}
