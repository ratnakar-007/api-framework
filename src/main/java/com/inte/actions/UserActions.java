package com.inte.actions;

import com.aventstack.extentreports.Status;
import com.inte.config.Config;
import com.inte.dto.Users;
import com.inte.reporting.ExtentTestManager;
import com.inte.urls.RestUrlMapper;
import com.inte.utils.RestUtil;
import io.restassured.response.Response;

public class UserActions {

    public Response createUser(Users user) {
        String baseUrl = Config.getBaseUrl() + RestUrlMapper.CREATE_USER.getBaseUrl();

        ExtentTestManager.getTest().log(Status.INFO, "create user: " + baseUrl);

        return RestUtil.execute(user, baseUrl, "POST");
    }
}
