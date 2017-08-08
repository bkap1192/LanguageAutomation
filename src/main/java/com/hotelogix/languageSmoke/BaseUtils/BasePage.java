package com.hotelogix.languageSmoke.BaseUtils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class BasePage {

	
	
	public static BasePage AHP(){
		return new BasePage();
	}
	

	public void fn_NavigateAnyModule(WebElement mouseover, WebElement submodule) throws Exception{
		try{
			GenericMethods.GI().fn_Mouseover(mouseover);
			GenericMethods.GI().fn_Click(submodule);
		}catch(Exception e){
			throw e;
		}
	}
	
	public ArrayList<String> fn_GetAddedFields() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		 int count=GenericMethods.GI().fn_GetListWebElement("A_TrCount").size();
		 for(int i=2;i<=count;i++){
			 String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			 arr.add(data);			 
		 }
			 return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
	public void fn_viewAll() throws Exception{
		try{
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_ViewAll_DD"), "All");
		GenericMethods.GI().ActionOnAlert("Accept");
		}catch(Exception e){
			throw e;
		}
	}
	
}
