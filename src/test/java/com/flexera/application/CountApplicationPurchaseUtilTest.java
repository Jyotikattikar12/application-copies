package com.flexera.application;

import static org.junit.Assert.assertSame;

import org.junit.Test;

public class CountApplicationPurchaseUtilTest {
	private static String FILE_PATH = ".//src//test//resources//";
	
	@Test
	public void testMain() {
		ApplicationPurchaseFactory applicationPurchaseFactory = new ApplicationPurchaseFactory();
		int numAppVesrions = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + "sample-1.csv");
		assertSame(1,numAppVesrions );
		
		applicationPurchaseFactory = new ApplicationPurchaseFactory();
		numAppVesrions = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + "sample-2.csv");
		assertSame(3,numAppVesrions );
		
		applicationPurchaseFactory = new ApplicationPurchaseFactory();
		numAppVesrions = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + "sample-3.csv");
		assertSame(2,numAppVesrions );
		
		
		applicationPurchaseFactory = new ApplicationPurchaseFactory();
		numAppVesrions = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + "sample-8.csv");
		assertSame(6,numAppVesrions );
		
		applicationPurchaseFactory = new ApplicationPurchaseFactory();
		numAppVesrions = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + "sample-9.csv");
		assertSame(0,numAppVesrions );
	}

}
