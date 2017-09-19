package com.hotelogix.languageSmoke.PriceManager.TAPackages;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.Console.RegisteredTravelAgent.AddaTravelAgentPage;
import com.hotelogix.languageSmoke.Console.RegisteredTravelAgent.ListOfRegisteredTAConsole;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfRegisteredTravelAgents {

	public void fn_chkTravelAgent(String actual) throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_PMListOfRegisteredTA_NoEntries_Text"));
		if(text.equals(actual.trim())){
			BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_Console"), GenericMethods.GI().getWebElement("A_AdminHomePage_RegisteredTravelAgents"));
		    ListOfRegisteredTAConsole LTA=new ListOfRegisteredTAConsole();
		    LTA.fn_clkAddTALnk();
		    AddaTravelAgentPage ATA=new AddaTravelAgentPage();
		    ATA.fn_CreateTravelAgent("TA1");
			BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_TravelAgentPackage"));		
		}
		}catch(Exception e){
			throw e;
		}				
	}
	
}
