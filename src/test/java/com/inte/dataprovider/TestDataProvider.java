package com.inte.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"name1", "job1"},
                {"name2", "job2"},
        };
    }
}
