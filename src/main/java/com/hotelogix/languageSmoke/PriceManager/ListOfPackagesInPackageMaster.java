package com.hotelogix.languageSmoke.PriceManager;

import java.security.GeneralSecurityException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfPackagesInPackageMaster {

	
	public void fn_clkAddAPackageLnk() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_ListOfPackagesInPackageMaster_AddAPackage_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public ArrayList<String> fn_getPackageList(String pkgName,String status) throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfPackagesInPackageMaster_TrCount").size();
		for(int i=2;i<=count;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]/strong")).getText();
			arr.add(str);
			if(str.equals(pkgName)){
				String src=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]//img")).getAttribute("src");
				Assert.assertEquals(src.endsWith(status), true);
				break;				
			}			
		}
		return arr;
		}catch(AssertionError e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
