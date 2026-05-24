package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

// Wrapper for RestAssured
public class BaseService {

    //Base URI
    //Creating Request Specification
    //Creating Response Specification

    static{                                               // This setup needs to be done only once - So we use static initialization block
        RestAssured.filters(new LoggingFilter());         // To log the request and response details for all API calls made through RestAssured
    }

    private static final String BASE_URL = "http://64.227.160.186:8080";

    private RequestSpecification requestSpecification;

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer " + token);
    }

    protected Response postRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }

    protected Response getRequest(String endpoint, Map<String, Object> queryParams){
        return requestSpecification.queryParams(queryParams).get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response patchRequest(Object payload, String endpoint){
        return requestSpecification.contentType(ContentType.JSON).body(payload).patch(endpoint);
    }

    protected Response deleteRequest(String endpoint){
        return requestSpecification.delete(endpoint);
    }
}
