package com.hotelogix.languageSmoke.RoomManager.RoomTypes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;




public class EditRoomType {

	
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
}
