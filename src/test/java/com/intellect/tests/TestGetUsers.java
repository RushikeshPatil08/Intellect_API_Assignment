package com.intellect.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.intellect.action.*;
import com.intellect.library.TestBase;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class TestGetUsers extends TestBase {
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}

	@Test
	public void testGetUsers() {
		GetUser user = new GetUser();
		Response response = user.sendGetUserRequest();

		response.prettyPrint();

		SoftAssert softAssert=new SoftAssert();
		
		// Validating the Status code
		softAssert.assertEquals(200, response.getStatusCode());

		// Validating that response body should not null
		softAssert.assertTrue(response.getBody().asString() != null);

		// Validating the username should not null
		softAssert.assertTrue(response.jsonPath().get("username").toString() != null);

		// Validating the Country should be United States
		softAssert.assertEquals(response.jsonPath().get("address.country"), "United States");

		// Validating that title should not null
		softAssert.assertTrue(response.jsonPath().get("employment.title").toString() != null);

		// Validating the Json Schema
		response.then().assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./JsonSchema/GetUserJsonSchema.json")));
		
		softAssert.assertAll();
	}

}
