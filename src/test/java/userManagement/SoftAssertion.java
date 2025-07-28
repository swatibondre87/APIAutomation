package userManagement;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.SoftAssertionUtilSingleton;

public class SoftAssertion {

	
	@Test
	public void softAssertion(){
		//SoftAssert softAssertion= new SoftAssert();
		System.out.println("softAssert");
		SoftAssertionUtilSingleton.assertTrue(false, "");
		System.out.println("softAssert1");
		SoftAssertionUtilSingleton.assertTrue(true, "");
		System.out.println("softAssert2");
		SoftAssertionUtilSingleton.assertTrue(false, "");
		System.out.println("softAssert3");
		
		SoftAssertionUtilSingleton.assertAll(); 

	}

}
