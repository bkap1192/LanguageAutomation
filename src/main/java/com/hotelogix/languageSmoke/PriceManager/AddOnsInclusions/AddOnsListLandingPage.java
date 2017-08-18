package com.hotelogix.languageSmoke.PriceManager.AddOnsInclusions;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddOnsListLandingPage {

	private HashMap<String ,String> HM;
	
	public void fn_clkAddAddOnsLink() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddOnsList_AddAddOns_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_verifyMesssage() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_AddOnsList_Message_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public ArrayList<String> fn_getAddOnsList(String addOn,String status) throws Exception{
		try{
		ArrayList<String> arr1=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_AddOnsList_TrCount").size();
		for(int i=2;i<=count;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			arr1.add(str.split(" ")[0]);		
			if(str.contains(addOn)){
			String src=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[7]//img")).getAttribute("src");
			Assert.assertEquals(src.endsWith(status), true);			
			break;
			}
		}
		
		return arr1;
		}catch(AssertionError e){
			throw e;
		}
		catch(Exception e){
			throw e;
		}
	}
	
}
