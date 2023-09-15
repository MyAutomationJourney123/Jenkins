package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization 
{
	public static void main(String[] args) throws InterruptedException
	{
		
			Random rand = new Random();
			int rand_num=rand.nextInt(500); // Generates random numbers between 1-500
		
		//Step 1:Launch Browser
			WebDriverManager.chromedriver().setup(); // - NOT REQUIRED TO PROVIDE IN EVERY PROGRAM IN A PROJECT..ONCE ITS SETUP IT WORKS.
				WebDriver driver=new ChromeDriver();
			
		//		WebDriverManager.edgedriver().setup();
			//	WebDriver driver=new EdgeDriver();
		
	/*		WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver(); */
				
		
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get("http://localhost:8888");
				
				//Step 2:Login to Application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
						
				//Step 3:Navigate to Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				//driver.findElement(By.partialLinkText("Create Organization...")).click(); - doesnt work
				
				//Step 4:Click on Create Organization Look Up Image
				driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
				//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//Step 5:Create organization with mandatory information
				String orgname="Sankhyaa" + rand_num;
				driver.findElement(By.name("accountname")).sendKeys(orgname);
				
				//Step 6: Save the information
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
				//Step 7:Validate the Information
				String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(orgHeader.contains("Sankhyaa"))
				{
					System.out.println("PASS");
					System.out.println(orgHeader);
				}
				else
				{
					System.out.println("FAIL");
				}
				
				//Step 8:LogOut of App
				WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(logout).perform();
				Thread.sleep(2000);
				driver.findElement(By.linkText("Sign Out")).click();
				
				//Step 9:Close the Browser
				Thread.sleep(1000);// IMPORTANT TO GIVE SLEEP - otherwise it throws SocketException
				driver.close();


	}

}
