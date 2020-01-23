package com.avactis.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.avactis.qa.base.TestBase;
import com.google.common.collect.Table.Cell;

public class TestUtil extends TestBase{
	public static long page_load_timeout =30;
	public static long implicit_wait=30;

 /*public void switchToFrame() {
	 driver.switchTo().frame("XYZ");
 }if u wanna us this method in setup create object of TestUtil and then call the method whenever necessary*/
	
	
	/*public static String TESTDATA_SHEET_PATH="C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\testdata\\TestData_Avactis.xlsx";
	
	
	static Workbook book;
	static Sheet sheet;
	
   public static Object[][] getTestData(String sheetName) {
	FileInputStream file=null;
			try {
				file=new FileInputStream(TESTDATA_SHEET_PATH);
			} catch(FileNotFoundException e) {
			e.printStackTrace();
             } 
			try {
			book= WorkbookFactory.create(file);
			}catch(InvalidFormatException e) {
		        e.printStackTrace();
            }
			catch(IOException e) {
		        e.printStackTrace();
            }
			sheet=book.getSheet(sheetName);
			Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
			}
			return data;
			
	}*/
}		
	

	
 
