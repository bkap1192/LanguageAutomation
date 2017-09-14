package com.hotelogix.languageSmoke.Frontdesk;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;



public class FrontdeskLandingPage {

	
	
	
	public String firstname;
	
	
	
	
	
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
	
	
}
