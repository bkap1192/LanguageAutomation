package com.hotelogix.mobileappautomation.Home;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class MobileHomePage {

	
	
	
	public void fn_ClickOnReserveIcon() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_HomePage_Reserve_Icon"));
		}catch(Exception e){
			throw e;
		}
	   }
	
	public void fn_ClickOnGotItButton() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_SelectRoomPage_GotIt_BT"));
		}catch(Exception e){
			throw e;
		}
	   }
	
	
	
	
	
}
