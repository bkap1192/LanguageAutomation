package com.hotelogix.languageSmoke.Frontdesk;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class SingleReservationPage {

	
	
	
	
	
	public void fn_FillDataInSingleReservationPage(String fname) throws Exception{
		try{
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_SingleReservationPage_FirstName_ED"), fname);
			String lastname=GenericMethods.GI().generateRandomString();
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_SingleReservationPage_LastName_ED"), lastname);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_SingleReservationPage_Phone_ED"), "85858585");
			String mail=GenericMethods.GI().generateRandomString()+"@gmail.com";
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_SingleReservationPage_Email_ED"), mail);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_SingleReservationPage_Reserve_BT"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	
	
}
