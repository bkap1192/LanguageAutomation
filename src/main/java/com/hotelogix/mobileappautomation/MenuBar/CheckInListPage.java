package com.hotelogix.mobileappautomation.MenuBar;

import org.openqa.selenium.WebElement;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;



public class CheckInListPage {

	
	
	
	public String fn_SearchCheckedInReservation(String fname) throws Exception{
		try{
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_CheckInListPage_CheckedIn_BT"));
			M_GenericMethods.GI().fn_Sendkeys(M_GenericMethods.GI().getWebElement("M_CheckInListPage_SearchBox_ED"), fname);
			WebElement guest=M_GenericMethods.GI().getWebElement("M_CheckInListPage_GuestName_TX");
			String guestnme=M_GenericMethods.GI().Js_getText(guest);
			return guestnme;
		}catch(Exception e){
			throw e;
		}
	     }
	
	
}
