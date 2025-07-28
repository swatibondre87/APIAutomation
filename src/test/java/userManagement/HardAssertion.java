package userManagement;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertion {
	@Test
	public void hardAssertion(){
		System.out.println("hardAssert");
		Assert.assertTrue(false);
		System.out.println("hardAssert");
	}

}
