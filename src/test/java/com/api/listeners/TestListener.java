package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListener.class);

    public void onStart(ITestContext context){
        logger.info("Test Suite Execution Started...");
    }

    public void onFinish(ITestContext context){
        logger.info("## Test Suite Execution Finished😊 ##");
    }

    public void onTestStart(ITestResult result){
        logger.info("TEST CASE STARTED: " + result.getMethod().getMethodName());
        logger.info("DESCRIPTION " + result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result){
        logger.info("TEST CASE PASSED✅ " + result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result){
        logger.error("TEST CASE FAILED❌ " + result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info("DESCRIPTION " + result.getMethod().getDescription());
    }

    public void onTestSkipped(ITestResult result){
        logger.info("Test Case Skipped: " + result.getMethod().getMethodName());
        logger.info("DESCRIPTION " + result.getMethod().getDescription());
    }
}
