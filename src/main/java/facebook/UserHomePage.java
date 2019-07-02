package facebook;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.*;

public class UserHomePage extends TestBase{
	
	ChromeDriver chromeDriver;
	//CommonUtils commonutils = new CommonUtils(chromeDriver);
	public UserHomePage(ChromeDriver driver){		
		this.chromeDriver = driver;		
	}
	
	public boolean navigateToAccountSettings(){
	
		WebElement accountSettings = chromeDriver.findElementById("userNavigationLabel");
		accountSettings.click();
		
		return commonUtils.isElementFound("//*[@id=\"BLUE_BAR_ID_DO_NOT_USE\"]");	
	}
	
	public void handlePermissionAlert(){
		
		Alert permissionAlert = chromeDriver.switchTo().alert();
		System.out.println("Alert displayed is : "+permissionAlert.getText());
		permissionAlert.dismiss();
		
	}
	
	
	public void clickLogout(){	
		WebElement logout = chromeDriver.findElementByXPath("//*[contains(text(),(\"Log Out\"))]");
		logout.click();
		
	}

}
