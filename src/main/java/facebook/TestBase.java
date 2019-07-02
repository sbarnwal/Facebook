package facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.*;


public abstract class TestBase {
	
	protected static ChromeDriver driver;
	protected static CommonUtils commonUtils;
	protected static Properties xPathProperties;
	protected static Properties envConfigurations;

  @BeforeSuite
  public void beforeSuite() throws FileNotFoundException, IOException {
	  xPathProperties = new Properties();
	  xPathProperties.load(new FileInputStream("./xPathRepository.properties"));
	  envConfigurations= new Properties();
	  envConfigurations.load(new FileInputStream("./envConfiguration.properties"));
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  
	  driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
	  driver.manage().window().maximize();
	  commonUtils = new CommonUtils(); 
	  
  }
  @BeforeMethod
  public void beforeTestMethod() {  
	  
	  
  }
  
  @AfterMethod
  public void afterTest() {
	  System.out.println("Deleting all cookies");
	  driver.manage().deleteAllCookies();
  }
  
  @AfterSuite
  public void afterSuite() {
	  
	  driver.quit();
	  
  }

}
