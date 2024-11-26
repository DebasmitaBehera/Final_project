package com.Easy_Purse.S_S.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {


	
	public String getDataFromExcel(String sheet, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream("src/test/resources/TestData/InatMegaMart.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		wb.close();
		return data;
	}

			
			public int getRowcount(String sheetName) throws Throwable {
				FileInputStream fis=new FileInputStream("src/test/resources/TestData/InatMegaMart.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				int rowCount = wb.getSheet(sheetName).getLastRowNum();
				wb.close();
				return rowCount;
						
			}
			public void setDataIntoExcel(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
				FileInputStream fis=new FileInputStream("src/test/resources/TestData/InatMegaMart.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
					wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
					
					FileOutputStream fos=new FileOutputStream("src/test/resources/TestData/InatMegaMart.xlsx");
				wb.write(fos);
				wb.close();
			}
	}


