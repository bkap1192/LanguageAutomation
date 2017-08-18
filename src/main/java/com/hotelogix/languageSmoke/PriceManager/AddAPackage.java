package com.hotelogix.languageSmoke.PriceManager;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddAPackage {

	public String pkgName;
	
	public void fn_clkAddInclLink() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddAPackage_AddInclusion-Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_addPackageDetails(String noOfNights) throws Exception{
		try{
		pkgName=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAPackage_PackageName_ED"), pkgName);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAPackage_ShortName_ED"), pkgName);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAPackage_LengthOfStay_ED"), noOfNights);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAPackage_Description_ED"), pkgName);
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public void fn_editUpcharge(String value) throws Exception{
		try{
		GenericMethods.GI().getWebElement("A_AddAPackage_UpchargePerPerson_ED").clear();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAPackage_UpchargePerPerson_ED"), value);
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public ArrayList<String> fn_getAddedInclList() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_AddAPackage_Inclusion_TrCount").size();
		for(int i=1;i<count;i++){
			String str=GenericMethods.GI().driver.findElement(By.xpath("//form[@id='frmEditView']//tr[7]//tbody[1]//tr["+i+"]//td[2]")).getText();
			arr.add(str.split("\n")[0]);			
		}
		return arr;
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public void fn_clkSaveBtn() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddAPackage_Save_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
}