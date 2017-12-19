package com.hotelogix.mobileappautomation.GuestCheckIn;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class GuestCheckInPage {

	
	
	
	
	public void fn_SelectGuestAndClickCheckInSelected() throws Exception{
		try{
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_GuestCheckInPage_GuestCheckBox_CB"));
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_GuestCheckInPage_CheckInSelected_BT"));
		}catch(Exception e){
			throw e;
		}
	  }
	
	
	
	
	
	
}
