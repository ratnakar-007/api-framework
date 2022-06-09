package com.inte.urls;

public enum RestUrlMapper {

    GET_USER("api/users/%s"),
    LIST_USERS("api/users"),
    CREATE_USER("api/users"),
    UPDATE_USER("api/users/%s"),
    DELETE_USER("api/users/%s");

    String endPoint;

    RestUrlMapper(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getBaseUrl(String... args) {
        return String.format(this.endPoint, (Object[])args);
    }

 }
