package com.fc.apimethods;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class fcUsersTodosUpdation {
	
	//Method to get the Response of a GET HTTP API Request.
	public Response getResponse(String bURI, String endpoint) {
		RestAssured.baseURI = bURI;
		RequestSpecification httpReq = RestAssured.given();
		Response resp = httpReq.get(endpoint);
		int statusResp = resp.getStatusCode();
		if(statusResp==200) {
			System.out.println("The request has returned success response.");
		}else {
			System.out.println("The request response failed with status code "+statusResp);
		}
		
		return resp;
	}
	
	//Method to get User IDs of the Users from the Fancode City.
	public ArrayList<Long> getUserIdsFromFanCodeCity(Response resp){
		ArrayList<Long> arrUserIDsInCity = new ArrayList<Long>();
		
		List<Object> userIDs = resp.jsonPath().getList("id");
		List<Object> userLats = resp.jsonPath().getList("address.geo.lat");
		List<Object> userLongs = resp.jsonPath().getList("address.geo.lng");
		
		int userSize = userIDs.size();
		for(int i=0;i<userSize;i++) {
			Long checkID = Long.parseLong(userIDs.get(i).toString());
			
			Double checkLatL = Double.parseDouble(userLats.get(i).toString());
			Double checkLongL = Double.parseDouble(userLongs.get(i).toString());
			
			if(checkLatL>=-40 && checkLatL<=5 && checkLongL>=5 && checkLongL<=100) {
				arrUserIDsInCity.add(checkID);
			}
			
		}
		
		System.out.println("User IDs of Users in Fancode City:"+arrUserIDsInCity);
		return arrUserIDsInCity;
	}
	
	//Method to validate the percentage of completed tasks for the Fancode City Users.
	public void validateTaskCompletionPercentForFancodeCityUsers(Response todoTaskResponse,ArrayList<Long> userIDsOfFCCity) {
		
		List<Object> taskUserIDs = todoTaskResponse.jsonPath().getList("userId");
		List<Object> taskCompleteStatuses = todoTaskResponse.jsonPath().getList("completed");
		
		int tasksSize = taskUserIDs.size();
		boolean allUsersFiftyPercentFlag=true;
		for(int j=0;j<userIDsOfFCCity.size();j++) {
			Long inCityUserID = userIDsOfFCCity.get(j);
			int cntUserTaskCompleted = 0;
			int cntTotalUserTasks = 0;
			for(int i=0;i<tasksSize;i++) {
				Long taskUserID = Long.parseLong(taskUserIDs.get(i).toString());
				if(taskUserID==inCityUserID) {
					cntTotalUserTasks++;
					boolean completedFlag = Boolean.parseBoolean(taskCompleteStatuses.get(i).toString());
					if(completedFlag) {
						cntUserTaskCompleted++;
					}
				}
			}
			
			int iFPCount=(cntTotalUserTasks*50)/100;
			if(cntUserTaskCompleted<iFPCount) {
				System.out.println("User with userid '"+inCityUserID+"' does not have Completed task percentage greater than 50% with "+cntUserTaskCompleted+"/"+cntTotalUserTasks+" tasks completed");
				allUsersFiftyPercentFlag=false;
				break;
			}else {
				System.out.println("User with userid '"+inCityUserID+"' has Completed task percentage greater than 50% with "+cntUserTaskCompleted+"/"+cntTotalUserTasks+" tasks completed");
			}
			
		}
		
		if(!allUsersFiftyPercentFlag) {
			fail("All the users of City `FanCode` does not have more than half of their todos task completed");
		}else {
			System.out.println("All the users of City `FanCode` have more than half of their todos task completed");
		}
	}
	
}