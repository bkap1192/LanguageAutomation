package com.hotelogix.mobileappautomation.RoomAssign;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class RoomAssignPage {
	
	
	
	
	
	public void fn_SelectRoomAndClickContinue() throws Exception{
		try{
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_RoomAssignPage_Room_BT"));
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_RoomAssignPage_Continue_BT"));
		}catch(Exception e){
			throw e;
		}
	}

}
