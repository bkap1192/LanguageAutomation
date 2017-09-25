package com.hotelogix.languageSmoke.test.Frontdesk;

import java.io.File;
import java.util.HashMap;
import java.util.Properties;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.Console.RegisteredTravelAgent.ListOfRegisteredTAConsole;
import com.hotelogix.languageSmoke.CommonClasses.PackageDetail;
import com.hotelogix.languageSmoke.Frontdesk.CashCounterPage;
import com.hotelogix.languageSmoke.Frontdesk.CheckInCardPage;
import com.hotelogix.languageSmoke.Frontdesk.ContinueTrialPage;
import com.hotelogix.languageSmoke.Frontdesk.FrontdeskLandingPage;
import com.hotelogix.languageSmoke.Frontdesk.GroupReservationPage;
import com.hotelogix.languageSmoke.Frontdesk.SingleReservationPage;
import com.hotelogix.languageSmoke.Frontdesk.ViewDetailsPage;
import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.RoomManager.Rooms.AddARoomPage;
import com.hotelogix.languageSmoke.RoomManager.Rooms.RoomsListLandingPage;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;


public class FrontdeskTest_PT {

	private Properties OR1;
	private HashMap<String,String> HM;
	private String path="D:\\SpanishSmoke\\LanguagesAutomation\\TestData\\LanguagesTestData.xlsx";
	private String Sheet_P="Frontdesk_SZ_Portuguese";
	private String Sheet_S="Frontdesk_Spanish";
	
	private String F_Properties_P="Frontdesk_PT.properties";
	private String A_Properties_P="Admin_PT.properties";
	private String F_Properties_S="Frontdesk_SP.properties";
	private String A_Properties_S="Admin_SP.properties";
	
	

	
	
	@BeforeClass
	public void fn_LoadOR() throws Exception{
		String st=System.getProperty("user.dir");
		OR1=GenericMethods.GI().loadORConfig(st+File.separator+"Config.properties");
		GenericMethods.GI().fn_loadpro(F_Properties_S,A_Properties_S);
	}
	
