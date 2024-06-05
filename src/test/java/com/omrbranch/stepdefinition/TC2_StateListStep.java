package com.omrbranch.stepdefinition;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.StateList_Output_Pojo;
import com.omrbranch.pojo.address.StateName;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;


public class TC2_StateListStep extends BaseClass {
    Response response;

    @Given("User add Headers for StateList")
    public void user_add_headers_for_state_list() {
        addHeader("accept", "application/json");

    }

    @When("User send {string} request for StateList endPoint")
    public void user_send_request_for_state_list_end_point(String type) {
        response = addRequestType(type, Endpoints.STATE_LIST);
        int statusCode = getResponseCode(response);
        TC1_LoginStep.globalDatas.setStatusCode(statusCode);
    }

    @Then("User should verify the StateList response message matches  {string} and saved the StateId")
    public void user_should_verify_the_state_list_response_message_matches_and_saved_the_state_id(String expStateId) {
        StateList_Output_Pojo stateListOutputPojo = response.as(StateList_Output_Pojo.class);
        ArrayList<StateName> stateNames = stateListOutputPojo.getData();
        for (StateName eachStateName : stateNames) {
            String state = eachStateName.getName();
            if (state.equals("Tamil Nadu")) {
                int stateId = eachStateName.getId();
                System.out.println(stateId);
                String id = String.valueOf(stateId);
                TC1_LoginStep.globalDatas.setStateId(stateId);
                Assert.assertEquals("Verify State Id", expStateId, id);
                break;
            }

        }

    }
}