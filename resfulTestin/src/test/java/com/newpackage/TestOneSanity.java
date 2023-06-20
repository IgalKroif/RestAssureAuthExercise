package com.newpackage;


import org.testng.annotations.Test;
import com.newpackage.*;
import com.resfulTestin.SanityChecker;

public class TestOneSanity {
	SanityChecker mySanity = new SanityChecker();
	@Test
	public void sanity() {
		
		mySanity.sanityTester("https://www.google.com");
		
	}
}
