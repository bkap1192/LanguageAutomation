package com.hotelogix.languageSmoke.PriceManager.AddOnsInclusions;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class AddAddOnsPage {

	public  String addOnName;
	
	public void fn_addAddOnDetails() throws Exception{
		try{
		int num=GenericMethods.GI().randomNumber();
		addOnName="AddOn"+num;
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAddOn_AddOnTitle_ED"), addOnName);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("A_AddAddOn_InclusionSN_ED"), Integer.toString(num));
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddAddOn_POSPoint_DD"), 1);
		Thread.sleep(3000);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddAddOn_POSProduct_DD"), 1);
		Thread.sleep(3000);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddAddOn_CalculationRule_DD"), 1);
		Thread.sleep(2000);
		GenericMethods.GI().SelectByIndex(GenericMethods.GI().getWebElement("A_AddAddOn_PostingRhythm_DD"), 1);
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddAddOn_SaveAddOn_BTN"));
		}catch(Exception e){
			throw e;
		}				
	}
	
}
