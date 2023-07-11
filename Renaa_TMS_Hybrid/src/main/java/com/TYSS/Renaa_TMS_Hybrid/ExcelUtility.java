package com.TYSS.Renaa_TMS_Hybrid;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * 
	 * @param excelPath
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return Excel String value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String excelData(String excelPath, String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook work = WorkbookFactory.create(fis);
		String data = work.getSheet(sheet).getRow(row).getCell(cell).toString();
		work.close();
		return data;
		
	}
	
	public String getExcelValueById(String path, String sheet, String testId, String columnHead) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook work = WorkbookFactory.create(fis);
		Sheet sheetref = work.getSheet(sheet);
		int rowNum=sheetref.getLastRowNum();
		int testRowNum=0;
		
		String actTestID="";
		String actColHeaderName="";
		String data="";
		
		for(int i=0; i<=rowNum; i++) {
			try { actTestID = sheetref.getRow(i).getCell(0).toString();} catch (Exception e) {}

			if(actTestID.equalsIgnoreCase(testId)) {
				break;				
			}
			testRowNum++;
		}
		int testColNum =0;
		int celCountforTest = sheetref.getRow(testRowNum-1).getLastCellNum();
		for(int j=0; j<celCountforTest; j++) {
			try {actColHeaderName =  sheetref.getRow(testRowNum-1).getCell(j).toString(); } catch (Exception e) {}
			if(actColHeaderName.equalsIgnoreCase(columnHead)) {
				break;
			}
			testColNum++;
		}
		try {data =  sheetref.getRow(testRowNum).getCell(testColNum).toString();}catch (Exception e) {}
		return data;
	}
	
	public int  getRowCount(String filePath, String sheetName) throws Throwable {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}
	
	public void setdataToExcel(String filePath, String sheetName , String testId, String columnHeader , String data){
		
	}

}
