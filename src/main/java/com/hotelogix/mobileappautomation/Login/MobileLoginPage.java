package com.hotelogix.mobileappautomation.Login;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class MobileLoginPage {

	
	
	
	
	
	
	public void fn_MobileLoginWithHotelID(String hotelid, String email, String password) throws Exception{
		try{
			try{
				M_GenericMethods.GI().getWebElement("M_LoginPage_HotelID_ED").sendKeys(hotelid);
				M_GenericMethods.GI().getWebElement("M_LoginPage_Email_ED").sendKeys(email);
				M_GenericMethods.GI().getWebElement("M_LoginPage_Password_ED").sendKeys(password);
				M_GenericMethods.GI().getWebElement("M_LoginPage_Login_BT").click();
			}catch(Exception e){
				M_GenericMethods.GI().getWebElement("M_LoginPage_Email_ED").sendKeys(email);
				M_GenericMethods.GI().getWebElement("M_LoginPage_Password_ED").sendKeys(password);
				M_GenericMethods.GI().getWebElement("M_LoginPage_Login_BT").click();	
			}
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	
	
	
	
}
