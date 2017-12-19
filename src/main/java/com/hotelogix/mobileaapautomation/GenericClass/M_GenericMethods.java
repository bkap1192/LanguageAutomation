package com.hotelogix.mobileaapautomation.GenericClass;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class M_GenericMethods {

	
	
	
	
	
	public Properties OR;
	public AppiumDriver driver;
	private static M_GenericMethods GM;
	
//	private String P_PropertiesPath="./LanguageAutomation/Admin_PT.properties";
//	private String S_PropertiesPath="D:\\SpanishSmoke\\LanguagesAutomation\\Spanish.properties";
	
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
    public String Roomtype;
	
	

      private M_GenericMethods(){
    	  
      }
      
      public static M_GenericMethods GI(){
    	  if(GM==null){
    		 GM = new M_GenericMethods();
    	  }
    	  return GM;
          }
      
      
      public void setUp() throws MalformedURLException {
    	  // Created object of DesiredCapabilities class.
    		 
    		 
    		// File classpathRoot = new File(System.getProperty("user.dir"));
    		 //File app = new File("D:\\SpanishSmoke\\JavaProject\\Apps\\android-debug.apk");
    		// File app = new File(appDir, "android-debug.apk");

    		 
    		 
    	   DesiredCapabilities capabilities = new DesiredCapabilities();
    	  // Set android deviceName desired capability. Set your device name.//7c0b19ef       288599899904
    	//  capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
    	   capabilities.setCapability("deviceName", "7c0b19ef");

    	  // Set BROWSER_NAME desired capability. It's Android in our case here.
    	  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

    	  // Set android VERSION desired capability. Set your mobile device's OS version.4.4.4
    	  capabilities.setCapability(CapabilityType.VERSION, "4.4.4");

    	  // Set android platformName desired capability. It's Android in our case here.
    	  capabilities.setCapability("platformName", "Android");
    	//  capabilities.setCapability("app", app.getAbsolutePath());
    	  
    	  // Set android appPackage desired capability. It is
    	  // com.android.calculator2 for calculator application.
    	  // Set your application's appPackage if you are using any other app.     com.pocketpms.app
    	  capabilities.setCapability("appPackage", "com.pocketpms.app");
    	  
    	  //capabilities.setCapability("appPackage", "com.miui.calculator");

    	  // Set android appActivity desired capability. It is
    	  // com.android.calculator2.Calculator for calculator application.
    	  // Set your application's appPackage if you are using any other app.   com.pocketpms.app.MainActivity
    	  capabilities.setCapability("appActivity", "com.pocketpms.app.MainActivity");
    	//   capabilities.setCapability("appWaitActivity", "com.pocketpms.app.MainActivity");
    	  
    	  capabilities.setCapability("noReset", true);
    	  
    	  capabilities.setCapability("autoWebview", true);
    	  capabilities.setCapability("autoWebviewTimeout", 4000);

    	  // Created object of RemoteWebDriver will all set capabilities.
    	  // Set appium server address and port number in URL string.
    	  // It will launch calculator app in android device.127.0.0.1
    	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	//  driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
    	   // AndroidDriver=driver;
    	     
    	 }
    
      
      static int min=1;
      static int max=1000;

      public  int randomNumber()
      {
     	 Random rand = new Random();
     	 int randomNum = rand.nextInt((max-min)+1)+min;
     	 return randomNum;
      }
      
    
 
      public Properties fn_loadpro(String property1,String property2) throws Exception{
    	  Properties pro=new Properties();
    	  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+File.separator+property1);
    	  pro.load(fis);
    	  OR=loadOR(property2);
          OR.putAll(pro);
    	  return OR;
      }
      

      
      public void switchToWindowHandle(String titleval) throws Exception {
      	try{
      	  Set<String> setHndlValColls=driver.getWindowHandles();
          Iterator<String>  itHandleColls=setHndlValColls.iterator();
          while(itHandleColls.hasNext()==true){
              String hndlval=itHandleColls.next();
              driver.switchTo().window(hndlval);
              String title=driver.getTitle();
              if(title.contains(titleval)){
                 break;
              }
              }
      	}catch(Exception e){
      		throw e;
      	}
     	}

      
      
      public void getscreenshot(String name) throws Exception {
    	  try{
          File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+name+".jpg"));
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      
//      public void fn_LaunchBrowser(String BrowserType, String url) throws Exception{
//    	  try{
//    		  if(BrowserType.equalsIgnoreCase("FF")){
//    			  driver=new FirefoxDriver();
//    		  }else if(BrowserType.equalsIgnoreCase("CH")){
//    			  System.setProperty("webdriver.chrome.driver","E:\\TSTauto\\chromedriver.exe");
//    			 driver= new ChromeDriver();
//    		  }
//    		  driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
//    		  driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//    		  driver.get(url);
//    		  driver.manage().window().maximize();
//    	  }catch(Exception e){
//    		  throw e;
//    	  }
//          }
      
      private WebElement fn_ValidateWebelement(WebElement we) throws Exception{
    	  try{
    		  if(we.isDisplayed() && we.isEnabled()){
    			  return we;
    		  }
    	  }catch(NoSuchElementException e){
    		  Thread.sleep(2000);
    		  e.getAdditionalInformation();
    		  
    	  }catch(ElementNotVisibleException e){
    		  Thread.sleep(2000);
    		  e.printStackTrace();
    	  }catch(Exception e){
    		  throw e;
    	  }
		  return we;
          }
      
      
      public void fn_Sendkeys(WebElement we, String str) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(we);
    		  wobj.clear();
    		  wobj.sendKeys(str);
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      public void fn_Click(WebElement we) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(we);
    		  wobj.click();
    	  }catch(WebDriverException e){
    		  Thread.sleep(2000);
    		  js_Click(we);
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      public void fn_ActionsSendkeys(WebElement we, String str) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(we);
    		  wobj.clear();
    		  Actions actobj= new Actions(driver);
    		  actobj.sendKeys(wobj, str).build().perform();
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      public void fn_ActionsClick(WebElement we) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(we);
    		  Actions actobj= new Actions(driver);
    		  actobj.click(wobj).build().perform();
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      public void fn_Mouseover(WebElement we) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(we);
    		  Actions actobj = new Actions(driver);
    		  actobj.moveToElement(wobj).build().perform();
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
      public  void js_Sendkey(WebElement element, String id) throws Exception{
    	  try{
    		  WebElement wobj=fn_ValidateWebelement(element);
    		  wobj.clear();
          JavascriptExecutor executor = (JavascriptExecutor)driver;
          executor.executeScript("arguments[0].value='"+id+"';", wobj);
    	  }catch(Exception e){
    		  throw e;
    	  }
      }

  	public void js_Click(WebElement element) throws Exception{
  	  try{
  		 WebElement wobj=fn_ValidateWebelement(element);
  		JavascriptExecutor executor = (JavascriptExecutor)driver;
  		executor.executeScript("arguments[0].click();", wobj);
  	 }catch(Exception e){
		  throw e;
	  }
  	  }
  	
  	public String Js_getText(WebElement element){
  	    return (String) ((JavascriptExecutor) driver).executeScript(
  	        "return jQuery(arguments[0]).text();", element);
  	}

  public Select selectElement(WebElement element, String VisibleText) throws Exception{
     try{
    	 WebElement wobj=fn_ValidateWebelement(element);
		 Select sel = new Select(wobj);
         sel.selectByVisibleText(VisibleText);
         return sel;
        }catch(Exception e){
	      throw e;
        }
        }

	public String fn_GetText(WebElement element) throws Exception{
		try{
			 WebElement wobj=fn_ValidateWebelement(element);
			 return wobj.getText();
		}catch(Exception e){
			throw e;
		}
	    }
	
	public Select SelectByIndex(WebElement ele,int ind) throws Exception{
		 try{
	    	 WebElement wobj=fn_ValidateWebelement(ele);
			 Select sel = new Select(wobj);
	         sel.selectByIndex(ind);
	          Roomtype=sel.getFirstSelectedOption().getText();
	         return sel;
	        }catch(Exception e){
		      throw e;
	         }
	        }
	
	public Properties loadORConfig(String path){
		Properties ORF=null;
		try {
				FileInputStream fis=new FileInputStream(path);
				 ORF=new Properties();
				ORF.load(fis);
				return ORF;
			} catch (Exception e) {
				e.printStackTrace();
			}
		      return ORF;
	        }
	
	public Properties loadOR(String properties){
		try {
			String CP = System.getProperty("user.dir");
			if(OR==null){
				//System.getProperty(P_PropertiesPath);
				FileInputStream fis=new FileInputStream(CP+File.separator+properties);
				OR=new Properties();
				OR.load(fis);
				return OR;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		      return OR;
	        }
	
   
	public WebElement getWebElement(String ORElementName){
		By byObj=getLocator(ORElementName);
		WebElement we=driver.findElement(byObj);
		return we;
	}
	
	public List<WebElement> fn_GetListWebElement(String ORElementName){
		By byObj=getLocator(ORElementName);
		List<WebElement> we=driver.findElements(byObj);
		return we;
	}
	
    public By getLocator(String ORElementName){
		//OR=loadOR();
		String orLocatorInfo=OR.getProperty(ORElementName).trim();
		String locatorValue=orLocatorInfo.split("##")[0];
		String locatorType=orLocatorInfo.split("##")[1];
		By byObj=null;
	   if(locatorType.equalsIgnoreCase("XP")){
		   byObj=By.xpath(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("NM")){
		   byObj=By.name(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("ID")){
		   byObj=By.id(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("CLS")){
		   byObj=By.className(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("CSS")){
		   byObj=By.cssSelector(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("LK")){
		   byObj=By.linkText(locatorValue);
	   }else if(locatorType.equalsIgnoreCase("PLK")){
		   byObj=By.partialLinkText(locatorValue);
	   }
	     return byObj;
	   }
    
    public String randomUniqueString() throws Exception {
    	try{
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
    	Date date = new Date();
    	String uniqueString = format.format(date);
    	return uniqueString;
    	}catch(Exception e){
    		throw e;
    	}
        }
	
    private  int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    
    public  String generateRandomString(){
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
	
    
    public  String value;
    public  String ActionOnAlert(String Action){
    	  try{

    		   WebDriverWait wait = new WebDriverWait(driver,30);
    		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

    		   value=alert.getText();
    		   if(Action.equalsIgnoreCase("Accept")){
    		   alert.accept();
    		   }
    		   else if(Action.equalsIgnoreCase("Dismiss")){
    		   alert.dismiss();
    		   }
    		   else if(Action.equalsIgnoreCase("")){
    		   }
    		}catch(Throwable e){
    		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
    		}

    	  return value;
    	  }



	public  String GetCurrentWindowID(){
	    String Currenthandle4 = driver.getWindowHandle();
	        System.out.println("parent window id:"+Currenthandle4);
	        return Currenthandle4;
	}

	public   void  windowHandle(String ParentID) throws InterruptedException{
	       Set<String> handles4= driver.getWindowHandles();
	         handles4.remove(ParentID);
	         driver.switchTo().window(handles4.iterator().next());
	         Thread.sleep(2000);
	}


	public  void Switch_Parent_Window(String ParentID){
		   driver.switchTo().window(ParentID);
		   }
}
