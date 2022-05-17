package com.skryl.edu.pages;

import com.microsoft.playwright.Page;

/**
 * @author Skryl D.V. on 2022-04-16
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class LoginPage {
    private final Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    public LoginPage goToLoginPage() {
        // Go to http://localhost:8080/#/login
        page.navigate("http://localhost:8080/#/login");
        return this;
    }

    public LoginPage enterUserName(String name) {
        // Click input[type="text"]
        page.click("input[type=\"text\"]");

        // Fill input[type="text"]
        page.fill("input[type=\"text\"]", name);
        return this;
    }

    public LoginPage enterPassword(String password) {
        // Click input[type="password"]
        page.click("input[type=\"password\"]");

        // Fill input[type="password"]
        page.fill("input[type=\"password\"]", password);
        return this;
    }

    public MainPage clickLogin() {
        // Click button:has-text("Log in")
        // page.waitForNavigation(new Page.WaitForNavigationOptions().setUrl("http://localhost:8080/#/home"), () ->
        page.waitForNavigation(() -> {
            page.click("button:has-text(\"Log in\")");
        });
        return new MainPage(page);
    }
}
