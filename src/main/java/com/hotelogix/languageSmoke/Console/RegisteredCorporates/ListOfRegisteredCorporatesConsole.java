package com.hotelogix.languageSmoke.Console.RegisteredCorporates;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfRegisteredCorporatesConsole {

	
	public void fn_clkAddCorporateLnk() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_CListOfRegisteredCorporates_AddCorporates_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
}
