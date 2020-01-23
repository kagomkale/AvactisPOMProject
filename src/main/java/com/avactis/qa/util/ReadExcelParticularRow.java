package com.avactis.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import com.avactis.qa.base.TestBase;

import com.avactis.qa.base.TestBase;
import com.google.common.collect.Table.Cell;

public class ReadExcelParticularRow extends TestBase {
	private static XSSFCell Cell;;
	private static XSSFRow Row;
	//public static String TESTDATA_SHEET_PATH="C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\testdata\\TestData_Avactis.xlsx";

	public static String ReadExcelRow(int RowNum,int ColNum) throws Exception {
		File src = new File("C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\testdata\\TestData_Avactis.xlsx"); 
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh1= wb.getSheetAt(0);
	 try {
		 Cell=sh1.getRow(RowNum).getCell(ColNum);
		 String CellData= Cell.getStringCellValue();
		 return CellData;
	 }catch(Exception e) {
		 return"";
	 }
	
	
	
	/*public static void ReadExcelRow() throws Exception {
			File src = new File("C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\testdata\\TestData_Avactis.xlsx"); 
			FileInputStream fis=new FileInputStream(src);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1= wb.getSheetAt(0);
		/*	 try {
			 Cell=sh1.getRow(RowNum).getCell(ColNum);
			 String CellData= Cell.getStringCellValue();
			 return CellData;*/
		//    System.out.println(sh1.getRow(10).getCell(1).getStringCellValue());
		  //System.out.println(sh1.getRow(11).getCell(1).getStringCellValue());
		    
			 
		
	}



}


/*File src = new File("D:\\Excel file\\RegistrationFom.xlsx"); 
FileInputStream fis=new FileInputStream(src);
 XSSFWorkbook wb=new XSSFWorkbook(fis);
 XSSFSheet sh1= wb.getSheetAt(0);
 System.out.println(sh1.getRow(1).getCell(1).getStringCellValue());*/