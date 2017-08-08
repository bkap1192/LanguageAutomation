package com.hotelogix.languageSmoke.RoomManager.Amenities;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class AmenitiesLandingPage {
	
	
	
	public void fn_clkAddAmenity() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AmenitiesLandingPage_AddAmenity_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_verifyMsg() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_AmenitiesLandingPage_Message_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
