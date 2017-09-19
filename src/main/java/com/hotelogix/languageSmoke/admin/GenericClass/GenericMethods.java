package com.hotelogix.languageSmoke.admin.GenericClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class GenericMethods {

	public Properties OR;
	public WebDriver driver;
	private static GenericMethods GM;
	
	private String P_PropertiesPath="./LanguageAutomation/Admin_PT.properties";
	private String S_PropertiesPath="D:\\SpanishSmoke\\LanguagesAutomation\\Spanish.properties";
	
	
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
    public String Roomtype;
	
	
	
	
	
      private GenericMethods(){
    	  
      }
      
      public static GenericMethods GI(){
    	  if(GM==null){
    		 GM = new GenericMethods();
    	  }
    	  return GM;
          }
      
      static int min=1;
      static int max=1000;

      public  int randomNumber()
      {
     	 Random rand = new Random();
     	 int randomNum = rand.nextInt((max-min)+1)+min;
     	 return randomNum;
      }
      
      
 
      public Properties fn_loadpro() throws Exception{
    	  Properties pro=new Properties();
    	  FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+File.separator+"Frontdesk_PT.properties");
    	  pro.load(fis);
    	  OR=loadOR();
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

      
      public void fn_LaunchBrowser(String BrowserType, String url) throws Exception{
    	  try{
    		  if(BrowserType.equalsIgnoreCase("FF")){
    			  driver=new FirefoxDriver();
    		  }else if(BrowserType.equalsIgnoreCase("CH")){
    			  System.setProperty("webdriver.chrome.driver","E:\\TSTauto\\chromedriver.exe");
    			 driver= new ChromeDriver();
    		  }
    		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    		  driver.get(url);
    		  driver.manage().window().maximize();
    	  }catch(Exception e){
    		  throw e;
    	  }
          }
      
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
	
	public Properties loadOR(String path){
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
	
	private Properties loadOR(){
		try {
			String CP = System.getProperty("user.dir");
			if(OR==null){
				System.getProperty(P_PropertiesPath);
				FileInputStream fis=new FileInputStream(CP+File.separator+"Admin_SP.properties");
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
//
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
	   System.out.println("Yoo Back to Parent Window...");
	   }
}





