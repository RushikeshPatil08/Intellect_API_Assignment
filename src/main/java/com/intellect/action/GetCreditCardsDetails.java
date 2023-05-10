package com.intellect.action;

import com.intellect.library.ResourceURI;
import com.intellect.library.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCreditCardsDetails extends TestBase{

	
	public Response sendGetCreditCardsDetailsRequest()
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.header("Content-Type","application/json");
		Response response = request.get(properties.getProperty("Base_URL")+ResourceURI.GET_CREDIT_CARDS.getUri());
		return response;
	}
}
