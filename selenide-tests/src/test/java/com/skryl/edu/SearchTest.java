package com.skryl.edu;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * @author Skryl D.V. on 2022-09-15
 */
public class SearchTest {

    @BeforeEach
    void openHomePage() {
        open("https://gsmserver.com/");
    }

    @Test
    void searchProductTest() {
        String searchQuery = "Z3X Easy-Jtag Plus";
        String productName = "Z3X Easy-Jtag Plus UFS Kit";
        String productKey = "886749";
        $("[name='searchword']").val(searchQuery).pressEnter();

        //[space='component/product/grid'][key='902287']
        getProductByKey(productKey).$(".pr-t_name").shouldHave(text(productName));
        getProductByKey(productKey).$(".btn-buy").click();
        getProductByKey(productKey).$(".quantity-input")
                .$("[name='quantity']")
                .shouldHave(attribute("value", "1"));
        $("[space='widget/cart/header-block']").click();

        $$("[space='component/product/table'] [space='component/product/tiny']").should(CollectionCondition.size(1));
        sleep(5000);
    }
    
    @Test
    public void searchProductByTitleTest() {
        String searchQuery = "Z3X Easy-Jtag Plus";
        String productName = "Z3X Easy-Jtag Plus UFS Kit";
        String productKey = "886749";
        new HomePage().searchFor(searchQuery);
        var actualSearchResultTitle = new SearchResultPage().getSearchResultTitle(productKey);

        Assertions.assertEquals(productName, actualSearchResultTitle);
    }
    
    

    private static SelenideElement getProductByKey(String productKey) {
        return $("[space='component/product/grid'][key='%s']".formatted(productKey));
    }
}
