package com.resfulTestin;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.hamcrest.Matchers;

public class SanityTest {
	SanityChecker mySanity = new SanityChecker();
	
	@Test
	public void sanity() {
		mySanity.sanityTester("https://www.google.com");
		
	}
	@Test
    public void testGetPost() {
        RestAssured.given()
                .get("https://jsonplaceholder.typicode.com/posts/1")
                .then()
                .statusCode(Matchers.is(200))
                .body("userId", Matchers.is(1))
                .body("id", Matchers.is(1))
                .body("title", Matchers.is("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body", Matchers.startsWith("quia et suscipit"))
                .log().all();
    }
	
	@Test
    public void testResponseHeaders() {
        RestAssured.given()
        .contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .header("Accept", ContentType.JSON.withCharset("UTF-8"))
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .statusCode(Matchers.not(400))
                .log().status()
                .log().body()
                .body("id", Matchers.hasItem(Matchers.anyOf(Matchers.is(84), Matchers.is(85))));
           
        
    }
	
	@Test
    public void testAssertIdAtIndex() {
        RestAssured.given()
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .body("id[3]", Matchers.equalTo(4));
    }
	@Test
	public void testList() {
		List<String> emailList = RestAssured.get("https://jsonplaceholder.typicode.com/users")
		        .then()
		        .statusCode(200)
		        .extract()
		        .jsonPath()
		        .getList("email");

		System.out.println("Emails: " + emailList);
		
	}
	
}
