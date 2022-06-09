package com.inte;

import com.inte.config.Config;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.BeforeClass;

public class BaseInterviewTests {

    @BeforeClass(alwaysRun = true)
    public void init() throws ConfigurationException {
        Config.getInstance();
    }
}
