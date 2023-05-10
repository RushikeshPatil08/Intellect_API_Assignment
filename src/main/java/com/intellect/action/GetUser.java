package com.intellect.action;

import com.intellect.library.TestBase;

import com.intellect.library.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetUser extends TestBase {
	
	public Response sendGetUserRequest()
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Content-Type","application/json");
		Response response = request.get(properties.getProperty("Base_URL")+ResourceURI.GET_USERS.getUri());
		return response;
	}


}
