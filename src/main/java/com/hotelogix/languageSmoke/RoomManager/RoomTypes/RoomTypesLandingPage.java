package com.hotelogix.languageSmoke.RoomManager.RoomTypes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class RoomTypesLandingPage {

	
	public void fn_clkEdit() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_RoomTypesLandingPage_Edit_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	public void fn_clkAddRoomType() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_RoomTypesLandingPage_AddARoomType_Link"));;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getMessageText() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_RoomTypesLandingPage_Message_Text"));
	    return str;
		}catch(Exception e){
			throw e;
		}	
	}
	
}
