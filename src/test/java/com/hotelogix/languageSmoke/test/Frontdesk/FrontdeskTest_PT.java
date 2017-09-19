package com.hotelogix.languageSmoke.test.Frontdesk;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;


import com.hotelogix.languageSmoke.Console.RegisteredTravelAgent.ListOfRegisteredTAConsole;

import com.hotelogix.languageSmoke.Frontdesk.CashCounterPage;
import com.hotelogix.languageSmoke.Frontdesk.ContinueTrialPage;
import com.hotelogix.languageSmoke.Frontdesk.FrontdeskLandingPage;
import com.hotelogix.languageSmoke.Frontdesk.GroupReservationPage;
import com.hotelogix.languageSmoke.Frontdesk.SingleReservationPage;
import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.RoomManager.Rooms.AddARoomPage;
import com.hotelogix.languageSmoke.RoomManager.Rooms.RoomsListLandingPage;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;
import com.hotelogix.languageSmoke.test.Admin.AdminTest_PT;

public class FrontdeskTest_PT {

	private Properties OR1;
	private HashMap<String,String> HM;
	private String path="D:\\SpanishSmoke\\LanguagesAutomation\\TestData\\LanguagesTestData.xlsx";
	private String Sheet_P="Frontdesk_SZ_Portuguese";
	
	
	
	@BeforeClass
	public void fn_LoadOR() throws Exception{
		String st=System.getProperty("user.dir");
		OR1=GenericMethods.GI().loadOR(st+File.separator+"Config.properties");
		GenericMethods.GI().fn_loadpro();
	}
	
	@BeforeMethod
	public void fn_Login() throws Exception{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_P, mtdname);
			GenericMethods.GI().fn_LaunchBrowser("FF", OR1.getProperty("URL_Frontdesk_SZ"));
			LoginClass.class.newInstance().fn_LoginHotel(OR1.getProperty("HotelID_Frontdesk_SZ"), OR1.getProperty("UserName_Frontdesk_SZ"), OR1.getProperty("Password_Frontdesk_SZ"), "111111");
			ContinueTrialPage.class.newInstance().fn_CountinueWithTrail();
			CashCounterPage.class.newInstance().fn_SelelctCounter(HM.get("Counter_DD"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	//@Test(description="Make 2Night and 2 Room reservation using single and group link with seasonal rate. ")
	public void fn_Make2RoomAnd2NightReservation() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_P, mtdname);
			
		   FrontdeskLandingPage FLP=new FrontdeskLandingPage();
		   FLP.fn_ClickCancelandCurrentLink();
	       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
	       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
	       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
	       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
	       AddARoomPage.class.newInstance().fn_AddRoomWithSaveAndDuplicate();
	       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
	       GenericMethods.GI().driver.navigate().refresh();
	       FLP.fn_ClickCancelandCurrentLink();
	       Thread.sleep(3000);
	       FrontdeskLandingPage.class.newInstance().fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "4");
	       String firstname=GenericMethods.GI().generateRandomString();
	       FLP.fn_FillQuickReservationForm("Seasonal Rate", "1", "Mr.", firstname, "F_FrontdeskLandingPage_Reserve_BT");
	       FLP.fn_VerifyCreatedReservation(firstname, HM.get("ReservationStatus_TX"));
	       Thread.sleep(2000);
	       GenericMethods.GI().driver.navigate().refresh();
	       FLP.fn_ClickCancelandCurrentLink();
	       Thread.sleep(3000);
	       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
	       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Single_LK");
	       String fname=GenericMethods.GI().generateRandomString();
	       SingleReservationPage.class.newInstance().fn_FillDataInSingleReservationPage(fname);
	       FLP.fn_VerifyCreatedReservation(fname, HM.get("ReservationStatus_TX"));
	       Thread.sleep(2000);
	       GenericMethods.GI().driver.navigate().refresh();
	       FLP.fn_ClickCancelandCurrentLink();
	       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
	       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Group_LK");
	       String Gfname=GenericMethods.GI().generateRandomString();
	       GroupReservationPage.class.newInstance().fn_FillDetailsForGroupReservation(Gfname);
	       FLP.fn_VerifyCreatedReservation(Gfname, HM.get("ReservationStatus_TX"));
	       
		}catch(Throwable e){
			throw e;
		}
	   }
	
	//@Test(priority=1,description="Reservation made successfully via travel agent in frontdesk.")
	public void fn_Make1RoomReservationWithTravelAgentLink() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
		   HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_P, mtdname);
		   FrontdeskLandingPage FLP=new FrontdeskLandingPage();
	       FLP.fn_ClickCancelandCurrentLink();
	       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
	       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
	       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
	       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
	       AddARoomPage.class.newInstance().fn_AddRoomWithSaveAndDuplicate();
	       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_Console_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Console_Link"));
	       String TAname=GenericMethods.GI().generateRandomString();
	       ListOfRegisteredTAConsole TAL= new ListOfRegisteredTAConsole();
	       TAL.fn_CheckAndCreateTravelAgent(TAname, HM.get("NoEntryFound_TX"));  
	       Thread.sleep(3000);
	       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
	       GenericMethods.GI().driver.navigate().refresh();
	       FLP.fn_ClickCancelandCurrentLink();
	       Thread.sleep(3000);
	       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
	       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Agent_LK");
	       String fname=GenericMethods.GI().generateRandomString();
	       Thread.sleep(2000);
	       GroupReservationPage.class.newInstance().fn_FillDetailsForGroupReservation(TAname,fname);
	       FLP.fn_VerifyCreatedReservation(TAL.TAname, HM.get("ReservationStatus_TX"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	@Test(priority=2,description="Clicked on Restaurant link and verifyed.")
	public void fn_ClickAndVerifyRestaurantLink() throws Exception{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_P, mtdname);
			FrontdeskLandingPage FLP=new FrontdeskLandingPage();
			FLP.fn_ClickCancelandCurrentLink();
			FLP.fn_ClickRestaurantLink();
			GenericMethods.GI().switchToWindowHandle(HM.get("Restaurant_Title"));
			VerifyUtils.VU().fn_AssertContains(GenericMethods.GI().driver.getTitle(),HM.get("Restaurant_Title"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	
	
	
	
	
	public void fn_Close() throws Exception{
		try{
			
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	
}