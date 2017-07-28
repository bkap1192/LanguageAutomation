package LanguagesAutomation.LanguagesAutomation;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.admin.GenericClass.ExcelUtils;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.hotelogix.languageSmoke.admin.GenericClass.VerifyUtils;

public class SpanishLanguage {

	
	private HashMap<String ,String> HM;
	private String sheetname="Spanish";
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
	
	
	
	
	
	@Test
	public void TC_01() throws Exception{
		try{
			String methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
			HM=ExcelUtils.UI().getTestCaseDataMap(Path, sheetname, methodname);
			new LoginClass().fn_LoginHotel(HM.get("Hotel_ID"), HM.get("UserName"), HM.get("Password"));
		    VerifyUtils.VU().fn_AsserEquals(GenericMethods.GI().driver.getTitle(), HM.get(""));
		}catch(Exception e){
			throw e;
			
		}
	}
}
