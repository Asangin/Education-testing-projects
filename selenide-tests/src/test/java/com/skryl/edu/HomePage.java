package com.skryl.edu;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Skryl D.V. on 2022-09-15
 */
public class HomePage {

    public void searchFor(String searchQuery) {
        $("[name='searchword']").val(searchQuery).pressEnter();
    }
}
