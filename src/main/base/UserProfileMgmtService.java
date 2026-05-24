package com.api.base;

import com.api.models.request.ProfileRequest;
import io.restassured.response.Response;

public class UserProfileMgmtService extends BaseService{

    private static final String BASE_PATH = "/api/users";

    public Response getUserProfile(String token){
        setAuthToken(token);
        return getRequest(BASE_PATH + "/profile");
    }

    public Response updateProfile(String token, ProfileRequest payload){
        setAuthToken(token);
        return putRequest(payload, BASE_PATH + "/profile");
    }

    public Response partialUpdateProfile(String token, String payload){
        setAuthToken(token);
        return patchRequest(payload, BASE_PATH + "/profile");
    }

    public Response deleteProfile(String token){
        setAuthToken(token);
        return deleteRequest(BASE_PATH + "/profile");
    }
}
