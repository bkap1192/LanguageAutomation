package com.hotelogix.languageSmoke.Amenities;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AmenitiesLandingPage {
	
	
	
	public void fn_clkAddAmenity() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AmenitiesLandingPage_AddAmenity_Link"));
		}catch(Exception e){
			throw e;
		}
	}

}
