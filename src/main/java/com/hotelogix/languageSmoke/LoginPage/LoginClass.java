package com.hotelogix.languageSmoke.LoginPage;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class LoginClass {

	
	public void fn_LoginHotel(String hotelid, String username, String password) throws Exception{
		try{
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("Hotelogix_admin_loginpage_HotelCode_ED"), hotelid);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("Hotelogix_admin_loginpage_UserName_ED"), username);
			GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("Hotelogix_admin_loginpage_Password_ED"), password);
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("Hotelogix_admin_loginpage_Login_BT"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
