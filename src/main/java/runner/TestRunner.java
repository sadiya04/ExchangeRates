
package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/html/",
		"html:target/cucumber-reports"}, 
features = "src/test/resources/features/", 
tags = {" @Regression" }, 
glue = "stepDefinitions",
monochrome = true, 
strict = false)
public class TestRunner {

}
