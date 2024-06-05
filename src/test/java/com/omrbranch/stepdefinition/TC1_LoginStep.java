package com.omrbranch.stepdefinition;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.globalDats.GlobalDatas;
import com.omrbranch.pojo.login.Login_Output_Pojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

public class TC1_LoginStep extends BaseClass {
Response response;
    static GlobalDatas globalDatas = new GlobalDatas();

    @Given("User add Header")
    public void userAddHeader() {
        addHeader("accept", "application/json");
    }

    @When("User add basic authentication for login")
    public void userAddBasicAuthenticationForLogin() throws IOException {
        addBasicAuth(getPropertyFileValue("userName"),getPropertyFileValue("passWord"));

    }

    @And("User send {string} request for login endPoint")
    public void userSendRequestForLoginEndPoint(String type) throws IOException {
        response =addRequestType(type, Endpoints.LOGIN);
        int statusCode = getResponseCode(response);
        globalDatas.setStatusCode(statusCode);
    }

    @And("User should verify the login response body firstName As {string} and get the login token saved")
    public void userShouldVerifyTheLoginResponseBodyFirstNameAsAndGetTheLoginTokenSaved(String expFirstName) {
        Login_Output_Pojo login_output_pojo = response.as(Login_Output_Pojo.class);
        String firstName = login_output_pojo.getData().getFirst_name();
        System.out.println(firstName);
        Assert.assertEquals("Verify message",expFirstName, firstName);
        String logToken = login_output_pojo.getData().getLogtoken();
        globalDatas.setLogtoken(logToken);

    }
}
