package facebook;

import java.util.*;



public class InvalidCredsPage extends TestBase{

	public boolean verifyInvalidCredsPage(ArrayList<String> xPaths){
		
		boolean allElementsFound = true;
		ArrayList<Boolean> elementsFound = commonUtils.isElementsFound(xPaths);
		int i = 0;
		for(boolean elementFound : elementsFound){
			
			if(!elementFound){
				System.out.println("Web Element with xPath "+xPaths.get(i)+"is not found!");
				allElementsFound = false;
			}
			i++;
		}
		return allElementsFound;
		
	
	}


}