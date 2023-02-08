package com.skryl.edu.dataprovider;

/**
 * @author Skryl D.V. on 2022-06-29
 */
public class DataProvider {

    @org.testng.annotations.DataProvider
    public static Object[][] dataProviderMethod(){
        return new Object[][] {{"First-Value"}, {"Second-Value"}};
    }

}
