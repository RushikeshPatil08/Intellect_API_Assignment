package com.intellect.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.intellect.action.GetAddress;
import com.intellect.action.GetCreditCardsDetails;
import com.intellect.library.TestBase;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class TestGetCreditCardsDetails extends TestBase {
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}

	@Test
	public void testGetCreditCardsDetails() {
		GetCreditCardsDetails creditCards = new GetCreditCardsDetails();
		Response response = creditCards.sendGetCreditCardsDetailsRequest();
		response.prettyPrint();
		
		SoftAssert softAssert=new SoftAssert();

		// Validating the Status code
		softAssert.assertEquals(200, response.getStatusCode());

		// Validating that response body should not null
		softAssert.assertTrue(response.getBody().asString() != null);

		// Validating the Id should not null
		softAssert.assertTrue(response.jsonPath().get("id").toString() != null);

		// Validating the credit card number should not null
		softAssert.assertTrue(response.jsonPath().get("credit_card_number").toString() != null);

		// Validating the credit card number should not null
		softAssert.assertTrue(response.jsonPath().get("credit_card_expiry_date").toString() != null);

		// Validating the Json Schema
		response.then().assertThat().body(
				JsonSchemaValidator.matchesJsonSchema(new File("./JsonSchema/GetCreditCardsDetailsJsonSchema.json")));

		softAssert.assertAll();
	}

}
