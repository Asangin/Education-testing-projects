package com.skryl.edu.dataprovider;

import org.testng.annotations.Test;

/**
 * @author Skryl D.V. on 2022-06-29
 */
public class DataProviderTests {

    @Test(dataProvider = "dataProviderMethod", dataProviderClass = DataProvider.class)
    public void myTest (String val) {
        System.out.println("Current Status : " + val);
    }
}
