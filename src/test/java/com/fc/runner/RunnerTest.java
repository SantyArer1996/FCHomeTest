package com.fc.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/com/fc/Features"},
		glue= {"com.fc.stepdefinations"},
		plugin= {"pretty"},
		tags="@FCAPITest",
		monochrome=true,
		dryRun=false
)
public class RunnerTest{
	
}
