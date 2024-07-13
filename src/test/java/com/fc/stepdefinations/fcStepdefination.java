package com.fc.stepdefinations;

import java.io.IOException;
import java.util.ArrayList;

import com.fc.apimethods.fcUsersTodosUpdation;
import com.fc.utils.configFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class fcStepdefination {
	
	configFileReader configFR;
	fcUsersTodosUpdation fcUsersTodosUpdate;
	static Response allTodosTasks;
	static Response allUsers;
	static ArrayList<Long> userIdsOfFanCodeCity;
	
	public fcStepdefination() {
		configFR = new configFileReader();
		fcUsersTodosUpdate = new fcUsersTodosUpdation();
	}
	
	@Given("User has the todo tasks")
	public void user_has_the_todo_tasks() throws IOException {
		String baseURI = configFR.getDataFromConfigFile("baseURI");
	    String todosEP = configFR.getDataFromConfigFile("todosEndpoint");
	    
	    allTodosTasks = fcUsersTodosUpdate.getResponse(baseURI, todosEP);
	}
	@Given("User belongs to the city FanCode")
	public void user_belongs_to_the_city_fan_code() throws IOException {
		String baseURI = configFR.getDataFromConfigFile("baseURI");
	    String usersEP = configFR.getDataFromConfigFile("userEndpoint");
	    allUsers = fcUsersTodosUpdate.getResponse(baseURI, usersEP);
	    userIdsOfFanCodeCity = fcUsersTodosUpdate.getUserIdsFromFanCodeCity(allUsers);
		
	}
	@Then("User Completed task percentage should be greater than Fifty%")
	public void user_completed_task_percentage_should_be_greater_than_fifty_percent() {
		fcUsersTodosUpdate.validateTaskCompletionPercentForFancodeCityUsers(allTodosTasks,userIdsOfFanCodeCity);
	}
}