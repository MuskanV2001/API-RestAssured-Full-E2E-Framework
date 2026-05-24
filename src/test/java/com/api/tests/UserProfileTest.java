package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileMgmtService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.ProfileResponse;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.api.listeners.TestListener.class)
public class UserProfileTest {

    @Test(description = "Test to get user profile")
    public void getUserProfileTest() {

        //STEP 1 : Login into the App

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("edwarren1231", "ed#12341"));

        //STEP 2 : Fetch the token from response after logging in

        String loginToken = response.as(LoginResponse.class).getToken();
        System.out.println("Login Token: " + loginToken);

        //STEP 3 : Get profile details using the token

        UserProfileMgmtService userProfileMgmtService = new UserProfileMgmtService();
        response = userProfileMgmtService.getUserProfile(loginToken);

        ProfileResponse profile = response.as(ProfileResponse.class);
        System.out.println("User Profile Response: " + profile.toString());
    }


    @Test(description = "Test to update user profile")
    public void updateUserProfile() {

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("edwarren1231", "ed#12341"));
        String loginToken = response.as(LoginResponse.class).getToken();
        System.out.println("Login Token: " + loginToken);

        System.out.println("----------------------------------------------------------------------------------");

        UserProfileMgmtService userProfileMgmtService = new UserProfileMgmtService();
        response = userProfileMgmtService.getUserProfile(loginToken);
        System.out.println(response.asPrettyString());

        System.out.println("----------------------------------------------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("Ed1")
                .lastName("Warren1")
                .email("jenny@01gmail.com")
                .mobileNumber("3333333333")
                .build();
        response = userProfileMgmtService.updateProfile(loginToken, profileRequest);
        System.out.println(response.asPrettyString());
    }
}
