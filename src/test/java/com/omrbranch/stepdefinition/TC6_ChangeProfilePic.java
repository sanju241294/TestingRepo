package com.omrbranch.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.And;
import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.pojo.changeprofile.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class TC6_ChangeProfilePic extends BaseClass {
Response response;

	@Given("User add Headers to get change profile picture")
	public void user_add_headers_to_get_change_profile_picture() {
		List<Header> headers = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.globalDatas.getLogtoken());
		Header h3 = new Header("Content-Type", "multipart/form-data");
		headers.add(h1);
		headers.add(h2);
		headers.add(h3);
		Headers headers1 = new Headers(headers);
		addHeaders(headers1);
	}
	@When("User add form data to change the profile picture")
	public void user_add_form_data_to_change_the_profile_picture() {

		multipart("profile_picture",new File("C:\\Users\\mani\\Desktop\\OmrApiProject\\logo.jpg"));

	}
	@When("User send {string} request for change profile picture endPoint")
	public void user_send_request_for_change_profile_picture_end_point(String type) {
		response = addRequestType(type, Endpoints.CHANGE_PROFILE);
		int statusCode =response.getStatusCode();
		TC1_LoginStep.globalDatas.setStatusCode(statusCode);

	}

	@And("User should verify the change profile response message matches {string}")
	public void userShouldVerifyTheChangeProfileResponseMessageMatches(String expMessage) {
		ChangeProfilePic_Output_Pojo changeProfilePicOutputPojo=response.as(ChangeProfilePic_Output_Pojo.class);
		String message=changeProfilePicOutputPojo.getMessage();
		Assert.assertEquals("verify message",expMessage, message);

	}



}
