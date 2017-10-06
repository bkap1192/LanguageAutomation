package com.hotelogix.languageSmoke.Frontdesk;

import org.openqa.selenium.NoSuchElementException;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class CheckInCardPage {

	
	
	public void fn_ClickonCloseButton() throws Exception{
		try{
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_CheckInCardPage_Close_BT"));
		}catch(NoSuchElementException e){
			GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_CheckInCardPage_Close_BT"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
}
