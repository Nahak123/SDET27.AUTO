package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * its developed using apche poi libraries , which used to handle microsoft excel sheet
 * @author Pradeep
 *
 */

public class ExcelUtility {
	/**
	 * its used read the data from excel base on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @throws Throwable 
	 * @returm data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 String data = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		 wb.close();
		return data;
		
		
	}
	/**
	 * its used write the data in excel base on below arguments
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName,int rownum,int cellnum,String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./Data/testscript.xlsx");
		wb.write(fos);
		wb.close();
		
		
		
		
	}
	/**
	 * used to get the last used row number on specified sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int last = sh.getLastRowNum();
		wb.close();
		return last;
		
		
		
	}
	

}
