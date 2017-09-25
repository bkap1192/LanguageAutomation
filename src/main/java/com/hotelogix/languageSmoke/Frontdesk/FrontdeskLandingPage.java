package com.hotelogix.languageSmoke.Frontdesk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.CommonClasses.AttachPackage;
import com.hotelogix.languageSmoke.CommonClasses.PackageDetail;
import com.hotelogix.languageSmoke.PriceManager.FrontdeskPackages.ListOfFrontdeskPackages;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;



public class FrontdeskLandingPage {

	
	
	
	public String firstname;
	public String OneNightPackage="One Night package (1N)";
	public String ONP="One Night package";
	
	
	
	
	
	public void fn_RightClick(WebElement we) throws Exception{
		try{
			Actions aobj=new Actions(GenericMethods.GI().driver);
			aobj.contextClick(we).build().perform();
		}catch(Exception e){
			throw e;
		}
	}
	
	public void fn_ClickCancelandCurrentLink() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Cancel_LK"));
			GenericMethods.GI().ActionOnAlert("Accept");
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Current_LK"));
		}catch(Exception e){
			GenericMethods.GI().driver.navigate().refresh();
			GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Cancel_LK"));
			GenericMethods.GI().ActionOnAlert("Accept");
			GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Current_LK"));
		}
	   }
	
	
	public void fn_createFDReserv(String roomtype,String from,String to){
		 List<WebElement> ele=GenericMethods.GI().driver.findElements(By.xpath("//div[starts-with(@id,'rthead')]"));
		   int RTsize=ele.size();
		   for(int j=0;j<=RTsize-1;j++){
			   int k=j+1;
		       String str=ele.get(j).getText().trim();
		        if(str.trim().equals(roomtype)) {
		              Assert.assertEquals(str, roomtype);
		             WebElement ele2= GenericMethods.GI().driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+from+"]"));
		             WebElement ele3= GenericMethods.GI().driver.findElement(By.xpath("(//div[@class='rtype'])["+k+"]//div[contains(@id,'crossblock')]["+to+"]"));
	                  Actions act=new Actions(GenericMethods.GI().driver);
	                 act.dragAndDrop(ele2, ele3).build().perform(); 
	               }
		           }
	               }
	
	
	public void fn_FillQuickReservationForm(String rate,String roomnum,String salutation,String firstname,String reservkey) throws Exception{
		try{
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Rate_DD"), rate);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Rooms_DD"), roomnum);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Salutation_DD"), salutation);
			
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_FirstName_ED"), firstname);
			String lastname=GenericMethods.GI().generateRandomString();
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_LastName_ED"), lastname);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Phone_ED"), "85858585");
			String email=GenericMethods.GI().generateRandomString()+"@gmail.com";
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Email_ED"), email);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement(reservkey));
		}catch(UnhandledAlertException e){
			GenericMethods.GI().ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void fn_VerifyCreatedReservation(String firstname,String expected) throws Throwable{
		try{
			Thread.sleep(5000);
			String status=GenericMethods.GI().driver.findElement(By.xpath("(//div[contains(text(),'"+firstname+"')])[1]")).getAttribute("rsvstatus");
		    VerifyUtils.VU().fn_AsserEquals(status, expected);
		}catch(Exception e){
			Thread.sleep(3000);
			String status=GenericMethods.GI().driver.findElement(By.xpath("(//div[contains(@title,'"+firstname+"')])[1]")).getAttribute("rsvstatus");
		    VerifyUtils.VU().fn_AsserEquals(status, expected);
		}catch(Throwable e){
			throw e;
		}
	}
	
	
	
	
	public WebElement fn_GetReservedWebElement(String firstname) throws Exception{
		try{
			//WebElement we=GenericMethods.GI().driver.findElement(By.xpath("(//div[contains(text(),'"+firstname+"')])[1]"));
			 WebElement we=GenericMethods.GI().driver.findElement(By.cssSelector("div.rs-new"));
			 return we;
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	public void fn_ClickSingleOrGroupOrAgentLink(String linkkeyname) throws Exception{
		try{
			GenericMethods.GI().fn_ActionsClick(GenericMethods.GI().getWebElement(linkkeyname));
		}catch(Exception e){
			Thread.sleep(2000);
			GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement(linkkeyname));
		}
	}
	
	
	public void fn_ClickRestaurantLink() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Restaurant_LK"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	public boolean fn_CheckPackageinQuickResvationForm() throws Exception{
		try{
			ArrayList<String> arr=new ArrayList<String>();
			List<WebElement> we= new Select(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Rate_DD")).getOptions();
			Iterator<WebElement> ite=we.iterator();
			while(ite.hasNext()==true){
				String option=ite.next().getText();
				arr.add(option);
				System.out.println(option);
			}
			boolean result=arr.contains(OneNightPackage);
			return result;
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	public void fn_CheckAndCreatePackage(HashMap<String,String> HM) throws Exception{
		try{
			boolean result=fn_CheckPackageinQuickResvationForm();
			if(result==false){
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
				GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
				BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_FrontdeskPackage"));
				
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AttachAPackage_Link"));
				BasePage.AHP().fn_clkAttachPkgLink();
				Thread.sleep(2000);
				GenericMethods.GI().switchToWindowHandle(HM.get("AttachPackage_Title"));
				AttachPackage.class.newInstance().fn_getAttachedPkgName(ONP);
				Thread.sleep(2000);
				GenericMethods.GI().switchToWindowHandle(HM.get("FrontdeskListPackage_Title"));
				ListOfFrontdeskPackages LFP= new ListOfFrontdeskPackages();
				LFP.fn_confgrAttachedPkg(ONP);
				PackageDetail PD=new PackageDetail();
				PD.fn_clkSaveBtn();
				LFP.fn_clkAddActiLink(ONP);
				GenericMethods.GI().switchToWindowHandle(HM.get("AddActivation_Title"));
				BasePage.AHP().fn_addActivationDate();
				GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
				FrontdeskLandingPage FLP=new FrontdeskLandingPage();
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Current_LK"));
				Thread.sleep(2000);
			    FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
			}else{
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
				GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
				BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_FrontdeskPackage"));
				ListOfFrontdeskPackages LFP=new ListOfFrontdeskPackages();
				LFP.fn_clkEditLnk(ONP);
				PackageDetail PD=new PackageDetail();
				PD.fn_clkSaveBtn();
				GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	public void fn_FillQuickReservationForTA(String rate,String roomnum,String salutation,String firstname) throws Exception{
		try{
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Rate_DD"), rate);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Rooms_DD"), roomnum);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Salutation_DD"), salutation);
			
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_FirstName_ED"), firstname);
			String lastname=GenericMethods.GI().generateRandomString();
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_LastName_ED"), lastname);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Phone_ED"), "85858585");
			String email=GenericMethods.GI().generateRandomString()+"@gmail.com";
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Email_ED"), email);
		}catch(UnhandledAlertException e){
			GenericMethods.GI().ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
	    }
}
