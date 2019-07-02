package authentication;

import org.testng.annotations.*;
import org.testng.asserts.*;

import facebook.*;

import java.util.*;

public class LogoutCheck extends TestBase{

	@Test(groups="group1")
	public void testLogout(){

		String className = this.getClass().getName();
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
		
		  LoggingAssert logAssert = new LoggingAssert(); 
		  AuthenticationPage authentication = new AuthenticationPage(driver,commonUtils); 
		  UserHomePage homePage = new UserHomePage(driver);
		  commonUtils.launchFacebook("https://wwww.facebook.com");
		  authentication.submitCredentials(CommonUtils.decode(envConfigurations.getProperty("username")),CommonUtils.decode(envConfigurations.getProperty("password")));
		  ArrayList<String> xPaths = new ArrayList<String>(); 
		  xPaths.add("//*[@href=\"https://www.facebook.com/\" and @title=\"Go to Facebook home\"]"); 
		  xPaths.add("//*[@for=\"email\"]"); xPaths.add("//*[@for=\"pass\"]");
		  xPaths.add("//*[@id=\"email\"]"); xPaths.add("//*[@id=\"pass\"]");
		  xPaths.add("//*[contains(text(),(\"Forgotten accountss\"))]");
		  xPaths.add("//*[@data-testid=\"royal_login_button\"]");
		  logAssert.assertEquals(authentication.verifyLoginSection("loginPage"),true,"Atleast one or more element is not present!");
		  logAssert.assertEquals(true, false, "logging assert");
		  authentication.clickLogin(); 
		  homePage.navigateToAccountSettings();
		  homePage.clickLogout();
		  logAssert.assertEquals(authentication.verifyLoginSection("loginPage"),true,"Atleast one or more element is not present!");
		 
		
	}
	

}