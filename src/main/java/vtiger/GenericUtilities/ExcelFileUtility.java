package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to define methods to read and write data in Excel
 * @throws Throwable 
 */

public class ExcelFileUtility 
{
/**
 * This method takes the location of cell in excelsheet , reads data and returns it.
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @return
 * @throws Throwable
 */
	
	public String readfromExcelFile(String sheetname,int rownum, int cellnum) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close(); 	
		return data;
		
	}
	
	/**
	 * This method is used to write data to excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws Throwable
	 */
	public void writeToExcelFile(String sheetname, int rownum, int cellnum, String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(value);
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		
		wb.close();
		
	}
	
	
}
