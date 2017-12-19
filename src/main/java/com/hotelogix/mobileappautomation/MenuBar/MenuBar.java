package com.hotelogix.mobileappautomation.MenuBar;

import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;

public class MenuBar {

	
	
	
	public void fn_ClickOnLogOut() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_Icon"));
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_Logout_Icon"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_ClickTodaysCheckIn() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_Icon"));
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_TodaysCheckIn_Icon"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_ClickOnHome() throws Exception{
		try{
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_Icon"));
			M_GenericMethods.GI().fn_ActionsClick(M_GenericMethods.GI().getWebElement("M_MenuBar_Home_Icon"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
