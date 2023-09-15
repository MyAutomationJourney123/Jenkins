package vtiger.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.helpers.NOP_FallbackServiceProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ElementRepository.HomePage;
import vtiger.ElementRepository.LoginPage;
import vtiger.ElementRepository.NewOrganizationPage;

import vtiger.ElementRepository.OrganizationInfoPage;
import vtiger.ElementRepository.OrganizationPage;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgwithIndustryUsingGU 
{
	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jUtil= new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		WebDriver driver=null;
		
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME=eUtil.readfromExcelFile("Organization", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRYTYPE=eUtil.readfromExcelFile("Organization", 4, 3);
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("internetexplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
		}
	
		wUtil.maximizewindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	
		//Step 2:Login to Application
		
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		
		
		
		//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//driver.findElement(By.id("submitButton")).click();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLnk();
		
		
				//Step 3:Navigate to Organizations Link
	//			driver.findElement(By.linkText("Organizations")).click();
				//driver.findElement(By.partialLinkText("Create Organization...")).click(); - doesnt work
		
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOncreateOrganizationImg();
				
		
		
				//Step 4:Click on Create Organization Look Up Image
				//driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
				//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
		NewOrganizationPage nop=new NewOrganizationPage(driver);
			nop.createNewOrganization(ORGNAME, INDUSTRYTYPE);
		
		
				//Step 5:Create organization with mandatory information
		//		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 6: Select "Chemicals" in drop down industry
			//	WebElement ind=driver.findElement(By.name("industry"));
				//wUtil.handleDropdown(ind, INDUSTRYTYPE);
				
				//Step 7: Save the information
		//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Step 8:Validate the Information
		OrganizationInfoPage oi=new OrganizationInfoPage(driver);
		
				String orgHeader = oi.getOrgHeader();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println("PASS");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
			
		
		hp.logoutApp(driver);
				
				//Step 9:LogOut of App
			/*	WebElement mouseHover=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, mouseHover);
				driver.findElement(By.linkText("Sign Out")).click();
				*/
		
				
				//Step 10:Close the Browser
				Thread.sleep(1000);// IMPORTANT TO GIVE SLEEP - otherwise it throws SocketException
				driver.close();

		
	}

}