	@BeforeMethod
	public void fn_Login() throws Exception{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			GenericMethods.GI().fn_LaunchBrowser("FF", OR1.getProperty("URL_Frontdesk_SZ"));
			LoginClass.class.newInstance().fn_LoginHotel(OR1.getProperty("HotelID_Frontdesk_SZ_SP"), OR1.getProperty("UserName_Frontdesk_SZ_SP"), OR1.getProperty("Password_Frontdesk_SZ_SP"), "111111");
			ContinueTrialPage.class.newInstance().fn_CountinueWithTrail();
			CashCounterPage.class.newInstance().fn_SelelctCounter(HM.get("Counter_DD"));
		}catch(Exception e){
			throw e;
		}
	    }



	
	@Test(priority=1,description="Make 2Night and 2 Room reservation using Seasonal Rate.")
	public void fn_Make2RoomAnd2NightReservation() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			
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
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	   }
	
	//@Test(priority=2,description="Make Reservation using Single link in frontdesk.")
	public void fn_MadeReservationWithSingleLink() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			
			 FrontdeskLandingPage FLP=new FrontdeskLandingPage();
			   FLP.fn_ClickCancelandCurrentLink();
		       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
		       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
		       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
		       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
		       AddARoomPage.class.newInstance().fn_fillAddRoomDetails();
		       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
		       GenericMethods.GI().driver.navigate().refresh();
		       FLP.fn_ClickCancelandCurrentLink();
		       Thread.sleep(5000);
		       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "4");
		       String Fname=GenericMethods.GI().generateRandomString();
		       FLP.fn_FillQuickReservationForTA("Seasonal Rate", "1", "Mr.", Fname);
		       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Single_LK");
		       Thread.sleep(2000);
		       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_SingleReservationPage_Reserve_BT"));
		       FLP.fn_VerifyCreatedReservation(Fname, HM.get("ReservationStatus_TX"));
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	   }
	
	
	//@Test(priority=3,description="Make Reservation using Group link in frontdesk.")
	public void fn_MadeReservationWithGroupLink() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			
			 FrontdeskLandingPage FLP=new FrontdeskLandingPage();
			   FLP.fn_ClickCancelandCurrentLink();
		       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
		       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
		       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
		       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
		       AddARoomPage.class.newInstance().fn_fillAddRoomDetails();
		       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
		       Thread.sleep(2000);
		       GenericMethods.GI().driver.navigate().refresh();
		       FLP.fn_ClickCancelandCurrentLink();
		       Thread.sleep(5000);
		       FrontdeskLandingPage.class.newInstance().fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "4");
		       String Gfname=GenericMethods.GI().generateRandomString();
		       FLP.fn_FillQuickReservationForTA("Seasonal Rate", "1", "Mr.", Gfname);
		       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Group_LK");
		       Thread.sleep(2000);
		       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_GroupReservationPage_Reserve_BT"));
		       FLP.fn_VerifyCreatedReservation(Gfname, HM.get("ReservationStatus_TX"));
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	   }
	

	//@Test(priority=4,description="Reservation made successfully via travel agent in frontdesk.")
	public void fn_Make1RoomReservationWithTravelAgentLink() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
		   HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
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
	       Thread.sleep(3000);
	       FLP.fn_ClickCancelandCurrentLink();
	       Thread.sleep(5000);
	       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
	       Thread.sleep(2000);
	       String Fname=GenericMethods.GI().generateRandomString();
	       FLP.fn_FillQuickReservationForTA("Seasonal Rate", "1", "Mr.", Fname);
	       FLP.fn_ClickSingleOrGroupOrAgentLink("F_FrontdeskLandingPage_Agent_LK");
	       Thread.sleep(2000);
	       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_GroupReservationPage_Reserve_BT"));
	       FLP.fn_VerifyCreatedReservation(Fname, HM.get("ReservationStatus_TX"));
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//@Test(priority=5,description="Clicked on Restaurant link and verified restaurant home page.")
	public void fn_ClickAndVerifyRestaurantLink() throws Throwable{
		try{
			String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			FrontdeskLandingPage FLP=new FrontdeskLandingPage();
			FLP.fn_ClickCancelandCurrentLink();
			FLP.fn_ClickRestaurantLink();
			GenericMethods.GI().switchToWindowHandle(HM.get("Restaurant_Title"));
			VerifyUtils.VU().fn_AssertContains(GenericMethods.GI().driver.getTitle(),HM.get("Restaurant_Title"));
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//@Test(priority=6,description="To verified check-in button in quick reservation form with click on close button in Check card window." )
	public void fn_VerifyCheckInButtonInQuickReservationFrom() throws Throwable{
		try{
		  String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
		  HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			
		   FrontdeskLandingPage FLP=new FrontdeskLandingPage();
		   FLP.fn_ClickCancelandCurrentLink();
	       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
	       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
	       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
	       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
	       AddARoomPage.class.newInstance().fn_fillAddRoomDetails();
	       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
	       GenericMethods.GI().driver.navigate().refresh();
	       FLP.fn_ClickCancelandCurrentLink();
	       Thread.sleep(5000);
	       FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "4");
	       String firstname=GenericMethods.GI().generateRandomString();
	       FLP.fn_FillQuickReservationForm("Seasonal Rate", "1", "Mr.", firstname, "F_FrontdeskLandingPage_CheckIn_BT");
	       Thread.sleep(3000);
	       GenericMethods.GI().switchToWindowHandle(HM.get("CheckInCard_Title"));
	       CheckInCardPage.class.newInstance().fn_ClickonCloseButton();
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }
	
	
	//@Test(priority=7,description=" Made reservation using package in frontdesk and verify package rate in view details page." )
	public void fn_SelectPackageinQuickReservationForm() throws Throwable{
		try{
			 String mtdname=Thread.currentThread().getStackTrace()[1].getMethodName();
			  HM=ExcelUtils.UI().getTestCaseDataMap(path, Sheet_S, mtdname);
			  
			  FrontdeskLandingPage FLP=new FrontdeskLandingPage();
			  FLP.fn_ClickCancelandCurrentLink();
		       GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Admin_LK"));
		       GenericMethods.GI().switchToWindowHandle(HM.get("Admin_Title"));
		       BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("F_AdminHomePage_RoomManager_Link"), GenericMethods.GI().getWebElement("F_AdminHomePage_Room_Link"));
		       RoomsListLandingPage.class.newInstance().fn_clkAddARoom();
		       AddARoomPage.class.newInstance().fn_fillAddRoomDetails();
		       GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
			  
			  FLP.fn_ClickCancelandCurrentLink();
			  Thread.sleep(4000);
			  FLP.fn_createFDReserv(GenericMethods.GI().Roomtype, "3", "3");
			  Thread.sleep(2000);
			  FLP.fn_CheckAndCreatePackage(HM);
			  String firstname=GenericMethods.GI().generateRandomString();
			  FLP.fn_FillQuickReservationForm(FLP.OneNightPackage, "1", "Mr.", firstname, "F_FrontdeskLandingPage_Reserve_BT");
	          WebElement we=FLP.fn_GetReservedWebElement(firstname);
			  FLP.fn_RightClick(we);
			  GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_ViewDetails_LK"));
			  String rate= ViewDetailsPage.class.newInstance().fn_GetRate().split(" ")[1];
			  String Rate= rate.replaceFirst(",", "");
			  Assert.assertEquals(Rate.contains(PackageDetail.PackagePrice),true);
		}catch(Throwable e){
			GenericMethods.GI().getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			throw e;
		}
	    }

	
	@AfterMethod
	public void fn_Close() throws Exception{
		try{
			GenericMethods.GI().driver.quit();
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	
}
