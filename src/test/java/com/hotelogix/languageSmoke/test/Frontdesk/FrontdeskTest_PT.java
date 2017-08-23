package com.hotelogix.languageSmoke.test.Frontdesk;

import java.io.File;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hotelogix.languageSmoke.LoginPage.LoginClass;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class FrontdeskTest_PT {

	private Properties OR1;
	
	
	@BeforeSuite
	public void fn_LoadOR() throws Exception{
		String st=System.getProperty("user.dir");
		OR1=GenericMethods.GI().loadOR(st+File.separator+"Config.properties");
		GenericMethods.GI().fn_loadpro();
	}
	
	@BeforeMethod
	public void fn_Login() throws Exception{
		try{
			GenericMethods.GI().fn_LaunchBrowser("FF", OR1.getProperty("URL_Frontdesk_SZ"));
			new LoginClass().fn_LoginHotel(OR1.getProperty("HotelID_Frontdesk_SZ"), OR1.getProperty("UserName_Frontdesk_SZ"), OR1.getProperty("Password_Frontdesk_SZ"), "111111");
		}catch(Exception e){
			throw e;
		}
	   }
	
	
	@Test
	public void fn_Test(){
		
	}
	
	
	
	
	
	
	
	
}
