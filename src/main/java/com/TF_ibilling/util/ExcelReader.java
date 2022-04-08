package com.TF_ibilling.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	//public static String path;
	public static FileInputStream fis = null;
	public static FileOutputStream fo = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow row = null;
	private static XSSFCell cell = null;

	// Apache poi
	// Apache poi ooxml
	// XSSF is used for 2010 or later version
	// HSSF is used for 2007 or earlier version

	// Constructor to initialize variables
	public static void setExcelReader(String path) {
		
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Method to get row count
	public static int getRowCount(String path,String sheetName) throws IOException {
		
		setExcelReader(path);
		sheet = workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowCount;
		
	}
	
	public static int getCellCount(String path,String sheetName,int rownum) throws IOException {
		setExcelReader(path);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellCount;
	
	}

	// Method to call the value
	public static String getCellData(String path,String sheetName, String colName, int rowNum) {
		setExcelReader(path);
		// For Sheet
		int index = workbook.getSheetIndex(sheetName);
		int col_Num = 0;
		sheet = workbook.getSheetAt(index);

		// For Row
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_Num = i;
			}
		}

		// For Column
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_Num);
		return cell.getStringCellValue();
	}
	public static String getCellDataArray(String path,String sheetName, int rowNum, int colNum) {
		setExcelReader(path);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		String data;
		try {
		DataFormatter formatter = new DataFormatter();
		String cellData = formatter.formatCellValue(cell);
		return cellData;
		}catch(Exception e) {
			data="";
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return data;

		
		}
	public static void setCellData(String path,String sheetName,int rownum,int colnum,String data) throws IOException {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fis.close();
		fo.close();
		}

}
