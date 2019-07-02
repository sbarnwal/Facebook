package loginPageServices;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import facebook.TestBase;

public class VerifyLoginPageServices extends TestBase{
  @Test
  public void verifySignup() {
	  String className = this.getClass().getName();
	  String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	  System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
		
	  commonUtils.launchFacebook("https://www.facebook.com");
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("document.querySelector(\"a[href=\\\"/r.php\\\"]\").scrollIntoView();");
	  driver.findElement(By.xpath("//a[@href=\"/r.php\"]")).click();
	  commonUtils.isElementsFound("signupPage");
	  
  }
  
  @Test
  public void verifyMessengerOption() {
	  String className = this.getClass().getName();
	  String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	  System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
	  
	  commonUtils.launchFacebook("https://www.facebook.com");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("document.querySelector(\"a[href=\\\"https://messenger.com/\\\"]\").scrollIntoView();");
	  driver.findElement(By.xpath("//a[@href=\"https://messenger.com/\"]")).click();
	  commonUtils.isElementsFound("messengerPage");	  
	  
  }
  
  @Test
  public void verifyFacebookLiteOption() {
	  String className = this.getClass().getName();
	  String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	  System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
	  
	  commonUtils.launchFacebook("https://www.facebook.com");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("document.querySelector(\"a[href=\\\"/lite/\\\"]\").scrollIntoView();");
	  driver.findElement(By.xpath("//a[@href=\"/lite/\"]")).click();
	  commonUtils.isElementsFound("facebookLitePage");		  
	  
  }
  @Test
  public void verifyWatchOption() throws IOException, InterruptedException{
	  String className = this.getClass().getName();
	  String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	  System.out.println("**************Executing Test : "+className+"."+methodName+"***********");
	  
	  commonUtils.launchFacebook("https://www.facebook.com");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  commonUtils.takeElementScreenshot(driver.findElement(By.xpath("//*[@title=\"Go to Facebook Home\"]/parent::h1/parent::div")));
	  js.executeScript("document.querySelector(\"a[href=\\\"https://www.facebook.com/watch/\\\"]\").scrollIntoView();");  
	  driver.findElement(By.xpath("//a[@href=\"https://www.facebook.com/watch/\"]")).click();
	  

	  
	  commonUtils.getListOfElements((new ByXPath("//span[contains(text(),\"Featured Shows\")]/parent::div/following-sibling::div/table/tbody/tr[1]/td/a")), "href");
	  commonUtils.getListOfElements((new ByXPath("//span[contains(text(),\"Featured Shows\")]/parent::div/following-sibling::div/table/tbody/tr[2]/td/a")), "href");
	  commonUtils.takeWindowScreenshot();
	  
  }
  
}
