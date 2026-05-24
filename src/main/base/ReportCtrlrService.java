package com.api.base;

import java.util.HashMap;
import java.util.Map;

public class ReportCtrlrService extends BaseService{

    private static final String BASE_PATH = "/api/reports/statement";

    public void excelReport(String accountNumber , String fromDate, String toDate){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("accountNumber", accountNumber);
        queryParams.put("fromDate", fromDate);
        queryParams.put("toDate", toDate);
        getRequest(BASE_PATH + "/excel", queryParams);
    }

    public void pdfReport(String accountNumber , String fromDate, String toDate){
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("accountNumber", accountNumber);
        queryParams.put("fromDate", fromDate);
        queryParams.put("toDate", toDate);
        getRequest(BASE_PATH + "/pdf", queryParams);
    }
}
