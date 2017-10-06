package com.hotelogix.languageSmoke.admin.GenericClass;

import java.util.ArrayList;

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
	
	public void fn_AssertContains(String actual,String expected){
		try{
		Assert.assertEquals(actual.contains(expected), true);
		}catch(AssertionError e){
			throw e;
		}
	}
	
	public void fn_AssertContainsInArray(ArrayList<String> actual,String expected){
		try{
		Assert.assertEquals(actual.contains(expected), true);
		}catch(AssertionError e){
			throw e;
		}
	}
	
	public void fn_assertArrayList(ArrayList<String> actual,ArrayList<String> expected) throws Exception{
		try{
		Assert.assertEquals(actual, expected);
		}catch(Exception e){
			throw e;
		}
	}
	
}
