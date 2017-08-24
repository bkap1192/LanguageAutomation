package com.hotelogix.languageSmoke.General.DefaultSettings;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class DefaultSettingsPage {

    public  String i="3.00";
	
	
	public void fn_changeNATime(String hr,String min,String ampm,String calDate) throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_NAChange_Link"));
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_NAHour_DD"), hr);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_NAMinute_DD"), min);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_NightAuditAMPM_DD"), ampm);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_NACalendarDate_DD"), calDate);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_NAOk_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_changeCheckinTime(String hr,String min,String ampm) throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckinChange-Link"));
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckinHour_DD"), hr);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckinMinute_DD"), min);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckinAMPM_DD"), ampm);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckinOk_BTN"));
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public void fn_changeCheckoutTime(String hr,String min,String ampm) throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckoutChange_Link"));
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckoutHour_DD"), hr);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckoutMinute_DD"), min);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckoutAMPM_DD"), ampm);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_CheckoutOk_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	public void fn_changeEarlycheckoutCharge() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_EarlyCheckoutChange_Link"));
		Actions actobj=new Actions(GenericMethods.GI().driver);
		actobj.sendKeys(GenericMethods.GI().getWebElement("A_DefaultSettings_EarlyCheckoutCharge_ED"),Keys.chord(Keys.CONTROL,"a"),i).build().perform();
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_EarlyCheckoutChargeOk_BTN"));
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_DefaultSettings_Save_BTN"));
		}catch(Exception e){
			throw e;
		}
	}
	

	public String fn_getEarlyCheckoutPolicy() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_DefaultSettings_EarlyCheckoutPolicy_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
	
	public String fn_getSaveMsg() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_DefaultSettings_SaveMsg_Text"));
		return str;
		}catch(Exception e){
			throw e;
		}
	}
}
