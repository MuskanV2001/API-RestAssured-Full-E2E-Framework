package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserMgmtAPITest {

    @Test(description = "New User Account Creation")
    public void newUserSignupTest(){
        AuthService authService = new AuthService();
        SignupRequest signupRequest = new SignupRequest(
                "mikeRosstest",
                "userpassword123",
                "mikeross45@gmail.com",
                "Mike",
                "Ross",
                "8828648322");
        Response response  = authService.signup(signupRequest);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 for successful signup");
        System.out.println("Signup Response: " + response.asPrettyString());
    }

    @Test(description = "Duplicate User Signup Test")
    public void duplicateUserSignUpTest(){
        AuthService authService = new AuthService();
        SignupRequest signupRequest = new SignupRequest(
                "mikeRosstest",
                "userpassword123",
                "mikeross45@gmail.com",
                "Mike",
                "Ross",
                "8828648322");
        Response response = authService.signup(signupRequest);
        Assert.assertEquals(response.getStatusCode(), 400, "Expected status code 400 for duplicate user signup");
        System.out.println("Duplicate Signup Response: " + response.asPrettyString());
    }


    @Test(description = "New user creation using Builder Design Pattern")
    public void createNewUserBuilderPattern(){
        AuthService authService = new AuthService();

        // Since the Builder() class is static inner class it can be directly accessed using outer class
        SignupRequest requestPayload = new SignupRequest.Builder()
                .firstName("Ed1")
                .lastName("Warren1")
                .username("edwarren1231")
                .password("ed#12341")
                .email("edwarren1231@gmail.com")
                .mobileNumber("9876543210")
                .build();

        Response response = authService.signup(requestPayload);
        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code 200 for successful signup");
        System.out.println("Signup Response (Builder Pattern): " + response.asPrettyString());
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
    }

    @Test(description = "Test Forgot Password endpoint")
    public void forgotPasswordTest(){
        AuthService authService = new AuthService();
        Response response  = authService.forgotPassword("edwarren1231@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
