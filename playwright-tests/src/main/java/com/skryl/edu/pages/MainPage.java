package com.skryl.edu.pages;

import com.microsoft.playwright.Page;

/**
 * @author Skryl D.V. on 2022-04-16
 * Copyright © 2022 Perenio. All rights reserved.
 */
public class MainPage{
    private final Page page;

    public MainPage(Page page) {
        this.page = page;
    }

    public enum BookCategory {
        TechnicalBook("Technical Book"), Magazine("Magazine"), Novel("Novel");
        private final String category;

        public String getCategoryName() {
            return category;
        }

        BookCategory(String category) {
            this.category = category;
        }
    }

    public enum BookFormat {
        PaperBook("Paper Book"), eBook("e-Book");
        private final String format;

        public String getFormatName() {
            return format;
        }

        BookFormat(String format) {
            this.format = format;
        }
    }

    public MainPage addNewBook() {
        // Click button:has-text("add")
        page.click("button:has-text(\"add\")");
        return this;
    }

    public MainPage enterBookName(String bookName) {
        // Click text=Title ISBN Category Technical Book Magazine Novel Format Paper Book e-Book >> input[type="text"]
//        String selector = "//label[text()=\"Title\"] > ";
//        String selector = "//label[text()=\"Title\"] > ";
//        String selector = "text=Title";
        String selector = ".md-field:has-text(\"Title\") > input";
//        String selector = "input:below(:text(\"Title\"))";

//        page.click(selector);
        page.locator(selector).click();
        // Fill text=Title ISBN Category Technical Book Magazine Novel Format Paper Book e-Book >> input[type="text"]
//        page.fill(selector, bookName);
        page.locator(selector).fill(bookName);
        return this;
    }

    public MainPage enterISBNnumber(String number) {
        // Click #md-input-sffq8zu3l
//        page.click("//label[text()=\"ISBN\"]");
        String selector = ".md-field:has-text(\"ISBN\") > input";
        page.click(selector);

        // Fill #md-input-sffq8zu3l
        page.fill(selector, number);
        return this;
    }

    public MainPage chooseCategory(BookCategory bookCategory) {
        // Click text=Category Technical Book Magazine Novel >> input[type="text"]
        page.click("text=Category Technical Book Magazine Novel >> input[type=\"text\"]");

        // Click button:has-text("Magazine")
        page.click("button:has-text(\""+bookCategory.getCategoryName()+"\")");
        return this;
    }

    public MainPage chooseFormat(BookFormat bookFormat) {
        // Click text=Format Paper Book e-Book >> input[type="text"]
        page.click("text=Format Paper Book e-Book >> input[type=\"text\"]");

        // Click button:has-text("e-Book")
        page.click("button:has-text(\""+bookFormat.getFormatName()+"\")");
        return this;
    }

    public MainPage createBook() {
        // Click button:has-text("Create")
        page.click("button:has-text(\"Create\")");
        // Click :nth-match(button:has-text("OK"), 4)
        page.click(":nth-match(button:has-text(\"OK\"), 4)");
        return this;
    }

    public MainPage startEdit() {
        // Click button:has-text("Edit")
        page.click("button:has-text(\"Edit\")");
        return this;
    }

    public MainPage stopEdit() {
        // Click button:has-text("Edit")
        page.click("button:has-text(\"Edit\")");

        // Click :nth-match(button:has-text("OK"), 4)
        page.click(":nth-match(button:has-text(\"OK\"), 4)");
        return this;
    }

    public MainPage searchBook(String bookName) {
        // Click input[type="text"]
        page.click("input[type=\"text\"]");

        // Fill input[type="text"]
        page.fill("input[type=\"text\"]", bookName);

        // Press Enter
        page.press("input[type=\"text\"]", "Enter");
        return this;
    }



}
