package com.omrbranch.baseclass;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    RequestSpecification requestSpecification;
    Response response;

    public void SetHeader(String reqType, String endPoint) {

        requestSpecification =RestAssured.given().header(reqType, endPoint);

    }

    public Response addRequestType(String reqType, String endPoint) {

        switch (reqType) {
            case "GET":
                response = requestSpecification.when().get(endPoint);
                break;

            case "POST":
                response = requestSpecification.when().post(endPoint);
                break;

            case "PUT":
                response = requestSpecification.when().put(endPoint);
                break;

            case "PATCH":
                response = requestSpecification.when().patch(endPoint);
                break;

            case "DELETE":
                response = requestSpecification.when().delete(endPoint);
                break;

            default:
                break;
        }

        return response;
    }

    public int getResponseCode(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode;
    }

    public String getResponseBodyAsString() {
        String asBody = response.getBody().asString();
        return asBody;
    }

    public void addHeader(String key, String value) {
        requestSpecification= RestAssured.given().header(key,value);

    }

    public void addHeaders(Headers headers) {
        requestSpecification = RestAssured.given().headers(headers);

    }
    public void multipart(String name, File file){

        requestSpecification = requestSpecification.multiPart(name, file);

    }

    public void addBody(String body) {
        requestSpecification = requestSpecification.body(body);

    }
    public void addBody(Object body) {
        requestSpecification = requestSpecification.body(body);

    }

    public String getResponseBodyPrettyString() {
        String asPrettyString = response.getBody().asPrettyString();
        return asPrettyString;
    }

	
    public void addBasicAuth(String userName, String passWord) {
        requestSpecification = requestSpecification.auth().preemptive().basic(userName, passWord);

    }

    public static String getProjectPath() {

    	return System.getProperty("user.dir");
    			
    			
	}
    
    public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {


    	Properties properties =new Properties();
        FileInputStream fileInputStream =new FileInputStream("C:\\Users\\mani\\Desktop\\OmrApiProject\\Config\\config.properties");
        properties.load(fileInputStream);
       String value = (String)properties.get(key);

        return value;


    	
    	
    	
    	
	}
    
    
    
    
    
    
    
    
    
    
    
    
}
