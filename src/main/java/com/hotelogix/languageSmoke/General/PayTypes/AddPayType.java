package com.hotelogix.languageSmoke.General.PayTypes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddPayType {

	
	public void fn_addAccCode() throws Exception{
		 try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddPayType_AddNewAcc_Link"));
		 Thread.sleep(2000);
		 //PayTypeAcntTitle=GenericMethods.generateRandomString();
	 	 GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddPayType_PayTypeAccTitle_ED"), GenericMethods.GI().generateRandomString());
	 	 Thread.sleep(2000);
	 	 //PayTypeAcntCode=GenericMethods.generateRandomString();
	 	 GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddPayType_PayTypeAccCode_ED"), GenericMethods.GI().generateRandomString());
	 	 Thread.sleep(2000);
	 	 GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddPayType_AccCodeSave_BTN"));
		 }catch(Exception e){
			 throw e;
		 }		 
	}
	
	
	public void fn_addPayTypeDetails(String payTypeTitle) throws Exception{
		try{
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddPayType_PayTypeTitle_ED"), payTypeTitle);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddPayType_PayTypeSN_ED"), payTypeTitle);
		fn_addAccCode();
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddPayType_PayMode_DD"), 2);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddPayType_Save_BTN"));
		}catch(Exception e){
			throw e;
		}	
	}
	
	
	
}


