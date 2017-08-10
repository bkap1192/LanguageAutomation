package com.hotelogix.languageSmoke.RoomManager.RoomTypes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class RoomTypesLandingPage {

	
	public void fn_clkEdit() throws Exception{
		try{
		GenericMethods.GI().getWebElement("A_RoomTypesLandingPage_Edit_Link").click();
		}catch(Exception e){
			throw e;
		}
	}
}
