package com.omrbranch.runner;

import com.omrbranch.baseclass.BaseClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions( tags="@Login or @StateList or @CityList or @Address or @Search or @ChangeProfile",dryRun = false, glue = "com.omrbranch.stepdefinition",features = "C:\\Users\\mani\\Desktop\\OmrApiProject\\src\\test\\resources\\Features",plugin= {"json:target\\index.json"})
public class TestRunnerClass extends BaseClass {

	
    @AfterClass
    public static void afterClass() throws IOException {
        Reporting.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
//        Reporting.generateJVMReport("C:\\Users\\mani\\Desktop\\OmrApiProject\\target\\index.json");

    }
}
