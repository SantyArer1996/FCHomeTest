package com.fc.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class fcstepdefination {
	
	@Given("User has the todo tasks")
	public void user_has_the_todo_tasks() {
	    System.out.println("Hello1");
	}
	@Given("User belongs to the city FanCode")
	public void user_belongs_to_the_city_fan_code() {
		System.out.println("Hello2");
	}
	@Then("User Completed task percentage should be greater than {int}%")
	public void user_completed_task_percentage_should_be_greater_than(Integer int1) {
		System.out.println("Hello3");
	}
}