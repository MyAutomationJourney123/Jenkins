		package vtiger.Practice;

		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.time.Duration;
		import java.util.Properties;
		import java.util.Random;

		import org.apache.poi.ss.usermodel.Sheet;
		import org.apache.poi.ss.usermodel.Workbook;
		import org.apache.poi.ss.usermodel.WorkbookFactory;
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.edge.EdgeDriver;
		import org.openqa.selenium.firefox.FirefoxDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.Select;

		import io.github.bonigarcia.wdm.WebDriverManager;


		public class CreateOrgWithIndustryUsingDDT {
			
			public static void main(String[] args) throws Throwable {
				
				Random r = new Random();
				int random = r.nextInt(1000);
				
						
				WebDriver driver = null;
				
				//Step 1: Read All the Data required
				
				 /*read Data from Property file*/
				FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				Properties p = new Properties();
				p.load(fisp);
				String BROWSER = p.getProperty("browser"); //chrome
				String URL = p.getProperty("url");
				String USERNAME = p.getProperty("username");
				String PASSWORD = p.getProperty("password");
				
				 /*read Data from ExcelFile*/
				
				FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				Workbook wb = WorkbookFactory.create(fise);
			    Sheet sh = wb.getSheet("Organization");
			    String ORGNAME = sh.getRow(4).getCell(2).getStringCellValue()+random;
			    String INDUSTRY = sh.getRow(4).getCell(3).getStringCellValue();
				
				
				
				
				
				//Step 2: Launch the browser - //Run Time Polymorphism - driver
			    if(BROWSER.equalsIgnoreCase("chrome"))
			    {
			    	WebDriverManager.chromedriver().setup();
			    	driver = new ChromeDriver();
			    }
			    else if(BROWSER.equalsIgnoreCase("firefox"))
			    {
			    	WebDriverManager.firefoxdriver().setup();
			    	driver = new FirefoxDriver();
			    }
			    else if(BROWSER.equalsIgnoreCase("edge"))
			    {
			    	WebDriverManager.edgedriver().setup();
			    	driver = new EdgeDriver();
			    }
			    else
			    {
			    	System.out.println("Invalid Browser name");
			    }
			    
			    driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(URL);
				
				//Step 2: Login To Application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 3: Navigate to Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 4: Click On create Organization Look Up Image
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//Step 5: Create Organization with mandatory Information
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 6: Select 'Chemicals' in industry Drop down
				WebElement dropDown = driver.findElement(By.name("industry"));
				Select sel = new Select(dropDown);
				sel.selectByValue(INDUSTRY);
				
				//Step 7: Save 
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Validate
				String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgHeader.contains(ORGNAME))
				{
					System.out.println("PASS");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 9: Logout of App
				WebElement mouseHover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(mouseHover).perform();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step 10: Close the browser
				driver.quit();
				
		
				
			}

		

	}


