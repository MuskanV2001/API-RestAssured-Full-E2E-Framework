package com.api.base;

public class TransactionCtrlrService extends BaseService{

    private static final String BASE_PATH = "/api/transactions";

    public void deposit(String payload){
        postRequest(payload, BASE_PATH + "/deposit");
    }

    public void history(String payload){
        getRequest(BASE_PATH + "/history");
    }

    public void transfer(String payload){
        postRequest(payload, BASE_PATH + "/transfer");
    }

    public void withdraw(String payload){
        postRequest(payload, BASE_PATH + "/withdraw");
    }
}
