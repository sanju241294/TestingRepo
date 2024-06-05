package com.omrbranch.runner;

import com.omrbranch.baseclass.BaseClass;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reporting extends BaseClass {

    public static void generateJVMReport(String jsonFile) throws IOException {

        File reportDirectory = new File(getProjectPath()+ getPropertyFileValue("jvmPath"));
//        File reportDirectory = new File("C:\\Users\\mani\\Desktop\\OmrApiProject\\target");

        Configuration configuration = new Configuration(reportDirectory,"OmrApiProject");

        configuration.addClassifications("PlatformNAme","Mac");
        configuration.addClassifications("Author","John");
        configuration.addClassifications("environment","QA");
        configuration.addClassifications("sprintNumber","35");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(jsonFile);

        ReportBuilder builder = new ReportBuilder(jsonFiles,configuration);
        builder.generateReports();

    }




}
