package com.hotelogix.languageSmoke.admin.GenericClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	
	private  HashMap<String, String> TDMap;
	private static ExcelUtils EU=null;
	
	private ExcelUtils(){
		
	}
	
	public static ExcelUtils UI(){
		if(EU==null){
			EU=new ExcelUtils();
		}
		return EU;
	}

	
	public  HashMap<String, String> getTestCaseDataMap(String filePath, String sheetName, String TCID) throws IOException{
		 Workbook wBook=getWorkBook(filePath);
		 TDMap=new HashMap<String, String>();
		 Sheet sheetObj=wBook.getSheet(sheetName);
		 int rowNumber=getTDRowNumber(sheetObj, TCID);
		    Row reqRowObj=sheetObj.getRow(rowNumber);
		    int cellCount=reqRowObj.getLastCellNum()-1;
		    for(int i=2; i<=cellCount-1; i+=2){
		    	Cell cellObj=reqRowObj.getCell(i, Row.CREATE_NULL_AS_BLANK);
		    	String dataKey=cellObj.getStringCellValue();
		    	cellObj=reqRowObj.getCell(i+1, Row.CREATE_NULL_AS_BLANK);
		    	String dataValue=cellObj.getStringCellValue();
		    	TDMap.put(dataKey, dataValue);
		    }
			return TDMap;
	        }

	
	public Workbook getWorkBook(String filePath) throws IOException{	
		Workbook wBook=null;
		//String ext=filePath.split("Block.")[1];
		FileInputStream fis=new FileInputStream(filePath);
		//if(ext.equalsIgnoreCase("xlsx")){
			wBook=new XSSFWorkbook(fis);
		//}else{
			//wBook=new HSSFWorkbook(fis);
		//}
		return wBook;
	}
	public int getTDRowNumber(Sheet sheetObj, String TestCaseID){
		int rowCount=sheetObj.getLastRowNum();
		int dataRowNumber=0;
		for(int i=0; i<=rowCount; i++){
			Row rowObj=sheetObj.getRow(i);
			Cell cellObj=rowObj.getCell(0);
			String TCID_cellValue=cellObj.getStringCellValue();
			if(TestCaseID.equalsIgnoreCase(TCID_cellValue)){
				dataRowNumber=i;
				break;
			}
	}
		return dataRowNumber;
	}
}
