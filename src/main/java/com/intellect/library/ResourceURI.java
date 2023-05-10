package com.intellect.library;

public enum ResourceURI {
	
	GET_USERS("users"),
	GET_ADDRESS("addresses"),
	GET_BANKS("banks"),
	GET_APPLIANCES("appliances"),
	GET_BEERS("beers"),
	GET_BLOOD_TYPES("blood_types"),
	GET_CREDIT_CARDS("credit_cards");
	

	String uri;

	ResourceURI(String uri) {
		this.uri = uri;
	}

	public String getUri() {
		return this.uri;
	}

}
