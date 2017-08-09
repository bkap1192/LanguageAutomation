package com.hotelogix.languageSmoke.RoomManager.Rooms;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class RoomsListLandingPage {

	
	public void fn_clkAddARoom() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_RoomsListLandingPage_AddARoom_Link"));
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public String fn_verifyMsg() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_AmenitiesLandingPage_Message_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_getAddedRoom(){
		
	}
	
	
}
