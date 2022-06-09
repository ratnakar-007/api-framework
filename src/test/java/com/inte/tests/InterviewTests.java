package com.inte.tests;

import com.google.gson.Gson;
import com.inte.BaseInterviewTests;
import com.inte.actions.UserActions;
import com.inte.dataprovider.TestDataProvider;
import com.inte.dto.Users;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InterviewTests extends BaseInterviewTests {

    @Test(testName = "Create User",
            dataProvider = "userData",
            dataProviderClass = TestDataProvider.class,
            groups = "interview")
    public void create_user(String name, String job) {
        Users user = Users.builder()
                .name(name)
                .job(job)
                .build();

        UserActions userActions = new UserActions();

        Response response = userActions.createUser(user);
        Assert.assertEquals(response.getStatusCode(),
                201,
                "Expected status code is different");

        Users createdUser = new Gson().fromJson(response.body().asString(), Users.class);

        Assert.assertNotNull(createdUser);
        Assert.assertEquals(createdUser.getName(),
                user.getName(),
                "Expected name is different from observed");
    }

}
