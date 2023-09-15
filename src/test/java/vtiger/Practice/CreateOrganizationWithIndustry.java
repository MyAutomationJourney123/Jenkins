package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustry
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		//Step 1:Launch Browser
		//WebDriverManager.chromedriver().setup();  - NOT REQUIRED TO PROVIDE IN EVERY PROGRAM IN A PROJECT..ONCE ITS SETUP IT WORKS.
		WebDriver driver=new ChromeDriver();
		
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
		driver.findElement(By.name("accountname")).sendKeys("PizzaNow");
		
		//Step 6: Select "Chemicals" in drop down industry
		WebElement ind=driver.findElement(By.name("industry"));
		Select opt=new Select(ind);		
		opt.selectByValue("Chemicals");
		
		//Step 7: Save the information
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		
		//Step 8:Validate the Information
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("PizzaNow"))
		{
			System.out.println("PASS");
			System.out.println(orgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}
		
		
		//Step 9:LogOut of App
		WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 10:Close the Browser
		Thread.sleep(1000);// IMPORTANT TO GIVE SLEEP - otherwise it throws SocketException
		driver.close();

	}

}
