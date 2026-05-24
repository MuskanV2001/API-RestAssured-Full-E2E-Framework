package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingFilter implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx){

        logRequest(requestSpec); // Interception of Request

        Response response  =  ctx.next(requestSpec,responseSpec); //To continue after interception

        logResponse(response); // Interception of Response

        return response; // Returned to the test for assertion
    }

    public void logRequest(FilterableRequestSpecification requestSpec){
        logger.info("BASE URI: " + requestSpec.getBaseUri());
        logger.info("HTTP METHOD: " + requestSpec.getMethod());
        logger.info("REQUEST HEADER: " + requestSpec.getHeaders());
        logger.info("CONTENT TYPE: " + requestSpec.getContentType());
        logger.info("PAYLOAD: " + requestSpec.getBody());
    }

    public void logResponse(Response response){
        logger.info("RESPONSE STATUS: " + response.getStatusCode());
        logger.info("RESPONSE HEADERS: " + response.getHeaders());
        logger.info("RESPONSE BODY: " + response.getBody().asString());
    }
}
