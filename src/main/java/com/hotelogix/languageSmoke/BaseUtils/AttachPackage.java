package com.hotelogix.languageSmoke.BaseUtils;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AttachPackage {

	public ArrayList<String> fn_searchPkg() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_AttachAPackage_TrCount").size();
		for(int i=2;i<=count;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();
			arr.add(str.split("(")[0].trim());
		}
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AttachAPackage_Close_BTN"));
		return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
}
