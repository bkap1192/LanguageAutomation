package com.hotelogix.languageSmoke.Frontdesk;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class GroupReservationPage {

	
	
	
	
	
	
	
		public void fn_FillDetailsForGroupReservation(String taname,String fname) throws Exception{
			try{
				
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_TAname_ED"), taname);
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_FirstName_ED"), fname);
				String lastname=GenericMethods.GI().generateRandomString();
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_LastName_ED"), lastname);
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_Phone_ED"), "858585858");
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_GroupReservationPage_Reserve_BT"));
			}catch(Exception e){
				throw e;
			}
		    }
		
		public void fn_FillDetailsForGroupReservation(String fname) throws Exception{
			try{
				
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_FirstName_ED"), fname);
				String lastname=GenericMethods.GI().generateRandomString();
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_LastName_ED"), lastname);
				String email=GenericMethods.GI().generateRandomString()+"@gmail.com";
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_Email_ED"), email);
				GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_GroupReservationPage_Phone_ED"), "858585858");
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_GroupReservationPage_Reserve_BT"));
			}catch(Exception e){
				throw e;
			}
		    }
	
	
}
