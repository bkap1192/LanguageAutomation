package com.hotelogix.languageSmoke.AdminHomePage;

import org.openqa.selenium.WebElement;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AdminHomePage {


	public void fn_NavigateAnyModule(WebElement mouseover, WebElement submodule) throws Exception{
		try{
			GenericMethods.GI().fn_Mouseover(mouseover);
			GenericMethods.GI().fn_Click(submodule);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
