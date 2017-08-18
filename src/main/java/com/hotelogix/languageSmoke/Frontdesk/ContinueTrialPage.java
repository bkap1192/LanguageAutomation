package com.hotelogix.languageSmoke.Frontdesk;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ContinueTrialPage {

	
	private String Text="Outro usuário com o mesmo nome de usuário já está conectado ao sistema. Deseja continuar??";
	
	
	
	public void fn_CountinueWithTrail() throws Exception{
		try{
		String str=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_ContinueTrailPage_Continue_TX"));
			if(str.contains(Text)){
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_ContinueTrailPage_Yes_BT"));
			}
			GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_ContinueTrailPage_ContinueTrail_BT"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
}
