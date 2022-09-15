package com.skryl.edu;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

/**
 * @author Skryl D.V. on 2022-09-15
 */
public class SearchResultPage {
    public String getSearchResultTitle(String productKey) {
        return $("[space='component/product/grid'][key='%s']".formatted(productKey))
                .$(".pr-t_name")
                .shouldHave(Condition.visible)
                .getText();
    }
}
