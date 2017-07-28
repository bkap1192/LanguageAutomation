package com.hotelogix.languageSmoke.genericBaseClass;

import org.openqa.selenium.WebElement;

import com.hotelogix.languageSmoke.admin.GenericClass.GenericMethods;

public class HG {

	
	private static HG GM;
	
    private HG(){
  	  
    }
    
    public static HG GI(){
  	  if(GM==null){
  		 GM= new HG();
  	  }
  	  return GM;
        }
	
	public void fn_NavigateAnyModule(WebElement mouseover, WebElement submodule) throws Exception{
		try{
			GenericMethods.GI().fn_Mouseover(mouseover);
			GenericMethods.GI().fn_Click(submodule);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
}
