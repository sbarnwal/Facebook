package facebook;

import org.openqa.selenium.*;
import org.openqa.selenium.By.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;


public class CommonUtils extends TestBase{

	//ChromeDriver chromeDriver;

	public CommonUtils(){
		
	}
	
	public boolean isElementFound(String xpath){
		System.out.println("Finding element with xpath :"+ xpath );
		try{
			driver.findElementByXPath(xpath);
			
			System.out.println("Element : "+xpath+" found");
			return true;
		}catch(InvalidSelectorException e){
			System.out.println("Element : "+xpath+" not found");
			return false;
		}catch(NullPointerException npe){
			System.out.println("Element : "+xpath+" not found");
			return false;
		}catch(NoSuchElementException nsee) {
			System.out.println("Element : "+xpath+" not found");
			return false;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}

		
	}
	
	public ArrayList<Boolean> isElementsFound(ArrayList<String> xPaths){
		ArrayList<Boolean> elementsFound = new ArrayList<Boolean>();
		System.out.println("Finding elements for xpaths");
		for(String xPath : xPaths){
			elementsFound.add(isElementFound(xPath));
		}
		return elementsFound;
	}
	
	public ArrayList<Boolean> isElementsFound(String key){
		
		ArrayList<String> xpaths = getPageElementsxPath(key);
		ArrayList<Boolean> elementsFound = new ArrayList<Boolean>();
		System.out.println("Finding elements for xpaths");
		for(String xpath : xpaths){
			elementsFound.add(isElementFound(xpath));
		}
		return elementsFound;
		
		
	}
	
	private ArrayList<String> getPageElementsxPath(String key) {
		
		ArrayList<String> xPathsWithKey = new ArrayList<String>();
		String xpathKey;
		
		Set<String> xPathsKeys = xPathProperties.stringPropertyNames();
		Iterator<String> xPathsIterator = xPathsKeys.iterator();
		System.out.println("Finding property matching key : "+key);
		while(xPathsIterator.hasNext()) {
			
			xpathKey = xPathsIterator.next();
			
			if(xpathKey.contains(key)) {
				System.out.println("match found : "+xpathKey);
				xPathsWithKey.add(xPathProperties.getProperty(xpathKey));
			}
		}
		return xPathsWithKey;
		
	}
	
	//launch Chrome and navigate to Facebook
	public void launchFacebook(String URL){	
		//chromeDriver = new ChromeDriver();
		System.out.println("Launching facebook page");
		driver.get(URL);
	}
	
	public List<WebElement> getListOfElements(ByXPath xpath, String property) {
		
		List<WebElement> list =  driver.findElements(xpath);
		System.out.println(list.size());
		printPropertyOfListOfElement(list,property);
		return list;
		 
	}
	public void printPropertyOfListOfElement(List<WebElement> elementList,String property ) {
		
		String attribute;
		System.out.println("********************************Following element were found with Attribute "+property+"****************************************");
		for(WebElement element : elementList) {
			attribute = element.getAttribute(property);
			System.out.println(attribute);
		}
		System.out.println("************************************************************************");
		
		
	}
	
	public void takeWindowScreenshot() throws IOException {
			
		System.out.println("Taking screenshot of the window");
		  byte[] screenshotInBytes = driver.getScreenshotAs(OutputType.BYTES);
		  File screenshotFile = new File("C:\\Users\\BarnwalS\\Desktop\\Java Learnings\\Workspace\\Git Repositories\\FacebookAutomation\\Facebook\\test-output\\Screenshots\\windowScreenshot.png");
		  FileOutputStream fos = new FileOutputStream(screenshotFile);
		  fos.write(screenshotInBytes);
		  fos.close();
		
	}
	public void takeElementScreenshot(WebElement element)throws IOException, InterruptedException{
		System.out.println("Taking screenshot of the webelement");
//		  byte[] screenshotInBytes = element.getScreenshotAs(OutputType.BYTES);
//		  File screenshotFile = new File("C:\\Users\\BarnwalS\\Desktop\\Java Learnings\\Workspace\\Git Repositories\\FacebookAutomation\\Facebook\\test-output\\Screenshots\\elementScreenshot.png");
//		  FileOutputStream fos = new FileOutputStream(screenshotFile);
//		  fos.write(screenshotInBytes);
//		  fos.close();
		int elementHeightInPoints = (int) ((element.getSize().getHeight())*1.5);
		int elementWidthInPonts = (int) ((element.getSize().getWidth())*1.5);
		System.out.println("Element width and heigh respectively : "+elementWidthInPonts+" , "+elementHeightInPoints);
		Point point = element.getLocation();
		
		File windowScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		BufferedImage windowBufferedImg = ImageIO.read(windowScreenshot);
		BufferedImage elementBufferedImg = windowBufferedImg.getSubimage((int)(point.getX()*1.5), (int)(point.getY()*1.5), elementWidthInPonts, elementHeightInPoints);
		System.out.println("Tile height : "+elementBufferedImg.getTileHeight() +", Tile width : "+elementBufferedImg.getTileWidth());
		File elementScreenshot = new File("C:\\Users\\BarnwalS\\Desktop\\Java Learnings\\Workspace\\Git Repositories\\FacebookAutomation\\Facebook\\test-output\\Screenshots\\elementScreenshot.png");
		System.out.println("Creating new file : "+elementScreenshot.createNewFile());
		System.out.println("Screenshote Taken : " + ImageIO.write(elementBufferedImg, "png", elementScreenshot));
		
	}
	
	public static String decode(String parameter) {
		
		byte[] b = Base64.getDecoder().decode(parameter);
		return (new String(b));
		
	}


}