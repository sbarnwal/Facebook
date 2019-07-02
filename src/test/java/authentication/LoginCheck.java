package authentication;

import org.testng.annotations.*;
import facebook.AuthenticationPage;
import facebook.CommonUtils;
import facebook.TestBase;
import org.testng.asserts.*;
import java.io.*;
import java.lang.invoke.MethodHandles;

public class LoginCheck extends TestBase{
	
	@Test(groups="group3")
	public void testLogin() throws IOException{
		
		String className = this.getClass().getName();
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
		
		System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
	
		//Properties prop = new Properties();
		//prop.load(new FileInputStream("./xPathRepository.properties"));
		//ChromeDriver chromeDriver = new ChromeDriver();
		
		
		
		Assertion assertion = new Assertion();
		AuthenticationPage authentication = new AuthenticationPage(driver,commonUtils);
		

		commonUtils.launchFacebook("https://wwww.facebook.com");
		authentication.submitCredentials(CommonUtils.decode(envConfigurations.getProperty("username")),CommonUtils.decode(envConfigurations.getProperty("password")));

		assertion.assertEquals(authentication.verifyLoginSection("loginPage"),true,"Atleast one or more element is not present!");
		authentication.clickLogin();
		
		
	}
	
	
}