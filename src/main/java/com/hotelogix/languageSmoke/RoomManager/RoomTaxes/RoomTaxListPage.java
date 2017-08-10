package com.hotelogix.languageSmoke.RoomManager.RoomTaxes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class RoomTaxListPage {

	
	public void fn_clkAddATax() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_RoomTaxListPage_AddATax"));
		}catch(Exception e){
			throw e;
		}
	}
	
}
