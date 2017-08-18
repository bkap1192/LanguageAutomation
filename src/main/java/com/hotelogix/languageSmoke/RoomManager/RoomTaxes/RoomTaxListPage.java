package com.hotelogix.languageSmoke.RoomManager.RoomTaxes;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class RoomTaxListPage {

	
	private HashMap<String ,String> HM;
	
	public void fn_clkAddATax() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_RoomTaxListPage_AddATax"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_verifyMsg() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_RoomTaxListPage_Message_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_verifyStatus(String taxTitle,String status){
		try{
		int count1=GenericMethods.GI().fn_GetListWebElement("A_AddRoomTax_TrCount").size();
		for(int i=2;i<=count1;i++){
			String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
			if(data.equals(taxTitle)){
				String src=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]//img")).getAttribute("src");
			    Assert.assertEquals(src.endsWith(status), true);
			    break;
			}
		}
		}catch(AssertionError e){
			throw e;
		}				
	}
	
	
}
