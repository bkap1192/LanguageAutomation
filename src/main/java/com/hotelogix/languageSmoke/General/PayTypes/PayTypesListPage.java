package com.hotelogix.languageSmoke.General.PayTypes;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class PayTypesListPage {

	
	public void fn_clkAddPayTypeLnk() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PayTypes_AddAPayType_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getMsgText() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_AddPayType_Message_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public ArrayList<String> fn_getPayType(String payType,String statusSrc) throws Exception{
	   try{
        ArrayList<String> arr=new ArrayList<String>();
        int count=GenericMethods.GI().fn_GetListWebElement("A_PayTypes_TrCount").size();
		for(int i=2;i<=count;i++){
			String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			arr.add(data);
			if(data.equals(payType)){
				String status=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[7]//img")).getAttribute("src");
			    Assert.assertEquals(status.endsWith(statusSrc),true );
				break;
			}
		}
		return arr;
	   }catch(Exception e){
		   throw e;
	   }
	}
}
