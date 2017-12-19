package com.hotelogix.mobileappautomation.StayDetails;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class StayDetailsPage {

	
	
	
	
	
	public void fn_FillGuestDetailsAndConfirm(String fname, String lname) throws Exception{
		try{
			M_GenericMethods.GI().fn_Sendkeys(M_GenericMethods.GI().getWebElement("M_StayDetailsPage_FirstName_ED"), fname);
			M_GenericMethods.GI().fn_Sendkeys(M_GenericMethods.GI().getWebElement("M_StayDetailsPage_LastName_ED"), lname);
			M_GenericMethods.GI().fn_Sendkeys(M_GenericMethods.GI().getWebElement("M_StayDetailsPage_Mobile_ED"), "8584884885");
			M_GenericMethods.GI().fn_Sendkeys(M_GenericMethods.GI().getWebElement("M_StayDetailsPage_Email_ED"), "xyz@stayezee.com");
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_StayDetailsPage_Confirm_BT"));
		}catch(Exception e){
			throw e;
		}
	}
}
