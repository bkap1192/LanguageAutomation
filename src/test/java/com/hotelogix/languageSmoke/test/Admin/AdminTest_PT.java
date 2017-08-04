package com.hotelogix.languageSmoke.test.Admin;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.AdminHomePage.AdminHomePage;
import com.hotelogix.languageSmoke.Amenities.AddAmenity;
import com.hotelogix.languageSmoke.Amenities.AmenitiesLandingPage;
import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class AdminTest_PT {

	private HashMap<String ,String> HM;
	private String sheetname="Admin_SZ_Portuguese";
	private String Path="TestData//LanguagesTestData.xlsx";
	
	                          
	
	
	@BeforeMethod
	public void Login() throws Exception{
		try{
			GenericMethods.GI().fn_LaunchBrowser("FF", "http://hotelogix.stayezee.com/admine/login/login/");
		
			new LoginClass().fn_LoginHotel(GenericMethods.GI().loadOR().getProperty("Hotel_ID"), GenericMethods.GI().loadOR().getProperty("UserName"), GenericMethods.GI().loadOR().getProperty("Password"));
		
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
			AdminHomePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_Amenities"));			
		    AmenitiesLandingPage ALP=new AmenitiesLandingPage();
			VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AmentitiesList_Title"));
			ALP.fn_clkAddAmenity();
			AddAmenity AA=new AddAmenity();
			AA.fn_addAmenityDetails();
			
		}catch(Exception e){
			throw e;
		}
	    }
	
	@AfterMethod
	public void fn_close(){
		GenericMethods.GI().driver.close();
	}
}
