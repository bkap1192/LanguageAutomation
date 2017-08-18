package com.hotelogix.languageSmoke.RoomManager.RoomTaxes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddRoomTax {

	  private  String roomTaxAcntTitle;
	  private  String roomTaxAcntCode;
	  public  String  taxTitle;
	    
	public void fn_addAccountcode() throws Exception{
		try{
			Thread.sleep(2000);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddRoomTax_AddNewAccCode_Link"));
		roomTaxAcntTitle=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_AccountName_ED"), roomTaxAcntTitle);
		Thread.sleep(3000);
		roomTaxAcntCode=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_AccountCode_ED"), roomTaxAcntCode);
		Thread.sleep(3000);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddRoomTax_SaveAcc_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_addRoomTaxDetails(String value) throws Exception{
		try{
		taxTitle=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_TaxTitle_ED"), taxTitle);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_TaxID_ED"), taxTitle);
		fn_addAccountcode();
		Thread.sleep(2000);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddRoomTax_AccountCode_DD"), 1);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_AccountDescription_ED"), taxTitle);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomtax_TaxAmt_ED"), value);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddRoomTax_TaxType_DD"), 2);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddRoomTax_SaveTax_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	
}
