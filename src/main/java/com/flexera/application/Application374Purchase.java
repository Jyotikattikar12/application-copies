package com.flexera.application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * SubClass to process rows with Application ID 374. 
 * 
 * @author jyoti.bandi
 *
 */
public class Application374Purchase extends ApplicationPurchase{
	
	private static final String APPLICATION_ID = "374";
	
	public Application374Purchase(String applicationId, String csvFile) {
		super(applicationId, csvFile);
	}


	public int checkNumPuchases(String[] computerDetails, Map<String, Map<String, String>> userCompApp, int copiesNum){
		// If the row's ApplicationID  matches with the configured value
		if( computerDetails[2].equals(APPLICATION_ID)) {
			
			// If there is no key with UserID then create the map entry and increase the application copies numbers
			if( !userCompApp.containsKey(computerDetails[1])) {				
				Map<String, String> compApp = new HashMap<>();
				compApp.put(computerDetails[0], computerDetails[3]);
				userCompApp.put(computerDetails[1],compApp);
				copiesNum++ ;
			} else {
				// UserID exists, Check if computerId exists, if exists Ignore 
				Map<String, String> compApp = userCompApp.get(computerDetails[1]);
				
				if( !compApp.containsKey(computerDetails[0])) {
					
					Set<String> computerId = compApp.keySet();
					Iterator<String> iterator = computerId.iterator();	
					// Check if Computer Type exists, if so increase the copies number
					while(iterator.hasNext()) {
						String computerType = compApp.get(iterator.next());
						if(computerType.equalsIgnoreCase(computerDetails[3])) {
							copiesNum++ ;
						}
					}
					// As new ComputerId, make the CompId and Computer Type entry
					compApp.put(computerDetails[0], computerDetails[3]);
				}				
			}
		}		
		return copiesNum;
	}
}
