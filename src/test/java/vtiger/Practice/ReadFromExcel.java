package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel
{
	public static void main(String[] args) throws Exception 
	{
		//Step 1:Open the document in Java Readable Format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2:Create WorkBook
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step 3:Navigate to Required Sheet
		Sheet sh=wb.getSheet("Contacts");
		
		
		//Step 4:Navigate to required row and cell
		Row r= sh.getRow(1);
		Cell c=r.getCell(1);
		
		//Step 5:Fetch the cell data
		String tcname= c.getStringCellValue();
		System.out.println("Tast Case Name:"+tcname);
		
		/*NOTE THAT IN PROPERTY FILE - IF DATA BEING READ DOESNT EXIST - IT RETURNS NULL
		 * BUT IN EXCEL - IF U READ DATA FROM A BLANK CELL - IT THROWS 
		 JAVA.LANG.NULLPOINTEREXCEPTION AND STOPS EXECUTION ABRUPTLY*/
		r=sh.getRow(4);
		c=r.getCell(4);
		String data=c.getStringCellValue();
		System.out.println("Data is:"+data);
		
		r=sh.getRow(1);
		c=r.getCell(2);
		String lname=c.getStringCellValue();
		System.out.println("Last name is:"+lname);
				
		
		//Step 6: Close workbook
		wb.close();
		
	}

}
