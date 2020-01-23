package com.avactis.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class ReadExcel {

	public static void main(String[] args) {
		try {
			File src = new File("C:\\Users\\Kalyani\\eclipse-workspace\\avactisproject\\src\\main\\java\\com\\avactis\\qa\\testdata\\TestData_Avactis.xlsx"); 
			FileInputStream fis=new FileInputStream(src);
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
			 XSSFSheet sh1= wb.getSheetAt(0);

		Row row=sh1.getRow(1);
		Cell cell=(Cell) row.getCell(1);
		System.out.println(cell);
		 System.out.println(sh1.getRow(1).getCell(1));

	}catch (Exception e) {
		 
		   System.out.println(e.getMessage());
		
		  }
	}
}
