package com.hotelogix.languageSmoke.WebManager.WebSettings;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class WebSettingsPage {

	public void fn_chkModeOfPayment() throws Exception
	{
		try
		{
		if(GenericMethods.GI().getWebElement("A_WebReservationSettings_CreditCard_CB").isSelected()==true)
		{
			GenericMethods.GI().getWebElement("A_WebReservationSettings_CreditCard_CB").click();
		}if(GenericMethods.GI().getWebElement("A_WebReservationSettings_Cheque_CB").isSelected()==true)
		{
			GenericMethods.GI().getWebElement("A_WebReservationSettings_Cheque_CB").click();
		}if(GenericMethods.GI().getWebElement("A_WebReservationSettings_BankTransfer_CB").isSelected()==true)
		{
			GenericMethods.GI().getWebElement("A_WebReservationSettings_BankTransfer_CB").click();
		}if(GenericMethods.GI().getWebElement("A_WebReservationSettings_Fax_CB").isSelected()==true)
		{
			GenericMethods.GI().getWebElement("A_WebReservationSettings_Fax_CB").click();
		}
		}catch(Exception e){
			throw e;
		}
	}
}
