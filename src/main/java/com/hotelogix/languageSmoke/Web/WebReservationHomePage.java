package com.hotelogix.languageSmoke.Web;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebElement;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class WebReservationHomePage {

	public String fn_getPageHeader() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("F_WebReservationhomePage_Header_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	public void fn_checkAvailabilty() throws Exception{
		try{
		Thread.sleep(7000);
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebReservationhomePage_CheckInCal_ImgBtn"));
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebReservationhomePage_CheckinCal_Link"));
        GenericMethods.GI().js_Sendkey(GenericMethods.GI().getWebElement("F_WebReservationhomePage_NightEditBox_ED"), "1");
        Calendar cal = Calendar.getInstance();
        System.out.println("current date: " + cal.getTime());
        cal.add(Calendar.DATE, 1);
        Date dob=cal.getTime();
        String st=dob.toString();
        String[] parts=st.split(" ");
        String parts2=parts[2];
        System.out.println(parts2);
        Thread.sleep(2000);
        GenericMethods.GI().js_Click(GenericMethods.GI().getWebElement("F_WebReservationhomePage_CheckOutCal_ImgBtn"));
        for(WebElement date: GenericMethods.GI().fn_GetListWebElement("F_WebReservationhomePage_DataCollection") )
        {
            String strobj1=date.getText();
            if(parts2.contains(strobj1)){
            date.click();
            break;
        }
        }

        Thread.sleep(3000);
        GenericMethods.GI().selectElement(GenericMethods.GI().getWebElement("F_WebReservationhomePage_Adult_DD"), "1");  
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebReservationhomePage_CheckAvailability_BTN"));
		}catch(Exception e){
			throw e;
		}                
	}
	
}
