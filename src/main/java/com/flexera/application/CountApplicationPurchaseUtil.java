package com.flexera.application;

public class CountApplicationPurchaseUtil {

	protected static final String FILE_PATH = ".\\src\\main\\resources\\";
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String csvFile = "sample-small.csv";
		ApplicationPurchaseFactory applicationPurchaseFactory = new ApplicationPurchaseFactory();
		int appCopiesNum = applicationPurchaseFactory.countApplicationCopies("374",FILE_PATH + csvFile);
		System.out.println("Total Processing Duration: " + (System.currentTimeMillis() - startTime) / 1000d + "s");
		System.out.println("CSV File : " + csvFile + " Number of Application Purchase: " + appCopiesNum);
//		csvFile = "sample-large.csv";
//		startTime = System.currentTimeMillis();
//		appCopiesNum = applicationPurchaseFactory.countApplicationCopies("374", FILE_PATH + csvFile);
//		System.out.println("Total Duration: " + (System.currentTimeMillis() - startTime) / 1000d + "s");
//		System.out.println("CSV File : " + csvFile + " Number of Application Purchase: " + appCopiesNum);
		
	}
}
