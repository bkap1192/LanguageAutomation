package LanguagesAutomation.LanguagesAutomation;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;
import com.hotelogix.languageSmoke.genericBaseClass.HG;

public class PortugueseLanguage {

	private HashMap<String ,String> HM;
	private String sheetname="Portuguese";
	private String Path="TestData//LanguagesTestData.xlsx";
	
	
	@BeforeTest
	public void fn_LounchBrowser() throws Exception{
		try{
			GenericMethods.GI().fn_LaunchBrowser("FF", "http://hotelogix.stayezee.com/admine/login/login/");
		}catch(Exception e){
			throw e;
		}
	}
	
	
	@BeforeMethod
	public void Login() throws Exception{
		try{
		new LoginClass().fn_LoginHotel(GenericMethods.GI().loadOR().getProperty("Hotel_ID"), GenericMethods.GI().loadOR().getProperty("UserName"), GenericMethods.GI().loadOR().getProperty("Password"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	
	@Test
	public void TC_01() throws Exception{
		try{
			String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
			VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get("Adminstrator_Title"));
		}catch(Exception e){
			throw e;
			
		}finally {
			
		}
	    }
	
	
	public void TC_02_03() throws Exception{
		try{
		HG.GI().fn_NavigateAnyModule(GenericMethods.GI().getWebElement("Hotelogix_admin_Homepage_RoomManager_Link"), GenericMethods.GI().getWebElement("Hotelogix_admin_Homepage_Amenities_Link"));
		}catch(Exception e){
			throw e;
		}
	    }
	
	@AfterMethod
	public void fn_close(){
		GenericMethods.GI().driver.close();
	}
}
