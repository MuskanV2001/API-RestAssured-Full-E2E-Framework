package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Test the login API with valid credentials")
    public void loginTest(){

        baseURI = "http://64.227.160.186:8080";

        RequestSpecification request = given();
        RequestSpecification request2 = request.header("Content-Type", "application/json");
        RequestSpecification request3 = request2.body("{\"username\": \"MVish\", \"password\": \"muskan123\"}");
        Response response = request3.post("/api/auth/login");

        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

    }

    @Test(description = "Method Chaining: Test the login API with valid credentials")
    public void loginTest2(){
        Response response = given()
                .baseUri("http://64.227.160.186:8080")
                .header("Content-Type", "application/json")
                .body("{\"username\": \"MVish\", \"password\": \"muskan123\"}")
                .post("/api/auth/login");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

    }

    @Test(description = "Auth Service Login Test")
    public void loginTest3(){
        AuthService authService = new AuthService();

        LoginRequest loginRequest = new LoginRequest("MVish", "muskan123");

        Response response = authService.login(loginRequest); //Automatic Serialization of LoginRequest to JSON

        System.out.println(response.asPrettyString());

        LoginResponse loginResponse  = response.as(LoginResponse.class);
        System.out.println("Token: " + loginResponse.getToken());
        Assert.assertTrue(loginResponse.getToken() != null && !loginResponse.getToken().isEmpty(), "Token should not be null or empty");

        Assert.assertEquals(loginResponse.getUsername(), "MVish", "Username should be MVish");
    }
}
