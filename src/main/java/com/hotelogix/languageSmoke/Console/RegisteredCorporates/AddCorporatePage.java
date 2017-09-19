package com.hotelogix.languageSmoke.Console.RegisteredCorporates;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddCorporatePage {

	
	public void fn_fillCorporateDetails() throws Exception{
		try{
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_CorporateName_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_Address_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddCorporate_Country_DD"), 1);
	    Thread.sleep(1000);
	    GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddCorporate_State_DD"), 1);
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_City_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_ZipCode_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddCorporate_Salutation_DD"), 1);
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_FName_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_LName_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_Designation_ED"), GenericMethods.GI().generateRandomString());
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_Phone_ED"), GenericMethods.GI().generateRandomString());
        GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddCorporate_Email_ED"), GenericMethods.GI().generateRandomString()+"@stayezee.com");
	    GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddCorporate_SameAsMainOffcAddr_CB"));
	    GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddCorporate_SameAsMainContactPerson_CB"));
	    Thread.sleep(3000);
	    GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddCorporate_Save_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
}
