package com.hotelogix.languageSmoke.RoomManager.RoomTaxes;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddRoomTax {

	  public  String roomTaxAcntTitle;
	  public  String roomTaxAcntCode;
	    
	    
	public void fn_addAccountcode() throws Exception{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddRoomTax_AddNewAccCode_Link"));
		roomTaxAcntTitle=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddRoomTax_AccountName_ED"), roomTaxAcntTitle);
		
		
	}
	
	
	public void fn_addRoomTaxDetails(){
		
	}
	
}
