package com.resfulTestin;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class SanityChecker {
		public String sanityTester(String URL) {
			SanityChecker mySanity = new SanityChecker();
			when().get(URL).then().statusCode(200).log().status().and().log().cookies()
			.assertThat().statusCode(anyOf(equalTo(200), equalTo(201))
					)
			
			;
			
			System.out.println("API TESTED: " + URL + " ");
			return URL;
		}
		
		
}
