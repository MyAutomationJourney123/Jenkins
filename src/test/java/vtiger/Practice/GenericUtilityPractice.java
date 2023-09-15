package vtiger.Practice;

import org.openqa.selenium.WebDriver;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public WebDriver driver;

	public static void main(String[] args) throws Throwable
	{
		/*PropertyFileUtility pUtil= new PropertyFileUtility();
		String browservalue=pUtil.readDataFromPropertyFile("browser");
		System.out.println(browservalue);
		
		ExcelFileUtility  eUtil=new ExcelFileUtility();
		String dataread=eUtil.readfromExcelFile("Organization", 4, 2);
		System.out.println(dataread);
		
		eUtil.writeToExcelFile("Products", 5, 3, "Utilityvalue");
		System.out.println("Value added successfully");
		*/
		
		JavaUtility jUtil=new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		System.out.println(jUtil.getSystemDate());
		
		
		
	}

}
