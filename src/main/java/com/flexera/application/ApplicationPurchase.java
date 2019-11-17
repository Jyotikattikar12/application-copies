package com.flexera.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Base class for processing the CSV files to analyze the number of application copies purchases required
 * 
 * @author jyoti.bandi
 *
 */
public abstract class ApplicationPurchase {	
	
	protected static final String CSV_SPLIT_BY = ",";	
	protected String applicationId;
	protected String csvFile;
	
	public ApplicationPurchase(String applicationId, String csvFile) {
		this.applicationId = applicationId;
		this.csvFile = csvFile;
	}
	
	/**
	 * Method to count the number of application copies required by processing each row of the csv file.
	 *  
	 * @param csvFile
	 * @return
	 */
	public int countApplicationCopies(String csvFile) {
		
		BufferedReader br = null;
		String line = "";
		int copiesNum = 0;
		
		Map<String, Map<String, String>> userCompApp = new HashMap<>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			br.readLine();			
			
			while ((line = br.readLine()) != null) {
				// use comma as separator
				String[] computerDetails = line.split(CSV_SPLIT_BY);	

				copiesNum = checkNumPuchases (computerDetails, userCompApp, copiesNum);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}   finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		

		return copiesNum;
	}
	
	/**
	 * Method to count the number of each application copies by processing each row of the csv file
	 * 
	 * @param computerDetails - Individual row of the CSV file
	 * @param compAppMap - Collection to hold the processed row data Key as UserId and Value as row data
	 * @param copiesNum -  application version count
	 * @return application version count
	 */
	public abstract int checkNumPuchases (String[] computerDetails, Map<String, Map<String, String>> compAppMap, int copiesNum);}
