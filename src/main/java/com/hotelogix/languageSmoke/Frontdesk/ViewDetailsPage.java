package com.hotelogix.languageSmoke.Frontdesk;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ViewDetailsPage {

	
	public String Rate;
	
	
	
	
	
	public String fn_GetRate() throws Exception{
		try{
			return Rate=GenericMethods.GI().getWebElement("F_ViewDetailsPage_Rates_LK").getText();
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	
}
