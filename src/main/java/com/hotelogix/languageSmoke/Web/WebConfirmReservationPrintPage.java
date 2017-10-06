package com.hotelogix.languageSmoke.Web;

import java.util.ArrayList;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class WebConfirmReservationPrintPage {

	public static ArrayList<String> al1=new ArrayList<String> ();
	
	
	public String fn_getPageHeader() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPrintPage_Header_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getReservID() throws Exception{
		try{
		String reservID=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPrintPage_ReservID_Text"));
		return reservID;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public ArrayList<String> fn_getAmtDetails() throws Exception{
		try{
		String TAmt=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPrintPage_TotalAmt_Text"));
		String TTax=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPrintPage_TotalTax_Text"));
		String TAmtTax=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPrintPage_TotalAmtWithTax_Text"));
		al1.add(TAmt);
		al1.add(TTax);
		al1.add(TAmtTax);
		return al1;
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
