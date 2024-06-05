package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.Delete_Input_Pojo;
import io.cucumber.java.en.And;
import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.pojo.search.Search_Input_Pojo;
import com.omrbranch.pojo.search.Search_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TC5_ProductSearch extends BaseClass {
Response response;
    @Given("user add header for product search")
    public void userAddHeaderForProductSearch() {
        List<Header> headers = new ArrayList<>();
        Header h1 = new Header("accept", "application/json");
        Header h2 = new Header("Content-Type", "application/json");
        headers.add(h1);
        headers.add(h2);
        Headers headers1 = new Headers(headers);
        addHeaders(headers1);
    }

    @When("user add request body for product search {string}")
    public void userAddRequestBodyForProductSearch(String text) {
        Search_Input_Pojo searchInputPojo = new Search_Input_Pojo(text);
        addBody(searchInputPojo);
    }

    @And("user send {string} rest for product search endpoint")
    public void userSendRestForProductSearchEndpoint(String type) {
         response = addRequestType(type, Endpoints.PRODUCT_LIST);
        int statusCode =response.getStatusCode();
        TC1_LoginStep.globalDatas.setStatusCode(statusCode);
    }

    @Then("user should verify the product search response message matches {string}")
    public void userShouldVerifyTheProductSearchResponseMessageMatches(String expMessage) {
        Search_Output_Pojo stateListOutputPojo=response.as(Search_Output_Pojo.class);
        String message=stateListOutputPojo.getMessage();
        Assert.assertEquals("Verify Message",expMessage, message);
    }
}
