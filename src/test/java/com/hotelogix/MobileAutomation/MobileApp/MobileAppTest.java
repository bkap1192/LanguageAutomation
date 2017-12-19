package com.hotelogix.MobileAutomation.MobileApp;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;

import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;
import com.hotelogix.mobileaapautomation.GenericClass.M_GenericMethods;
import com.hotelogix.mobileappautomation.CheckInCard.CheckInCardPage;
import com.hotelogix.mobileappautomation.GuestCheckIn.GuestCheckInPage;
import com.hotelogix.mobileappautomation.Home.MobileHomePage;
import com.hotelogix.mobileappautomation.Login.MobileLoginPage;
import com.hotelogix.mobileappautomation.MenuBar.CheckInListPage;
import com.hotelogix.mobileappautomation.MenuBar.MenuBar;
import com.hotelogix.mobileappautomation.RoomAssign.RoomAssignPage;
import com.hotelogix.mobileappautomation.SelectRoom.SelectRoomPage;
import com.hotelogix.mobileappautomation.SingleEdit.SingleEditPage;
import com.hotelogix.mobileappautomation.StayDetails.StayDetailsPage;

public class MobileAppTest {

	private Properties OR1;
	private HashMap<String,String> HM;
	private String path="D:\\SpanishSmoke\\LanguagesAutomation\\TestData\\LanguagesTestData.xlsx";
	private String Sheet_S="Mobile";
	
	
	
	
	@BeforeClass
	public void fn_LounchAndSetupApp() throws Exception{
		try{
			M_GenericMethods.GI().setUp();
			String st=System.getProperty("user.dir");
			OR1=M_GenericMethods.GI().loadORConfig(st+File.separator+"Config.properties");
			M_GenericMethods.GI().loadOR("MobileAppElements.properties");
			}catch(Exception e){
			throw e;
		}
	    }
	
	
	@BeforeMethod
	public void fn_MobileLogin() throws Exception{
		try{
			MobileLoginPage.class.newInstance().fn_MobileLoginWithHotelID(OR1.getProperty("HotelID_M"), OR1.getProperty("Username_M"), OR1.getProperty("Password_M"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
	@Test(description="Verify that two night single reservation is created and user get checked-in on APP.")
	public void fn_Make2NightSingleReservation() throws Throwable{
		try{
			Thread.sleep(30000);
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
		    HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
		    Thread.sleep(15000);
		    String title=M_GenericMethods.GI().driver.getTitle();
		    VerifyUtils.VU().fn_AsserEquals(title, HM.get("Home_Title"));
		    MobileHomePage MHP=new MobileHomePage();
		    MHP.fn_ClickOnReserveIcon();
		  //  MHP.fn_ClickOnGotItButton();
			Thread.sleep(6000);
			VerifyUtils.VU().fn_AsserEquals(M_GenericMethods.GI().driver.getTitle(), HM.get("SelectRoom_Title"));
			SelectRoomPage.class.newInstance().fn_SelectRoomAndClickContinue();
			Thread.sleep(7000);
			VerifyUtils.VU().fn_AsserEquals(M_GenericMethods.GI().driver.getTitle(), HM.get("StayDetails_Title"));
			String fname=M_GenericMethods.GI().generateRandomString();
			StayDetailsPage.class.newInstance().fn_FillGuestDetailsAndConfirm(fname, "jadhav");
			Thread.sleep(7000);
			SingleEditPage.class.newInstance().fn_ClickOnCheckIN();
			Thread.sleep(7000);
			VerifyUtils.VU().fn_AsserEquals(M_GenericMethods.GI().driver.getTitle(), HM.get("RoomAssign_Title"));
			RoomAssignPage.class.newInstance().fn_SelectRoomAndClickContinue();
			Thread.sleep(7000);
			VerifyUtils.VU().fn_AsserEquals(M_GenericMethods.GI().driver.getTitle(), HM.get("GuestCheckIn_Title"));
			GuestCheckInPage.class.newInstance().fn_SelectGuestAndClickCheckInSelected();
			Thread.sleep(7000);
			VerifyUtils.VU().fn_AsserEquals(M_GenericMethods.GI().driver.getTitle(), HM.get("CheckInCard_Title"));
			CheckInCardPage.class.newInstance().fn_VerifyPrintButtonAndClickBackToCreateReservation();
			Thread.sleep(7000);
			MenuBar menu=new MenuBar();
		    menu.fn_ClickTodaysCheckIn();
			//Thread.sleep(5000);
			//MHP.fn_ClickOnGotItButton();
			Thread.sleep(7000);
			String expfname=CheckInListPage.class.newInstance().fn_SearchCheckedInReservation(fname);
			VerifyUtils.VU().fn_AssertContains(expfname, fname);
			Thread.sleep(7000);
			menu.fn_ClickOnHome();
			Thread.sleep(7000);
		}catch(Throwable e){
			M_GenericMethods.GI().getscreenshot("fn_Make2NightSingleReservation");
			throw e;
		}
	    }
	
	
	//@Test(priority=1)
	public void fn_Make2nightGroupReservation() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
		    HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
		    Thread.sleep(5000);
		    String title=M_GenericMethods.GI().driver.getTitle();
		    VerifyUtils.VU().fn_AsserEquals(title, HM.get("Home_Title"));
		    MobileHomePage MHP=new MobileHomePage();
		    MHP.fn_ClickOnReserveIcon();

		}catch(Throwable e){
			throw e;
		}
	}
	
	
//	@Test(priority=2)
	public void fn_Make2NightReservationWithTA() throws Throwable{
		try{
			String title=M_GenericMethods.GI().driver.getTitle();
			VerifyUtils.VU().fn_AsserEquals(title, HM.get("Home_Title"));
			MobileHomePage MHP=new MobileHomePage();
			MHP.fn_ClickOnReserveIcon();
			
		}catch(Throwable e){
			throw e;
		}
	}
	
	
	@AfterClass
	public void fn_Close() throws Exception{
		try{
			M_GenericMethods.GI().driver.quit();
		}catch(Exception e){
			throw e;
		}
	    } 
	
	
	
	
	
	
	
	
	
}
