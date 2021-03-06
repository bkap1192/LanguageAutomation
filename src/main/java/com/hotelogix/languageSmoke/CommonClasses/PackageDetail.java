package com.hotelogix.languageSmoke.CommonClasses;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class PackageDetail {

	public static String PackagePrice;
	
	
	
	public void fn_clkSaveBtn() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PackageDetail_ToView_LK"));
			 Thread.sleep(1000);
			  int count=GenericMethods.GI().fn_GetListWebElement("A_PackageDetail_TotalPackagePrice_Trcount").size();
			     for(int i=1;i<=count;i++){
				    String roomtype=GenericMethods.GI().driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//tr["+i+"]/td")).getText();
			          if(roomtype.contains(GenericMethods.GI().Roomtype)){
				        PackagePrice=GenericMethods.GI().driver.findElement(By.xpath("//td[@class='table-validity']/table//tr[3]//tr["+i+"]/td[5]/a")).getText();
			            break;
			          }
			          }
						GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PackageDetail_Save_BTN"));
						}catch(Exception e){
							throw e;
						}
	                  }
	
	
	public String fn_clkToGridBtn() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PackageDetail_ToGrid_BTN"));
		String str=GenericMethods.GI().ActionOnAlert("Accept");
		return str;
		}catch(Exception e){
			throw e;
		}	
	}
	
	
	public String fn_getSaveMsg() throws Exception{
		try{
		String pName=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_PackageDetail_SaveMsg_Text"));
		return pName;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_clkSaveAsGridBtn() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PackageDetail_SaveAsGrid_BTN"));
		String saveGrid=GenericMethods.GI().ActionOnAlert("Accept");
		return saveGrid;
		}catch(Exception e){
			throw e;
		}		
	}
	
	
}
