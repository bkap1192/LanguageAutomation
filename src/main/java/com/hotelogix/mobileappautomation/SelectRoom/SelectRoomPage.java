package com.hotelogix.mobileappautomation.SelectRoom;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class SelectRoomPage {

	
	
	
	public void fn_SelectRoomAndClickContinue() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_SelectRoomPage_RoomType_Tab"));
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_SelectRoomPage_Continue_BT"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	public void fn_ClickAgentOrCorporate(String element){
		try{
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement(element));
		}catch(Exception e){
			
		}
	}
	
	
	
	
}
