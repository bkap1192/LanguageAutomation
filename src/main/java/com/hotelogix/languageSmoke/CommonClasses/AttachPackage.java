package com.hotelogix.languageSmoke.CommonClasses;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AttachPackage {

	public String attachedPkg;
	
	public ArrayList<String> fn_searchPkg() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count1=GenericMethods.GI().fn_GetListWebElement("A_AttachAPackage_TrCount").size();
		for(int i=2;i<count1;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//form[@id='frmListView']//table[2]//tr["+i+"]//td[4]")).getText();
			int k=str.indexOf("(");			
			arr.add(str.substring(0, k).trim());
		}
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AttachAPackage_Close_BTN"));
		return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getAttachedPkgName(String pkgName) throws Exception{
		try{
		int count=GenericMethods.GI().fn_GetListWebElement("A_AttachAPackage_TrCount").size();
		for(int i=2;i<=count;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='poptable']/tbody/tr["+i+"]//td[4]")).getText();
			int k=str.indexOf("(");
			attachedPkg=str.substring(0, k).trim();
			if(attachedPkg.equals(pkgName)){
				GenericMethods.GI().driver.findElement(By.xpath("//table[@class='poptable']/tbody/tr["+i+"]//td[2]/input")).click();
				break;
			}
		}		
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AttachAPackage_Attach_BTN"));
		return attachedPkg;		
	}catch(Exception e){
		throw e;
	}
	}
	
	
}
