package com.hotelogix.languageSmoke.Console.TravelAgent;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfRegisteredTAConsole {

	
	
	public String TAname;
	
	
	public void fn_clkAddTALnk() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_CListOfRegisteredTravelAgents_AddTravelAgent"));
		}catch(Exception e){
			throw e;
		}
	}
	

    public void fn_CheckAndCreateTravelAgent(String travelagentname, String noentryfounttx) throws Exception{
   	 try{
   		 String str=GenericMethods.GI().getWebElement("F_TravelAgentLandingPage_First_Tr").getText().trim();
   		 if(str.equalsIgnoreCase(noentryfounttx.trim())){
   			 GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_TravelAgentLandingPage_AddATravelAgent"));
   			  AddaTravelAgentPage.class.newInstance().fn_CreateTravelAgent(travelagentname);
   		 }
   		TAname=GenericMethods.GI().getWebElement("F_TravelAgentLandingPage_FirstTAName_TX").getText().trim();
   	 }catch(Exception e){
   		 throw e;
   	 }
    }
    
    
}
