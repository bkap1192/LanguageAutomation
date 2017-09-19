package com.hotelogix.languageSmoke.PriceManager.CorporatePackages;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.Console.RegisteredCorporates.AddCorporatePage;
import com.hotelogix.languageSmoke.Console.RegisteredCorporates.ListOfRegisteredCorporatesConsole;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfRegisteredCorporates {

	public void fn_chkCorporate(String actual) throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_PMListOfRegisteredCorporates_NoEntries_Text"));
	    System.out.println(text);
	    System.out.println(actual.trim());
		if(text.equals(actual.trim())){
	    	BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_Console"), GenericMethods.GI().getWebElement("A_AdminHomePage_RegisteredCorporates"));
	        ListOfRegisteredCorporatesConsole LOCC=new ListOfRegisteredCorporatesConsole();
	        LOCC.fn_clkAddCorporateLnk();
	        AddCorporatePage ACP=new AddCorporatePage();
	        ACP.fn_fillCorporateDetails();	 
	    	BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_Console"), GenericMethods.GI().getWebElement("A_AdminHomePage_CorporatePackage"));
	    }
		}catch(Exception e){
			throw e;
		}
	
	}
	
	
}
