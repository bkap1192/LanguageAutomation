package com.hotelogix.languageSmoke.RoomManager.RoomTypes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.languageSmoke.RoomManager.RoomTaxes.AddRoomTax;
import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;




public class EditRoomType {

	public String roomType;
	
	
	public ArrayList<String> fn_getAmenities() throws Exception{
		try{
		ArrayList<String> arr =new ArrayList<String>();
		Select sel=new Select(GenericMethods.GI().getWebElement("A_EditRoomTypePage_SelectedAmenities_DD"));
		List<WebElement> ele=  sel.getOptions();
		for(WebElement ele1:ele){
			arr.add(ele1.getText());
		}
		return arr;
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public String fn_attachRoomTax(String value) throws Exception{
		try{
		roomType=GenericMethods.GI().getWebElement("A_EditRoomTypePage_RoomTypeName_ED").getAttribute("value");
		int count=GenericMethods.GI().fn_GetListWebElement("A_AddRoomType_CheckBox_Count").size();
        for(int i=1;i<=count;i++){
            String str=GenericMethods.GI().driver.findElement(By.xpath("//td[@class='padingtd']/table/tbody//tr[17]//td[2]//tr["+i+"]//td//table//tr[1]/td")).getText();
            if(str.contains(value)){
            	GenericMethods.GI().driver.findElement(By.xpath("//td[@class='padingtd']/table/tbody//tr[17]//td[2]//tr["+i+"]//td[1]/input")).click();
            	break;
            }                                   
        }
		GenericMethods.GI().fn_Click(GenericMethods.GI().getWebElement("A_EditRoomTypePage_Save_BTN"));		
	return roomType;
		}catch(Exception e){
		throw e;
	}
	}
}
