package vtiger.ContactTests;

	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
	import vtiger.ElementRepository.ContactInfoPage;
	import vtiger.ElementRepository.ContactsPage;
	import vtiger.ElementRepository.HomePage;
	import vtiger.ElementRepository.LoginPage;
	import vtiger.ElementRepository.NewContactsPage;
import vtiger.ElementRepository.NewOrganizationPage;
import vtiger.ElementRepository.OrganizationInfoPage;
import vtiger.ElementRepository.OrganizationPage;
import vtiger.GenericUtilities.ExcelFileUtility;
	import vtiger.GenericUtilities.JavaUtility;
	import vtiger.GenericUtilities.PropertyFileUtility;
	import vtiger.GenericUtilities.WebDriverUtility;

	public class CreateContactwithOrganizationTest {
		@Test
		
		public void createContactwithOrgTest() throws Throwable
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
			
			String LNAME=eUtil.readfromExcelFile("Contacts", 4, 2);
			String ORGNAME=eUtil.readfromExcelFile("Contacts", 4, 3);
			
			
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
			/*
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();*/
			LoginPage lp=new LoginPage(driver);
			lp.logintoApp(USERNAME, PASSWORD);
			
			
					
			//Step 3:Navigate to Contacts Link
			//driver.findElement(By.linkText("Contacts")).click();
			
			HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationLnk();
			
			OrganizationPage op=new OrganizationPage(driver);
			op.clickOncreateOrganizationImg();
			
			NewOrganizationPage nop=new NewOrganizationPage(driver);
			nop.createNewOrganization(ORGNAME);
		
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
			
			
			hp.clickContactsLnk();
			Thread.sleep(2000);
			
			//Step 4:Click on Create Contact Look Up Image
			//	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			
			ContactsPage co=new ContactsPage(driver);
			co.clickOncreateContactsImg();
			
			
			
							
			//Step 5:Create Contact with mandatory information and select organization
//			driver.findElement(By.name("firstname")).sendKeys("A");
		//	driver.findElement(By.name("lastname")).sendKeys(LNAME);
			
			NewContactsPage ncp=new NewContactsPage(driver);
			ncp.createNewContact(LNAME, ORGNAME,driver);
			
			/*
			//String mainID=driver.getWindowHandle();
			driver.findElement(By.xpath("//input[@name='account_id']//following-sibling::img[@src='themes/softed/images/select.gif']")).click();
			//String str="Pizza";
			wUtil.switchToWindow(driver,ORGNAME);
			/*
			Set<String> winIDs = driver.getWindowHandles();
			for(String id:winIDs)
			{
				if(!id.equals(mainID))
				{
					
					driver.switchTo().window(id);
					driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
					driver.findElement(By.xpath("//input[@name='search']")).click();
					driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
				wUtil.switchToWindow(driver, "Contacts");
					//	driver.switchTo().window(mainID);
				//}
			//}
			
			*/
			
			//Step 7: Save the information
		//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
			
			//Step 8:Validate the Information
				ContactInfoPage cip=new ContactInfoPage(driver);
				String contactHeader = cip.getContactsHeader();
			if(contactHeader.contains(LNAME))
			{
				System.out.println("PASS");
				System.out.println(contactHeader);
			}
			else
			{
				System.out.println("FAIL");
			}
			
			
			//Step 9:LogOut of App
		/*	WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wUtil.mouseHoverAction(driver, logout);
			Thread.sleep(2000);
			driver.findElement(By.linkText("Sign Out")).click();
			*/
			hp.logoutApp(driver);
			
			//Step 10:Close the Browser
			Thread.sleep(3000);
			driver.close();

			
			
			
			
			
			
		}

	@Test
		public void demo()
		{
			System.out.println("Hello from Demo");
		}


	}


