package com.hotelogix.languageSmoke.Web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.Frontdesk.FrontdeskLandingPage;
import com.hotelogix.languageSmoke.General.PayTypes.AddPayType;
import com.hotelogix.languageSmoke.General.PayTypes.PayTypesListPage;
import com.hotelogix.languageSmoke.WebManager.WebSettings.WebSettingsPage;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;


public class WebConfirmReservationPage {

	private HashMap<String ,String> HM;
	public String guestFN=GenericMethods.GI().generateRandomString();
    public String guestLN=GenericMethods.GI().generateRandomString();
	
	
	public String fn_getPageHeader() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Header_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}		
	}
	
	
	public void fn_ConfirmBooking() throws Exception{
		try
		{
   			Select sel=new Select(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CardType_DD"));
			List<WebElement> ele=sel.getOptions();
			ArrayList<String> li=new ArrayList<String>();
			for(WebElement ele1:ele)
			{
				li.add(ele1.getText());
				
			}
			
		    if(	li.contains("Visa")==false)
		    {
		    	GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
		    	Thread.sleep(2000);
		    	FrontdeskLandingPage FP=new FrontdeskLandingPage();
		    	GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
		    	GenericMethods.GI().switchToWindowHandle(HM.get("AdminConsole_Title"));
		    	BasePage BP=new BasePage();
		    	BP.fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_General"), GenericMethods.GI().getWebElement("A_AdminHomePage_PayTypes"));
			    PayTypesListPage PTLP=new PayTypesListPage();
			    GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PayTypesListPage_AddPayType_Link"));
		    	AddPayType APT=new AddPayType();
		    	APT.fn_addPayTypeDetails(HM.get("PayType_Title"));
		    	BP.fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_WebManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_WebSetting"));
		    	WebSettingsPage WSP=new WebSettingsPage();
		    	WSP.fn_chkModeOfPayment();
		    	GenericMethods.GI().switchToWindowHandle(HM.get("WebConsole_Title"));    	
		    	Thread.sleep(3000);
		    }	
			
			
			GenericMethods.GI().driver.navigate().refresh();
			GenericMethods.GI().ActionOnAlert("Accept");
	    Thread.sleep(3000);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Salutation_DD"), "Mr.");
		Thread.sleep(3000);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_FirstName_ED"), guestFN);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_LastName_ED"),guestLN);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_TelephoneNum_ED"), "8506853589");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_MobileNum_ED"), "1213456");		
		String a=GenericMethods.GI().generateRandomString();
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Email_ED"), a+"@stayezee.com");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_ConfirmEmail_ED"), a+"@stayezee.com");		
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Country_DD"), "India");
		Thread.sleep(3000);
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_State_DD"), "Delhi");
		Thread.sleep(3000);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Address_ED"),"Delhi");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_City_ED"), "Delhi");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_Zip_ED"), "110096");
		
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_PreferenceTextArea"), "Need Newspaper");
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_TermsConditionCheckBox"));
		Thread.sleep(3000);
		
		boolean v=GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CreditCard_RB").isDisplayed();
		System.out.println(v);
		GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CreditCard_RB"));
		Thread.sleep(3000);
		
		
		GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CardType_DD"), "Visa");
		Thread.sleep(3000);
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_NameOnCard_ED"), "ABCD");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CardNumber_ED"), "4111111111111111");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_CVC_ED"), "111");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_ExpMonth_ED"),"12");
		GenericMethods.GI().fn_Sendkeys(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_ExpYear_ED"), "5464");
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebConfirmReservationPage_ConfirmByCreditCard_BT"));
		Thread.sleep(5000);
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
}
