package com.hotelogix.languageSmoke.test.Admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.BaseUtils.BasePage;
import com.hotelogix.languageSmoke.CommonClasses.AttachPackage;
import com.hotelogix.languageSmoke.CommonClasses.PackageDetail;
import com.hotelogix.languageSmoke.Frontdesk.CashCounterPage;
import com.hotelogix.languageSmoke.Frontdesk.ContinueTrialPage;
import com.hotelogix.languageSmoke.Frontdesk.FrontdeskLandingPage;
import com.hotelogix.languageSmoke.Frontdesk.ViewDetailsPage;
import com.hotelogix.languageSmoke.General.DefaultSettings.DefaultSettingsPage;
import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.PriceManager.AddOnsInclusions.AddAddOnsPage;
import com.hotelogix.languageSmoke.PriceManager.AddOnsInclusions.AddOnsListLandingPage;
import com.hotelogix.languageSmoke.PriceManager.CorporatePackages.ListOfCorporatePackages;
import com.hotelogix.languageSmoke.PriceManager.CorporatePackages.ListOfRegisteredCorporates;
import com.hotelogix.languageSmoke.PriceManager.FrontdeskPackages.ListOfFrontdeskPackages;
import com.hotelogix.languageSmoke.PriceManager.PackageMaster.AddAPackage;
import com.hotelogix.languageSmoke.PriceManager.PackageMaster.AddInclusions;
import com.hotelogix.languageSmoke.PriceManager.PackageMaster.ListOfPackagesInPackageMaster;
import com.hotelogix.languageSmoke.PriceManager.TAPackages.ListOfRegisteredTravelAgents;
import com.hotelogix.languageSmoke.PriceManager.TAPackages.ListOfTAPackages;
import com.hotelogix.languageSmoke.PriceManager.WebPackages.ListOfWebPackages;
import com.hotelogix.languageSmoke.RoomManager.Amenities.AddAmenity;
import com.hotelogix.languageSmoke.RoomManager.Amenities.AmenitiesListLandingPage;
import com.hotelogix.languageSmoke.RoomManager.RoomTaxes.AddRoomTax;
import com.hotelogix.languageSmoke.RoomManager.RoomTaxes.RoomTaxListPage;
import com.hotelogix.languageSmoke.RoomManager.RoomTypes.AddRoomType;
import com.hotelogix.languageSmoke.RoomManager.RoomTypes.EditRoomType;
import com.hotelogix.languageSmoke.RoomManager.RoomTypes.RoomTypesLandingPage;
import com.hotelogix.languageSmoke.RoomManager.Rooms.AddARoomPage;
import com.hotelogix.languageSmoke.RoomManager.Rooms.AddMultipleRooms;
import com.hotelogix.languageSmoke.RoomManager.Rooms.RoomsListLandingPage;
import com.hotelogix.languageSmoke.Web.WebAddMoreRoomPage;
import com.hotelogix.languageSmoke.Web.WebConfirmReservationPage;
import com.hotelogix.languageSmoke.Web.WebConfirmReservationPrintPage;
import com.hotelogix.languageSmoke.Web.WebReservationHomePage;
import com.hotelogix.languageSmoke.Web.WebSelectRoomPage;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class AdminTest_PT {

	private HashMap<String ,String> HM;
	private String sheet_P="Admin_Portuguese";
	//private String sheet_S="Admin_Spanish";
	//private String sheet_G="Admin_German";
    private String F_Properties_P="Frontdesk_PT.properties";
    private String F_Properties_S="Frontdesk_SP.properties";
    
    
    
    
	private String A_Properties_S="Admin_SP.properties";
	private String A_Properties_P="Admin_PT.properties";
	private String A_Properties_G="Admin_GM.properties";
	
	
	private Properties OR;
	private String configfile="Config.properties";                          

	private String Path="D://LanguageTest//LanguageAutomation//TestData//LanguagesTestData.xlsx";

	
	
	@BeforeClass
	public void fn_Beforeclass() throws Exception{
		String sys=System.getProperty("user.dir");
		OR=GenericMethods.GI().loadORConfig(sys+File.separator+configfile);
		GenericMethods.GI().fn_loadpro(F_Properties_P,A_Properties_P);
		
	}
	
	
	@BeforeMethod
	public void Login() throws Exception{
		try{
			GenericMethods.GI().fn_LaunchBrowser("FF", OR.getProperty("URL_Admin_SZ"));
			new LoginClass().fn_LoginHotel(OR.getProperty("HotelID_Admin_SZ_PT"), OR.getProperty("UserName_Admin_SZ_PT"), OR.getProperty("Password_Admin_SZ_PT"));
		}catch(Exception e){
			throw e;
		}
	    }
	

	@Test(priority=1,description="User gets redirected to homepage of Admine Console after login.")
	public void fn_verifyAdmineConsoleSuccessfulLogin() throws Exception{
		try{
			String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
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
//			HMM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname);
//			HM=HMM.get(methodname);
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
			BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_Amenities"));			
		    AmenitiesListLandingPage ALP=new AmenitiesListLandingPage();
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
		    RTLP.fn_clkEdit();
		    EditRoomType ERT=new EditRoomType();
		    ArrayList<String> arr1=ERT.fn_getAmenities();
		    VerifyUtils.VU().fn_AssertContainsInArray(arr1, AA.amenityName);		    		    

		}catch(Exception e){
			throw e;
		}
	    }
	
	
	@Test(priority=3,description="Added Room is displayed on 'Rooms List' page with status as active(green tick)")
	public void fn_verifyAdditionOfRoom() throws Throwable{
	try{
		String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
		HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_Rooms"));
        RoomsListLandingPage RLP=new RoomsListLandingPage();
        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("RoomsList_Title"));
        RLP.fn_clkAddARoom();
        AddARoomPage ARP=new AddARoomPage();
        ARP.fn_fillAddRoomDetails();
        String text=RLP.fn_verifyMsg();
        VerifyUtils.VU().fn_AsserEquals(text,HM.get("Message_Text1")+'"'+ARP.roomName+'"'+HM.get("Message_Text2") );
        BasePage BP=new BasePage();
		BP.fn_viewAll();
		ArrayList<String> l1=BP.fn_GetAddedFields();
	    VerifyUtils.VU().fn_AssertContainsInArray(l1,ARP.roomName);
	}catch(Throwable e){
		throw e;
	}
	}
	
	
	@Test(priority=4,description="On clicking 'Save and Duplicate' button on 'Add/Edit a Room',all the rooms of the same room type are displayed in ")
	public void fn_verifySaveAndDuplicateRoomBtn() throws Throwable{
		try{
		String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
		HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_Rooms"));
		RoomsListLandingPage RLP=new RoomsListLandingPage();
        RLP.fn_clkAddARoom();
        AddARoomPage ARP=new AddARoomPage();
        ARP.fn_fillMultipleRoomDetails();
        String text=RLP.fn_verifyMsg();
        VerifyUtils.VU().fn_AsserEquals(text,HM.get("Message_Text1")+'"'+ARP.room1+'"'+HM.get("Message_Text2") );
		}catch(Throwable e){
			throw e;
		}
	}
	
	
	@Test(priority=5,description="Creation of room tax and attaching it to a room type.")
	public void fn_verifyRoomTaxSelectionInRoomType() throws Throwable{
		try{
		String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
		HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_RoomTax"));
        RoomTaxListPage RTP=new RoomTaxListPage();
        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("RoomTaxList_Title"));
        RTP.fn_clkAddATax();
        AddRoomTax ART=new AddRoomTax();
        ART.fn_addRoomTaxDetails("2");
        String str=RTP.fn_verifyMsg();
        VerifyUtils.VU().fn_AssertContains(str, ART.taxTitle);
        BasePage.AHP().fn_viewAll();
        ArrayList<String> arr=BasePage.AHP().fn_GetAddedFields();
        VerifyUtils.VU().fn_AssertContainsInArray(arr, ART.taxTitle);
        RTP.fn_verifyStatus(ART.taxTitle,HM.get("Status_src"));
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_RoomsManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_RoomTypes"));
        RoomTypesLandingPage RTLP=new RoomTypesLandingPage();
        Assert.assertEquals(GenericMethods.GI().driver.getTitle(), HM.get("RoomTypesList_Title"));
        RTLP.fn_clkAddRoomType();
        AddRoomType ARTP=new AddRoomType();
        ArrayList<String> arr1=ARTP.fn_getTaxList();
        VerifyUtils.VU().fn_AssertContainsInArray(arr1, ART.taxTitle);
        ARTP.fn_clkRoomTypeListLink();
        RTLP.fn_clkEdit();
        EditRoomType ERT=new EditRoomType();
        String roomType=ERT.fn_attachRoomTax(ART.taxTitle);
        Thread.sleep(5000);
        String text=RTLP.fn_getMessageText();
        VerifyUtils.VU().fn_AssertContains(text, roomType);
		}catch(Throwable e){
			throw e;
		}
	}
	
	
	
	@Test(priority=6,description="Creation of ADD-ONS(INCLUSIONS).It gets reflected in 'Add/Edit Package' page.")
	public void fn_verifyAdditionOfAddOns() throws Throwable{
		try{
		String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
		HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_AddOns"));
        AddOnsListLandingPage AOP=new AddOnsListLandingPage();
        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AddOnsList_Title"));
        AOP.fn_clkAddAddOnsLink();
        AddAddOnsPage AAP=new AddAddOnsPage();
        AAP.fn_addAddOnDetails();
        String text=AOP.fn_verifyMesssage();
        VerifyUtils.VU().fn_AssertContains(text, AAP.addOnName);
        BasePage.AHP().fn_viewAll();
        ArrayList<String> l1=AOP.fn_getAddOnsList(AAP.addOnName,HM.get("Status_src"));
        VerifyUtils.VU().fn_AssertContainsInArray(l1, AAP.addOnName);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
        LOPM.fn_clkAddAPackageLnk();
        AddAPackage APG=new AddAPackage();
        String a=GenericMethods.GI().GetCurrentWindowID();
        APG.fn_clkAddInclLink();
        AddInclusions AI=new AddInclusions();
        GenericMethods.GI().windowHandle(a);        
        ArrayList<String> l2= AI.fn_getInclList();
        VerifyUtils.VU().fn_AssertContainsInArray(l2, AAP.addOnName);
        GenericMethods.GI().driver.close();
        GenericMethods.GI().Switch_Parent_Window(a);
		}catch(Throwable e){
			throw e;
		}                
	}
	
	
	@Test(priority=7,description="Creation of package in Package Master and attaching an Add-on to it.")
	public void fn_verifyAddAPackageWithInclusion() throws Throwable{
		try{
		
		String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
		HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
        LOPM.fn_clkAddAPackageLnk();
        AddAPackage AAP=new AddAPackage();
        AAP.fn_addPackageDetails("1");
        AAP.fn_editUpcharge("150.00");
        String a=GenericMethods.GI().GetCurrentWindowID();
        AAP.fn_clkAddInclLink();
        AddInclusions AI=new AddInclusions();
        GenericMethods.GI().windowHandle(a);
        Thread.sleep(5000);
        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AddInclusion_Title"));
        String incl= AI.fn_addInclusion();
        GenericMethods.GI().Switch_Parent_Window(a);
        ArrayList<String> l1=AAP.fn_getAddedInclList();
        VerifyUtils.VU().fn_AssertContainsInArray(l1, incl.split("\n")[0]);
        AAP.fn_clkSaveBtn();
        BasePage.AHP().fn_viewAll();
        ArrayList<String> l2=LOPM.fn_getPackageList(AAP.pkgName, HM.get("Status_src"));
        VerifyUtils.VU().fn_AssertContainsInArray(l2, AAP.pkgName);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_FrontdeskPackage"));
        ListOfFrontdeskPackages LOFW=new ListOfFrontdeskPackages();
        String b=GenericMethods.GI().GetCurrentWindowID();
        BasePage.AHP().fn_clkAttachPkgLink();
        AttachPackage AP=new AttachPackage();
        GenericMethods.GI().windowHandle(b);
        ArrayList<String> l3=AP.fn_searchPkg();
        VerifyUtils.VU().fn_AssertContainsInArray(l3, AAP.pkgName);
        GenericMethods.GI().Switch_Parent_Window(b);
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_WebPackage"));
        ListOfWebPackages LOWP=new ListOfWebPackages();
        BasePage.AHP().fn_clkAttachPkgLink();
        GenericMethods.GI().switchToWindowHandle(HM.get("AttachPkg_Title"));
        ArrayList<String> l4=AP.fn_searchPkg();
        VerifyUtils.VU().fn_AssertContainsInArray(l4, AAP.pkgName);
        GenericMethods.GI().switchToWindowHandle(HM.get("WebPkg_Title"));
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_CorporatePackage"));
        ListOfRegisteredCorporates LORC=new ListOfRegisteredCorporates();
        LORC.fn_chkCorporate(HM.get("NoEntries_Text"));
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddViewPackage_Link"));
        ListOfCorporatePackages LOCP=new ListOfCorporatePackages();
        BasePage.AHP().fn_clkAttachPkgLink();
        GenericMethods.GI().switchToWindowHandle(HM.get("AttachPkg_Title"));
        ArrayList<String> l5=AP.fn_searchPkg();
        VerifyUtils.VU().fn_AssertContainsInArray(l5, AAP.pkgName);
        GenericMethods.GI().switchToWindowHandle(HM.get("CorpPkg_Title"));
        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_TravelAgentPackage"));
        ListOfRegisteredTravelAgents LORT=new ListOfRegisteredTravelAgents();
        LORT.fn_chkTravelAgent(HM.get("NoEntries_Text"));
        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddViewPackage_Link"));
        ListOfTAPackages LTAP=new ListOfTAPackages();
        BasePage.AHP().fn_clkAttachPkgLink();
        GenericMethods.GI().switchToWindowHandle(HM.get("AttachPkg_Title"));
        ArrayList<String> l6=AP.fn_searchPkg();
        VerifyUtils.VU().fn_AssertContainsInArray(l6, AAP.pkgName);
        GenericMethods.GI().switchToWindowHandle(HM.get("TAPkg_Title"));
		}catch(Throwable e){
			throw e;
		}
               
	}
	
	
	
	        @Test(priority=8,description="Attaching  master package to Frontdesk Packages.This attached package is then configured and activated forever.")
			public void fn_verifyPkgAttachmentToFrontdesk() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
		        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
		        LOPM.fn_clkAddAPackageLnk();
		        AddAPackage AAP=new AddAPackage();
		        String pkgName=AAP.fn_addPackageDetails("1");
		        AAP.fn_clkSaveBtn();
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_FrontdeskPackage"));
		        ListOfFrontdeskPackages LOFP=new ListOfFrontdeskPackages();
		        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("FrontdeskPackages_Title"));
		        BasePage.AHP().fn_clkAttachPkgLink();
		        AttachPackage AP=new AttachPackage();
		        GenericMethods.GI().switchToWindowHandle(HM.get("AttachPackage_Title"));
		        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AttachPackage_Title"));
		        AP.fn_getAttachedPkgName(pkgName);
		        GenericMethods.GI().switchToWindowHandle(HM.get("FrontdeskPackages_Title"));
		        String text=LOFP.fn_getMessageText();
		        VerifyUtils.VU().fn_AsserEquals(text, HM.get("AttachPackage_Msg"));
		        BasePage.AHP().fn_viewAll();
		        ArrayList<String> arr=BasePage.AHP().fn_GetPkg();
		        VerifyUtils.VU().fn_AssertContainsInArray(arr, pkgName);
		        LOFP.fn_verifyPkgStatus(pkgName, HM.get("Status_src"));
		        LOFP.fn_confgrAttachedPkg(pkgName);
		        PackageDetail PD=new PackageDetail();
		        PD.fn_clkSaveBtn();
		        String actLnk=LOFP.fn_getActivationDateLink(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(actLnk, HM.get("AddActivation_Link"));
		        LOFP.fn_clkAddActiLink(pkgName);
		        GenericMethods.GI().switchToWindowHandle(HM.get("AddActivationDate_Title"));
		        Thread.sleep(4000);
		        String msg=BasePage.AHP().fn_addActivationDate();
		        VerifyUtils.VU().fn_AsserEquals(msg, HM.get("Message_Text1")+"\n"+" "+HM.get("Message_Text2"));
		        GenericMethods.GI().switchToWindowHandle(HM.get("FrontdeskPackages_Title"));
		        Thread.sleep(4000);
		        String actForev=LOFP.fn_getActivatedForeverText(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(actForev, HM.get("ActivatedForever_Text"));
				}catch(Throwable e){
					throw e;
				}
			}
			
	        
	        @Test(priority=9,description="Navigate to Web Console by clicking 'Web Reservation' link on frontdesk, and create a web reservation.Verify rates and taxes posted for booking on frontdesk.")
			public void fn_createWebReservAndVerifyRatesOnFD() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheet_P, methodname);
				GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AdminHomePage_Frontdesk_Link"));
				GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
				ContinueTrialPage CTP=new ContinueTrialPage();
				CTP.fn_CountinueWithTrail();
				Thread.sleep(4000);
                CashCounterPage CCP=new CashCounterPage();
				CCP.fn_SelelctCounter(HM.get("CashCounter"));
				Thread.sleep(4000);
                FrontdeskLandingPage FLP=new FrontdeskLandingPage();
                FLP.fn_clkCancelBtn();
                GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_WebReservation_Link"));
                Thread.sleep(4000);
                GenericMethods.GI().switchToWindowHandle(HM.get("WebConsole_Title"));
                WebReservationHomePage WRHP=new WebReservationHomePage();
                String text=WRHP.fn_getPageHeader();
                VerifyUtils.VU().fn_AsserEquals(text, HM.get("WebReservHomePage_Header"));
                WRHP.fn_checkAvailabilty();
                Thread.sleep(4000);
                WebSelectRoomPage WSRP=new WebSelectRoomPage();
                String header=WSRP.fn_getPageHeader();
                VerifyUtils.VU().fn_AsserEquals(header, HM.get("WebSelectRoomPage_Header"));
                GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebSelectRoomPage_Select_BTN"));
                Thread.sleep(4000);
                WebAddMoreRoomPage WAMRP=new WebAddMoreRoomPage();
                String header1=WAMRP.fn_getPageHeader();
                VerifyUtils.VU().fn_AsserEquals(header1, HM.get("WebAddMoreRoomPage_Header"));
                GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_WebAddMoreRoomPage_Confirm_BTN"));
                Thread.sleep(4000);
                WebConfirmReservationPage WCRP=new WebConfirmReservationPage();
                String header2=WCRP.fn_getPageHeader();
                VerifyUtils.VU().fn_AsserEquals(header2, HM.get("WebConfrimReservPage_Header"));
                WCRP.fn_ConfirmBooking();
                Thread.sleep(4000);
                WebConfirmReservationPrintPage WCRPP=new WebConfirmReservationPrintPage();
                String header3=WCRPP.fn_getPageHeader();
                VerifyUtils.VU().fn_AsserEquals(header3, HM.get("WebConfirmReservPrintPage_Header"));
                String reservID=WCRPP.fn_getReservID();
                ArrayList<String> al1=WCRPP.fn_getAmtDetails();
                GenericMethods.GI().driver.close();
                GenericMethods.GI().switchToWindowHandle(HM.get("Frontdesk_Title"));
                GenericMethods.GI().driver.navigate().refresh();
                Thread.sleep(5000);
                FLP.fn_clkCancelBtn();
                FLP.fn_searchReservByID(reservID.split(" ")[3].trim());
                GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("F_FrontdeskLandingPage_Record_Link"));
                Thread.sleep(6000);
                ViewDetailsPage VDP=new ViewDetailsPage();
                ArrayList<String> al2=VDP.fn_getAmtDetails();
                VerifyUtils.VU().fn_assertArrayList(al1,al2);
				}catch(Throwable e){
					throw e;
				}
			
			}
	        
			/*
			 * 
			@Test(priority=9,description="Attaching a master package to Web Packages.This attached package is then configured and activated forever.")
			public void fn_verifyPkgAttachmentToWeb() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
		        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
		        LOPM.fn_clkAddAPackageLnk();
		        AddAPackage AAP=new AddAPackage();
		        String pkgName=AAP.fn_addPackageDetails("1");
		        AAP.fn_clkSaveBtn();
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_WebPackage"));
		        ListOfWebPackages LOWP=new ListOfWebPackages();
				VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("WebPackages_Title"));
		        BasePage.AHP().fn_clkAttachPkgLink();
		        AttachPackage AP=new AttachPackage();
		        GenericMethods.GI().switchToWindowHandle("Anexar pacote");
		        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("AttachPackage_Title"));
		        AP.fn_getAttachedPkgName(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Internet)");
		        String text=LOWP.fn_getMessageText();
		        VerifyUtils.VU().fn_AsserEquals(text, HM.get("AttachPackage_Msg"));
		        BasePage.AHP().fn_viewAll();
		        ArrayList<String> arr=BasePage.AHP().fn_GetPkg();
		        VerifyUtils.VU().fn_AssertContainsInArray(arr, pkgName);
		        LOWP.fn_verifyPkgStatus(pkgName, HM.get("Status_src"));
		        LOWP.fn_confgrAttachedPkg(pkgName);
		        PackageDetail PD=new PackageDetail();
		        PD.fn_clkSaveBtn();
		        String actLnk=LOWP.fn_getActivationDateLink(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(actLnk, HM.get("AddActivation_Link"));
		        LOWP.fn_clkAddActiLink(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Adicionar data de ativação");
		        String msg=BasePage.AHP().fn_addActivationDate();
		        VerifyUtils.VU().fn_AsserEquals(msg, HM.get("Message_Text1")+"\n"+" "+HM.get("Message_Text2"));
		        Thread.sleep(5000);
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Internet)");
		        String actForev=LOWP.fn_getActivatedForeverText(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(actForev, HM.get("ActivatedForever_Text"));
				}catch(Throwable e){
					throw e;
				}        
			}
			
			
			@Test(priority=10,description="Verify 'Publish to Grid' and 'Save As Grid' functionality for Frontdesk Package.")
			public void fn_verifyPublishToGridAndSaveFrontdeskPkg() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
		        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
		        LOPM.fn_clkAddAPackageLnk();
		        AddAPackage AAP=new AddAPackage();
		        String pkgName=AAP.fn_addPackageDetails("1");
		        AAP.fn_clkSaveBtn();
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"),GenericMethods.GI().getWebElement("A_AdminHomePage_FrontdeskPackage"));
		        ListOfFrontdeskPackages LOFP=new ListOfFrontdeskPackages();
		        BasePage.AHP().fn_clkAttachPkgLink();
		        AttachPackage AP=new AttachPackage();
		        GenericMethods.GI().switchToWindowHandle("Anexar pacote");
		        AP.fn_getAttachedPkgName(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Recepção)");
		        BasePage.AHP().fn_viewAll();
		        LOFP.fn_confgrAttachedPkg(pkgName);
		        PackageDetail PD=new PackageDetail();
		        PD.fn_clkSaveBtn();
		        LOFP.fn_clkAddActiLink(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Adicionar data de ativação");
		        BasePage.AHP().fn_addActivationDate();
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Recepção)");
		        Thread.sleep(4000);
		        LOFP.fn_clkEditLnk(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("EditPackageDetailFD_Title"));
		        String text=PD.fn_clkToGridBtn();
		        VerifyUtils.VU().fn_AsserEquals(text, HM.get("ToGrid_Msg1")+"\n"+" "+HM.get("ToGrid_Msg2"));
		        String sMsg=PD.fn_getSaveMsg();
		        VerifyUtils.VU().fn_AsserEquals(sMsg, HM.get("SaveMsg_Text1")+pkgName+HM.get("SaveMsg_Text2"));
		        String saveGrid=PD.fn_clkSaveAsGridBtn();
		        VerifyUtils.VU().fn_AsserEquals(saveGrid, HM.get("SaveAsGrid_Msg1")+"\n"+HM.get("SaveAsGrid_Msg2"));
		        GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_PackageDetail_ListOfFrontdeskPackage_Link"));
		        String gridPkg=LOFP.fn_getGridPkg(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(gridPkg, pkgName.concat(" [GRID]"));
				}catch(Throwable e){
					throw e;
				}
			}
			
			
			@Test(priority=11,description="Verify 'Publish to Grid' and 'Save As Grid' functionality for Web Package.")
			public void fn_verifyPublishToGridAndSaveWebPkg() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"), GenericMethods.GI().getWebElement("A_AdminHomePage_PackagesMaster"));
		        ListOfPackagesInPackageMaster LOPM=new ListOfPackagesInPackageMaster();
		        LOPM.fn_clkAddAPackageLnk();
		        AddAPackage AAP=new AddAPackage();
		        String pkgName=AAP.fn_addPackageDetails("1");
		        AAP.fn_clkSaveBtn();
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_PriceManager"),GenericMethods.GI().getWebElement("A_AdminHomePage_WebPackage"));
		        ListOfWebPackages LOWP=new ListOfWebPackages();
		        BasePage.AHP().fn_clkAttachPkgLink();
		        AttachPackage AP=new AttachPackage();
		        GenericMethods.GI().switchToWindowHandle("Anexar pacote");
		        AP.fn_getAttachedPkgName(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Internet)");
		        BasePage.AHP().fn_viewAll();
		        LOWP.fn_confgrAttachedPkg(pkgName);
		        PackageDetail PD=new PackageDetail();
		        PD.fn_clkSaveBtn();
		        LOWP.fn_clkAddActiLink(pkgName);
		        GenericMethods.GI().switchToWindowHandle("Adicionar data de ativação");
		        BasePage.AHP().fn_addActivationDate();
		        GenericMethods.GI().switchToWindowHandle("Lista de Pacotes (Internet)");
		        LOWP.fn_clkEditLnk(pkgName);
		        VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("EditPackageDetailWeb_Title"));
		        PD.fn_clkToGridBtn();
				}catch(Throwable e){
					throw e;
				}        
			}
			
			
			
			@Test(priority=12,description="Change and verify Night Audit time,Check-in time,Check-out time,Early Checkout Charge in Default Settings.")
			public void fn_verifySaveChangesInDefaultSettings() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
		        BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_General"), GenericMethods.GI().getWebElement("A_AdminHomePage_DefaultSetting"));    
				DefaultSettingsPage DSP=new DefaultSettingsPage();
				VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("DefaultSettings_Title"));
				DSP.fn_changeNATime("02", "00", "AM", "Próxima data do calendário");
				DSP.fn_changeCheckinTime("12", "00", "AM");
				DSP.fn_changeCheckoutTime("12", "00", "PM");
				DSP.fn_changeEarlycheckoutCharge();
				String policy=DSP.fn_getEarlyCheckoutPolicy();
				VerifyUtils.VU().fn_AssertContains(policy, DSP.i);
				String str=DSP.fn_getSaveMsg();
				VerifyUtils.VU().fn_AsserEquals(str, HM.get("SaveMsg_Text"));
				}catch(Throwable e){
					throw e;
				}
			}
			
			
			
			@Test(priority=13,description="Creation of 'Pay Type' and verify its status.")
			public void fn_verifyAdditionOfPayTypes() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
                BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_General"), GenericMethods.GI().getWebElement("A_AdminHomePage_PayTypes"));
				VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("PayTypes_Title"));
				PayTypesList PTL=new PayTypesList();
				PTL.fn_clkAddPayTypeLnk();
				AddPayType APT =new AddPayType();
				APT.fn_addPayTypeDetails();
				String str=PTL.fn_getMsgText();
				VerifyUtils.VU().fn_AsserEquals(str, HM.get("Message_Text1")+"`"+APT.payTypeTitle+"`"+HM.get("Message_Text2"));
				BasePage.AHP().fn_viewAll();
				ArrayList<String> l1=PTL.fn_getPayType(APT.payTypeTitle,HM.get("Status_src"));
				VerifyUtils.VU().fn_AssertContainsInArray(l1, APT.payTypeTitle);;
				}catch(Throwable e){
					throw e;
				}
			}
			
			
			
			@Test(priority=14,description="Creation of 'Booking Policy' and verify it.")
	        public void fn_verifyAdditionOfBookingPolicy() throws Throwable{
				try{
				String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
				HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
                BasePage.AHP().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("A_AdminHomePage_General"), GenericMethods.GI().getWebElement("A_AdminHomePage_BookingPolicy"));
                VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("BookingPolicy_Title"));
                BookingPolicyList BPL=new BookingPolicyList();
                BPL.fn_clkAddBookingPolicyLnk();
                GenericMethods.GI().switchToWindowHandle("Adicionar uma política de reserva");
                AddBookingPolicy ABP=new AddBookingPolicy();
                ABP.fn_addBookingPolicyDetails();
                GenericMethods.GI().switchToWindowHandle("Apólice de reserva");
                ArrayList<String> arr=BasePage.AHP().fn_GetAddedFields();
                VerifyUtils.VU().fn_AssertContainsInArray(arr, ABP.BPTitle);
				}catch(Throwable e){
					throw e;
				}
			}
	        
	        
	    */
	        
	        
	
	@AfterMethod
	public void fn_close(){
		GenericMethods.GI().driver.quit();
	}
}
