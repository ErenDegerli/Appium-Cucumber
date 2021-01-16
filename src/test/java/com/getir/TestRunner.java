package com.getir;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        glue = {"com/getir/steps"})
public class TestRunner {

}
