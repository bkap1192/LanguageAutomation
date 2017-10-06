package com.hotelogix.languageSmoke.Web;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class WebAddMoreRoomPage {

	public String fn_getPageHeader() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebAddMoreRoomPage_Header_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}
	}
	
}
