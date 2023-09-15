package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{

		//Step 1:Open Document in readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3: Create new sheet/Read from existing sheet
		Sheet sh=wb.createSheet("Products"); //New Sheet
		Sheet sh1=wb.getSheet("Contacts"); //Existing Sheet
		
		//Step 4: Create new row/Read from existing row
		Row r=sh.createRow(0); //New Row in New Sheet
		Row r1=sh1.getRow(3); //Existing row in existing sheet
		
		//Step 4: Create new cell/WRITE to existing cell
	
		// Create cells and insert values in new sheet
		Cell c=r.createCell(0);
		c.setCellValue("TC_ID");
		c=r.createCell(1);
		c.setCellValue("TC_Name");
		
		r=sh.createRow(1);
		c=r.createCell(0);
		c.setCellValue("TC_06");
		c=r.createCell(1);
		c.setCellValue("Create Product");
	
		
		
		// Below code inserts values in 2 cells in existing sheet
		Cell c1= r1.createCell(5);
		c1.setCellValue("Industry Type");
		r1=sh1.getRow(4);
		c1=r1.createCell(5);
		c1.setCellValue("Electronics");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		wb.write(fos);
		System.out.println("Data written successfully");
		
		wb.close();
		
	}

}
