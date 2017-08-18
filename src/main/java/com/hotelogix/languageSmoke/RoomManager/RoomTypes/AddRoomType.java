package com.hotelogix.languageSmoke.RoomManager.RoomTypes;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;
import com.itextpdf.text.List;

public class AddRoomType {

	
	public ArrayList<String> fn_getTaxList() throws Exception{
		try{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.GI().fn_GetListWebElement("A_AddRoomType_CheckBox_Count").size();
		for(int i=1;i<=count;i++){
			String tax=GenericMethods.GI().driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]//td[2]/table//td")).getText();
			arr.add(tax);						
		}		
		return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public void fn_clkRoomTypeListLink() throws Exception{
		try{
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_AddRoomType_RoomTypeList_Link"));
		}catch(Exception e){
			throw e;
		}
	}
	
	
}
