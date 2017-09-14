package com.hotelogix.languageSmoke.Console.TravelAgent;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddaTravelAgentPage {

	public String fname;
	
	
	
	public void fn_CreateTravelAgent(String TAname) throws Exception{
		try{
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_TravelAgentName_ED"), TAname);
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Address1_ED"), "Singh");
			Thread.sleep(500);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Country_DD"), "India");
			Thread.sleep(1000);
			GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_State_DD"), "Assam");
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_City_ED"), "Noida");
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_ZipCode_ED"), "110096");
			fname=GenericMethods.GI().generateRandomString();
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_FirstName_ED"), fname);
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_LastName_ED"), GenericMethods.GI().generateRandomString());
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Desiganation_ED"), "Owner");
			Thread.sleep(500);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_PhoneNo_ED"), "858585888");
			Thread.sleep(500);
			String email=GenericMethods.GI().generateRandomString()+"@gmail.com";
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Email_ED"), email);
			Thread.sleep(500);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_MainBilling_CB"));
			Thread.sleep(500);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_MainBillingContact_CB"));
			Thread.sleep(500);
			try{
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Save_BT"));
			}catch(Exception e){
				Thread.sleep(2000);
				GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_AddaTravelAgentPage_Save_BT"));
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
