package authentication;


import org.testng.annotations.*;
import facebook.*;
import org.testng.*;
import java.util.*;

public class InvalidCredsCheck extends TestBase{
	
	
	@Test(groups="group1")
	public void testInvalidUserName(){
		

		//ChromeDriver chromeDriver = new ChromeDriver(options);
		
		InvalidCredsPage invalidCredsPage = new InvalidCredsPage();
		
		//Assertion assertion = new Assertion();
		AuthenticationPage authentication = new AuthenticationPage(driver,commonUtils);
		
		commonUtils.launchFacebook("https://wwww.facebook.com");
		
		Assert.assertEquals(authentication.verifyLoginSection("loginPage"),true,"Atleast one or more element is not present!");
		
		authentication.submitCredentials("asdf@cdf.com","bhulgaye");
		authentication.clickLogin();
		
		ArrayList<String> invalidCredsPageElements = new ArrayList<String>();
		invalidCredsPageElements.add("//*[contains(text(),\"The password that you've entered is incorrect. \")]");
		invalidCredsPageElements.add("//*[contains(text(),\"Forgotten password\")]");
		invalidCredsPageElements.add("//*[@title=\"Go to Facebook home\"]");
		invalidCredsPageElements.add("//*[contains(text(),\"Recover Your Account\")]");
		Assert.assertEquals(invalidCredsPage.verifyInvalidCredsPage(invalidCredsPageElements),true,"Atleast one or more element is not present!");
		
		
	}
	
	@Test(groups="group2")
	public void testInvalidPassword(){
				
		InvalidCredsPage invalidCredsPage = new InvalidCredsPage();
		
		AuthenticationPage authentication = new AuthenticationPage(driver,commonUtils);
		commonUtils.launchFacebook("https://wwww.facebook.com");

		Assert.assertEquals(authentication.verifyLoginSection("loginPage"),true,"Atleast one or more element is not present!");
		
		authentication.submitCredentials("mr.sachin2390@gmail.com","ksdfkl");
		authentication.clickLogin();
		
		ArrayList<String> invalidCredsPageElements = new ArrayList<String>();
		invalidCredsPageElements.add("//*[contains(text(),\"The password that you've entered is incorrect. \")]");
		invalidCredsPageElements.add("//*[contains(text(),\"Forgotten password\")]");
		invalidCredsPageElements.add("//*[@title=\"Go to Facebook home\"]");
		invalidCredsPageElements.add("//*[contains(text(),\"Recover Your Account\")]");
		Assert.assertEquals(invalidCredsPage.verifyInvalidCredsPage(invalidCredsPageElements),true,"Atleast one or more element is not present!");
		
		
	}
	
	
}