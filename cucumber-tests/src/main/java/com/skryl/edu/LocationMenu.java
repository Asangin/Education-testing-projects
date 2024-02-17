package com.skryl.edu;

import com.skryl.edu.RestaurantMenuItem;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Skryl D.V. on 2024-02-15
 */
public class LocationMenu {
    @Getter
    private List<RestaurantMenuItem> menuItems = new ArrayList<>();

    public void addMenuItem(RestaurantMenuItem item) {
        menuItems.add(item);
    }


}
