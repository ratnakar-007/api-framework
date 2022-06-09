package com.inte.utils;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.inte.reporting.ExtentTestManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtil {
    public static <T> Response execute(T content, String baseUrl, String methodType) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

        requestSpecBuilder.setBaseUri(baseUrl);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.setBody(new Gson().toJson(content));

        RequestSpecification requestSpecification = requestSpecBuilder.build();
        return baseRestImpl(requestSpecification, methodType);

    }

    private static Response baseRestImpl(RequestSpecification requestSpecification, String methodType) {
        Response response = null;

        switch (methodType) {
            case "POST":
                response = RestAssured.given().spec(requestSpecification).log().all().post();
                break;

            default:
                throw new RuntimeException("Method type not supported.");
        }

        response.prettyPrint();
        ExtentTestManager.getTest().log(Status.INFO, response.getBody().asPrettyString());
        return response;

    }
}
