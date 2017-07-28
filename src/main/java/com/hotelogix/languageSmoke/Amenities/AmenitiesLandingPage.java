package com.hotelogix.languageSmoke.Amenities;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AmenitiesLandingPage {
	
	
	
	public void fn_AddaAmenities() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("Hotelogix_admin_AmenitiesPage_AddaAmenities_Link"));
		}catch(Exception e){
			throw e;
		}
	}

}
