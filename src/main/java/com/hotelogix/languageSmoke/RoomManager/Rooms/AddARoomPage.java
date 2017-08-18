package com.hotelogix.languageSmoke.RoomManager.Rooms;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddARoomPage {

	
	public String roomName;
	public int roomNum;
	
	public String room1;
	
	public void fn_fillAddRoomDetails() throws Exception{
		try{
		roomNum=GenericMethods.GI().randomNumber();
		String str=GenericMethods.GI().generateRandomString();
		roomName=str+roomNum;
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddARoomPage_RoomNameNumber_ED"), roomName);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddARoomPage_RoomType_DD"), 1);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddARoomPage_Save_BTN"));
		}catch(Exception e){
			throw e;
		}		
	}
	
	public void fn_fillMultipleRoomDetails() throws Exception{
		try{
		roomName=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddARoomPage_RoomNameNumber_ED"), roomName);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddARoomPage_RoomType_DD"), 1);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddARoomPage_SaveAndDuplicate_BTN"));
		room1=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddARoomPage_RoomNameNumber_ED"), room1);
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddARoomPage_Save_BTN"));  
		}catch(Exception e){
			throw e;
		}				
	}
	
}
