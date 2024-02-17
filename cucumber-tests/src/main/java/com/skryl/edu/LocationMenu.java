package com.skryl.edu;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Skryl D.V. on 2024-02-15
 */
@Getter
public class LocationMenu {
    private final List<RestaurantMenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(RestaurantMenuItem item) {
        menuItems.add(item);
    }


}
