package com.hotelogix.languageSmoke.admin.GenericClass;

import org.testng.Assert;

public class VerifyUtils {
	
	
	private static VerifyUtils VU;
	
	private VerifyUtils(){
		
	}
	
	public static VerifyUtils VU(){
		if(VU==null){
			return VU=new VerifyUtils();
		}
		return VU;
	   }
	
	
	public void fn_AsserEquals(String actual, String expected){
		try{
			Assert.assertEquals(actual, expected);
		}catch(AssertionError e){
			throw e;
		}
	}
	
	
	

}
