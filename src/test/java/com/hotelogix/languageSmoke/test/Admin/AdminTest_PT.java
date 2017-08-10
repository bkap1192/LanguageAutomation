package com.hotelogix.languageSmoke.test.Admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.RoomManager.Amenities.AddAmenity;
import com.hotelogix.languageSmoke.RoomManager.Amenities.AmenitiesLandingPage;
import com.hotelogix.languageSmoke.RoomManager.RoomTypes.RoomTypesLandingPage;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class AdminTest_PT {

	private HashMap<String ,String> HM;
	private String sheetname="Admin_SZ_Portuguese";
	private String Path="TestData//LanguagesTestData.xlsx";
	private Properties OR;
	private String propertiesfile="D:\\SpanishSmoke\\LanguagesAutomation\\Config.properties";                          
	
	
	@BeforeClass
	public void fn_Beforeclass(){
		OR=GenericMethods.GI().loadOR(propertiesfile);
	}
	
	
	@BeforeMethod
	public void Login() throws Exception{
		try{
			GenericMethods.GI().fn_LaunchBrowser("FF", "http://hotelogix.stayezee.com/admine/login/login/");
			new LoginClass().fn_LoginHotel(OR.getProperty("HotelID_Admin_SZ"), OR.getProperty("UserName_Admin_SZ"), OR.getProperty("Password_Admin_SZ"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	//@Test(priority=1,description="User gets redirected to homepage of Admine Console after login.")
	public void fn_verifyAdmineConsoleSuccessfulLogin() throws Exception{
		try{
			String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
			VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("Adminstrator_Title"));		
		}catch(Exception e){
			throw e;
		}finally {
			
		}
	    }
	
	
	@Test(priority=2,description="Added amenity gets displayed on 'Amenities List' page and is also displayed on 'Add a Room Type' page under 'Select Amenities' >> 'Available Amenities'")
	public void fn_verifyAdditionOfAmenity() throws Exception{
		try{
			String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
			BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_Amenities"));			
		    AmenitiesLandingPage ALP=new AmenitiesLandingPage();
			VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AmentitiesList_Title"));
			ALP.fn_clkAddAmenity();
			AddAmenity AA=new AddAmenity();
			AA.fn_addAmenityDetails();
			String text=ALP.fn_verifyMsg();
		    VerifyUtils.VU().fn_AsserEquals(text, HM.get("Message_Text1")+'"'+AA.amenityName+'"'+HM.get("Message_Text2"));
			BasePage BP=new BasePage();
			BP.fn_viewAll();
			ArrayList<String> l1=BP.fn_GetAddedFields();
		    VerifyUtils.VU().fn_AssertContainsInArray(l1, AA.amenityName);
		    BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"),GenericMethods.GI().getWebElement("A_AdminHomePage_RoomTypes"));
		    RoomTypesLandingPage RTLP=new RoomTypesLandingPage();
		   
		}catch(Exception e){
			throw e;
		}
	    }
	
	@AfterMethod
	public void fn_close(){
		GenericMethods.GI().driver.close();
	}
}
