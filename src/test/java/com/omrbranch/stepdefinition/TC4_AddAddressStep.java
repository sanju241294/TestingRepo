package com.omrbranch.stepdefinition;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.address.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TC4_AddAddressStep extends BaseClass {

	Response response;

	@Given("User and header and bearer authorization for accessing address endpoint")
	public void user_and_header_and_bearer_authorization_for_accessing_address_endpoint() {
        List<Header> headers = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		headers.add(h1);
		headers.add(h2);
		headers.add(h3);
		Headers headers1 = new Headers(headers);
		addHeaders(headers1);
	}
	@When("User and request body for add new address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string}")
	public void user_and_request_body_for_add_new_address(String firstName, String lastName, String mobile, String apt, String stateId, String cityId, String country, String zipcode, String address, String addressType) {
		Address_Input_pojo addAddress = new Address_Input_pojo(firstName,lastName,mobile,apt,TC1_LoginStep.globalDatas.getStateId(),TC1_LoginStep.globalDatas.getCityId(),Integer.parseInt(country),zipcode,address,addressType);
		addBody(addAddress);
	}
	@When("User send {string} request the addUserAddress endpoint")
	public void user_send_request_the_add_user_address_endpoint(String type) {
		 response = addRequestType(type, Endpoints.ADD_ADDRESS);
		int statusCode = getResponseCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User should verify the addUserAddress response message matches {string}")
	public void user_should_verify_the_add_user_address_response_message_matches(String expMessage) {
		Address_Output_pojo addressOutputPojo = response.as(Address_Output_pojo.class);
		String message =addressOutputPojo.getMessage();
		org.junit.Assert.assertEquals("Verify Message", expMessage, message);
		int addId= addressOutputPojo.getAddress_id();
		System.out.println(addId);
		String addressId = String.valueOf(addId);
		TC1_LoginStep.globalDatas.setAddrId(addressId);
	}


	@Given("User add header and bearer authorization for accessing to update address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingToUpdateAddressEndpoints() {
		List<Header> headers = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		headers.add(h1);
		headers.add(h2);
		headers.add(h3);
		Headers headers1 = new Headers(headers);
		addHeaders(headers1);
	}
	@When("User add request body to update new address {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string},{string}")
	public void user_add_request_body_to_update_new_address(String firstName, String lastName, String mobile, String apt, String stateId, String cityId, String country, String zipcode, String address, String addressType) {
		UpdateAddress_Input_Pojo updateAddressInputPojo = new UpdateAddress_Input_Pojo(TC1_LoginStep.globalDatas.getAddrId(),firstName,lastName,mobile,apt,TC1_LoginStep.globalDatas.getStateId(),TC1_LoginStep.globalDatas.getCityId(),Integer.parseInt(country),zipcode,address,addressType);
		addBody(updateAddressInputPojo);
	}
	@When("User send {string} request and update the addUserAddress endpoint")
	public void user_send_request_and_update_the_add_user_address_endpoint(String type) {
		 response = addRequestType(type, Endpoints.UPDATE_ADDRESS);
		int statusCode = getResponseCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User should verify the updateAddress response message matches {string}")
	public void user_should_verify_the_update_address_response_message_matches(String expMessage) {
		UpdateAddress_Output_Pojo updateAddressOutputPojo = response.as(UpdateAddress_Output_Pojo.class);
		String message =updateAddressOutputPojo.getMessage();
		Assert.assertEquals("Verify Message", expMessage, message);
	}



	@Given("User add header and bearer authorization for accessing Get User address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingGetUserAddressEndpoints() {
		List<Header> headers = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		headers.add(h1);
		headers.add(h2);
		Headers headers1 = new Headers(headers);
		addHeaders(headers1);
	}
	@When("User send {string} request for GetUserAddress endpoint")
	public void user_send_request_for_get_user_address_endpoint(String type) {
		response =addRequestType(type,Endpoints.GET_ADDRESS);
		int statusCode = response.getStatusCode();
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the GetUserAddress response message matches {string}")
	public void user_verify_the_get_user_address_response_message_matches(String expMessage) {
		GetAddress_Output_Pojo getAddressResponse = response.as(GetAddress_Output_Pojo.class);
		String message = getAddressResponse.getMessage();
		org.junit.Assert.assertEquals("Verify Message", expMessage, message);
	}


	@Given("User add header and bearer authorization for accessing to delete address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingToDeleteAddressEndpoints() {
		List<Header> headers = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "application/json");
		headers.add(h1);
		headers.add(h2);
		headers.add(h3);
		Headers headers1 = new Headers(headers);
		addHeaders(headers1);
	}
	@When("User add request body for address id")
	public void user_add_request_body_for_address_id() {
		Delete_Input_Pojo delete_input_pojo = new Delete_Input_Pojo(TC1_LoginStep.globalDatas.getAddrId());
		addBody(delete_input_pojo);
	}
	@When("User send {string} request for DeleteAddress endpoint")
	public void user_send_request_for_delete_address_endpoint(String type) {
		Response response = addRequestType(type, Endpoints.DELETE_ADDRESS);
		int statusCode = getResponseCode(response);
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);
	}

	@Then("User verify the DeleteAddress response message matches {string}")
	public void user_verify_the_delete_address_response_message_matches(String expMessage) {
		Delete_Output_Pojo deleteOutputPojo = response.as(Delete_Output_Pojo.class);
		String message =deleteOutputPojo.getMessage();
		Assert.assertEquals("Verify Message", expMessage, message);
	}




}





