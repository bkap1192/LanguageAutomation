package com.hotelogix.languageSmoke.PriceManager.FrontdeskPackages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class ListOfFrontdeskPackages {

	
	public String fn_getMessageText() throws Exception{
		try{
		String text=GenericMethods.GI().fn_GetText(GenericMethods.GI().getWebElement("A_ListOfFrontdeskPackages_Message_Text"));
		return text;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_verifyPkgStatus(String PkgName,String status) throws Exception{
		try{
		int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
		for(int i=2;i<=count-2;i++){
    		String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            if(data.contains(PkgName)){
            	String src=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[6]/img")).getAttribute("src");
            	Assert.assertEquals(src.endsWith(status), true);
            	String activation=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/img")).getAttribute("src");
            	Assert.assertEquals(activation.endsWith(status), true);
            	break;            	
            }
		}
		}catch(AssertionError e){
			throw e;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_confgrAttachedPkg(String PkgName) throws Exception{
		try{
		int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
        for(int i=2;i<=count-2;i++){
        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
        	if(data.contains(PkgName)){
        		GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
        		break;
        	}       	
        }
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getActivationDateLink(String PkgName) throws Exception{
		try{
			String str = null;
			int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
	        for(int i=2;i<=count-2;i++){
	        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
	        	if(data.contains(PkgName)){
	        		str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).getText();
	        		break;
	        	}       	
	        }
	        return str;
			}catch(Exception e){
				throw e;
			}
	}
	
	
	public void fn_clkAddActiLink(String PkgName) throws Exception{
		try{
		int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
        for(int i=2;i<=count-2;i++){
        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
        	if(data.contains(PkgName)){
        		GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).click();
        	break;
        	}       	
        }
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_getActivatedForeverText(String PkgName) throws Exception{
		try{
			String str = null;
			int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
	        for(int i=2;i<=count-2;i++){
	        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
	        	if(data.contains(PkgName)){
	        		str=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]")).getText();
	        		break;
	        	}       	
	        }
	        return str;
			}catch(Exception e){
				throw e;
			}
	}
	
	
	
	public void fn_clkEditLnk(String PkgName) throws Exception{		
		try{
			int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
	        for(int i=2;i<=count-2;i++){
	        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
	        	if(data.contains(PkgName)){
	        		GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
	        		break;
	        	}       	
	        }
			}catch(Exception e){
				throw e;
			}
	}
	
	
	public String fn_getGridPkg(String PkgName) throws Exception{
		try{
		String gridPkg=null;
		int count=GenericMethods.GI().fn_GetListWebElement("A_ListOfFrontdeskPackages_TrCount").size();
        for(int i=2;i<=count;i++){
        	String data=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
            if(data.contains(PkgName)){
            	String text=GenericMethods.GI().driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
				String[] lines=text.split("\n");
	   			gridPkg=lines[0];
	   		    break;
            }        
        }
        return gridPkg;
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
