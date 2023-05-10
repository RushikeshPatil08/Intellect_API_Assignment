package com.intellect.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.intellect.action.*;
import com.intellect.library.TestBase;


import io.restassured.response.Response;

public class TestGetUsers extends TestBase{
	@BeforeClass
	public void initialize() throws IOException {
		init();
	}
	
	@Test
	public void testGetUsers()
	{	
		GetUser user = new GetUser();
		Response response = user.sendGetUserRequest();
		response.prettyPrint();
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertTrue(response.getBody().asString() != null);
	}
	
}
