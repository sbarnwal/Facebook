package facebook;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;
import java.util.*;

public class AuthenticationPage{
	

	
	public AuthenticationPage(ChromeDriver driver, CommonUtils commonUtils){
		this.chromeDriver = driver;
		this.commonUtils = commonUtils;
	}
	public AuthenticationPage() {
		
	}
	ChromeDriver chromeDriver;
	CommonUtils commonUtils;
	

	
	//submit credentials
	public void submitCredentials(String userName,String password){
		System.out.println("Entering UserName");
		WebElement uName = chromeDriver.findElementById("email");
		uName.sendKeys(userName);
		System.out.println("Entering password");
		WebElement pWord = chromeDriver.findElementById("pass");
		pWord.sendKeys(password);
	}
	
	//click on login
	public void clickLogin(){	
		System.out.println("Click on login");
		WebElement login = chromeDriver.findElementById("loginbutton");
		login.click();		
	}

		
		public boolean verifyLoginSection(String key){
			
			boolean allElementsFound = true;
			System.out.println("get xPath from property file");
			ArrayList<Boolean> elementsFound = commonUtils.isElementsFound("loginPage");
			
			System.out.println("Find elements for the respective xpath");
			for(boolean elementFound : elementsFound){
				
				if(!elementFound)allElementsFound = false;
			}
			return allElementsFound;
			
		}
		
	
	
}