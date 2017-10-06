package com.hotelogix.languageSmoke.Web;



import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class WebSelectRoomPage {

	
	public String fn_getPageHeader() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebSelectRoomPage_Header_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}				
	}
	
	
	
}
