package com.hotelogix.mobileappautomation.SingleEdit;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class SingleEditPage {

	
	public void fn_ClickOnCheckIN() throws Exception{
		try{
			M_GenericMethods.GI().fn_Click(M_GenericMethods.GI().getWebElement("M_SingleEditPage_CheckIn_BT"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
}
