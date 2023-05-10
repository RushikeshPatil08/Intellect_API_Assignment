package com.intellect.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.intellect.action.GetAddress;
import com.intellect.action.GetUser;
import com.intellect.library.TestBase;

import io.restassured.response.Response;

public class TestGetAddress extends TestBase{
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetAddress()
	{	
		GetAddress address = new GetAddress();
		Response response = address.sendGetAddressRequest();
		response.prettyPrint();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.getBody().asString() != null);
	}

}
