package com.hotelogix.languageSmoke.Frontdesk;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class CashCounterPage {

	public void fn_SelelctCounter(String countername) throws Exception{
		try{
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_CashCounterPage_Counter_DD"), countername);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_CashCounterPage_Continue_BT"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
}
