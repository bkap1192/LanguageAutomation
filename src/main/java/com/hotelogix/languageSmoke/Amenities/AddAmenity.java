package com.hotelogix.languageSmoke.Amenities;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddAmenity {

	
	public String amenityName;
	
	
	public void fn_addAmenityDetails() throws Exception{
		try{
		amenityName=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAmenityPage_AmenityTitle_ED"), amenityName);
	    GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAmenityPage_AmenityDescription_ED"), amenityName);
	    GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddAmenityPage_Save_BTN"));
		}catch(Exception e){
			throw e;
		}
	
	}
	
}
