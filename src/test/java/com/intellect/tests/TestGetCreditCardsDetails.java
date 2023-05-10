package com.intellect.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.intellect.action.GetAddress;
import com.intellect.action.GetCreditCardsDetails;
import com.intellect.library.TestBase;

import io.restassured.response.Response;

public class TestGetCreditCardsDetails extends TestBase {
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetCreditCardsDetails()
	{	
		GetCreditCardsDetails creditCards = new GetCreditCardsDetails();
		Response response = creditCards.sendGetCreditCardsDetailsRequest();
		response.prettyPrint();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.getBody().asString() != null);
		
		
//		+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	}

}
