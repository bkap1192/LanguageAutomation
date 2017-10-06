package com.hotelogix.languageSmoke.Frontdesk;

import java.util.ArrayList;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ViewDetailsPage {

	
	public String Rate;
	
	public ArrayList<String> al1=new ArrayList<String> ();;
	
	public String fn_GetRate() throws Exception{
		try{
			
			return Rate=GenericMethods.GI().getWebElement("F_ViewDetailsPage_Rates_LK").getText();
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	public ArrayList<String> fn_getAmtDetails() throws Exception{
		try{
		String tamt1=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_ViewDetailsPage_TotalAmt_Text"));
		String ttax=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_ViewDetailsPage_Tax_Text"));
		String tAmtTax=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_ViewDetailsPage_TAmtTaxText"));
		al1.add(tamt1);
		al1.add(ttax);
		al1.add(tAmtTax);
		return al1;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
