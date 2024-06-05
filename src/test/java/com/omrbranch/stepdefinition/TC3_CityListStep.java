package com.omrbranch.stepdefinition;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.City;
import com.omrbranch.pojo.address.CityList_Input_pojo;
import com.omrbranch.pojo.address.CityList_Pojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TC3_CityListStep extends BaseClass {

Response response;
    @Given("User add Headers to get CityList")
    public void user_add_headers_to_get_city_list() {
        List<Header> headers = new ArrayList<>();
        Header h1 = new Header("accept", "application/json");
        Header h2 = new Header("Content-Type", "application/json");
        headers.add(h1);
        headers.add(h2);
        Headers headers1 = new Headers(headers);
        addHeaders(headers1);
    }
    @When("User add request body stateId to get cityList")
    public void user_add_request_body_state_id_to_get_city_list() {
        CityList_Input_pojo cityList = new CityList_Input_pojo(String.valueOf(TC1_LoginStep.globalDatas.getStateId()));
        addBody(cityList);
    }
    @When("User send {string} request for CityList endPoint")
    public void user_send_request_for_city_list_end_point(String type) {
        response =addRequestType(type, Endpoints.CITY_LIST);
        int statusCode = getResponseCode(response);
        TC1_LoginStep.globalDatas.setStatusCode(statusCode);
    }
    @Then("User should verify the CityList response message matches  {string} and saved the CityId")
    public void user_should_verify_the_city_list_response_message_matches_and_saved_the_city_id(String expCityId) {
        CityList_Pojo cityListPojo = response.as(CityList_Pojo.class);
        ArrayList<City> cityNames = cityListPojo.getData();

        for (City eachCityName : cityNames) {
            String state = eachCityName.getName();
            if (state.equals("Adyar")) {
                int cityId = eachCityName.getId();
                System.out.println(cityId);
                String id = String.valueOf(cityId);
                TC1_LoginStep.globalDatas.setCityId(cityId);
                Assert.assertEquals("Verify CityId",expCityId, id);
                break;
            }

        }

    }




}
