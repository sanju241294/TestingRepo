package com.omrbranch.stepdefinition;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class CommonStep {
    @Then("User verify the status code is {int}")
    public void user_verify_the_status_code_is(int expStatusCode) {
        int statusCode = TC1_LoginStep.globalDatas.getStatusCode();
        Assert.assertEquals("Verify Message",expStatusCode,statusCode);
    }
}

