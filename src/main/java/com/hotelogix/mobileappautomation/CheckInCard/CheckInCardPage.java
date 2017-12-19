package com.hotelogix.mobileappautomation.CheckInCard;


import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;
import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class CheckInCardPage {

	
	
	
	public void fn_VerifyPrintButtonAndClickBackToCreateReservation() throws Exception{
		try{
			boolean result=M_GenericMethods.GI().getWebElement("M_CheckInCardPage_Print_BT").isEnabled();
			VerifyUtils.VU().fn_AsserEqualsWithBooleanValue(result, true);
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_CheckInCardPage_BackToCreateReservation_BT"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	
	
	
}
