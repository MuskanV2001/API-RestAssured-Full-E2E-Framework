package com.api.base;

public class AccountCtrlrService extends BaseService{

    private static final String BASE_PATH = "/api/accounts";

    public void getBranchAccounts(String payload){
        postRequest(payload, BASE_PATH);
    }

    public void getAccountDetails(String payload){
        getRequest(BASE_PATH + payload);
    }

    public void getUserAccounts(){
        getRequest(BASE_PATH + "/user");
    }
}
