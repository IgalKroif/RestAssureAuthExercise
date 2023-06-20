package com.zerozeroone;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;


public class RestingAssured {
	
		
	}

}

public class RestTest {
	@Test
	public void mySanity() {
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200);
}
