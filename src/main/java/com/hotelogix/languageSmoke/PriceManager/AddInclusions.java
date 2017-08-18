package com.hotelogix.languageSmoke.PriceManager;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddInclusions {

	public String inclName;
	
	public ArrayList<String> fn_getInclList() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_AddInclusions_TrCount").size();
		for(int i=2;i<=count;i++){			
			String str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[3]")).getText();
			arr.add(str.split("\n")[0]);
		}
		return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_addInclusion() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddInclusions_Checkbox1"));
		inclName=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_AddInclusions_InclusionName"));
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddInclusions_AddToPackage_BTN"));
		return inclName;
		}catch(Exception e){
			throw e;
		}
	}
	
}
