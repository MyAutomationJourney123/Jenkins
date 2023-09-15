package vtiger.Practice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactAndSelectOrg
{
	public static void main(String[] args) throws Exception
	{
		
		
		//Step 1: Launch Browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver(); // NOTE TRYNG THIS PGM WITH MICROSOFT EDGE BROWSER
		
		//WebDriverManager.firefoxdriver().setup(); //FIREFOX IS NOT INSTALLED IN MY MACHINE
		//WebDriver driver=new FirefoxDriver();   //SO IT DIDN WORK
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8888");
		
		//Step 2:Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
				
		//Step 3:Navigate to Contacts Link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4:Click on Create Contact Look Up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
						
		//Step 5:Create Contact with mandatory information and select organization
//		driver.findElement(By.name("firstname")).sendKeys("A");
		driver.findElement(By.name("lastname")).sendKeys("Bhandari");
		
		String mainID=driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@name='account_id']//following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		
		Set<String> winIDs = driver.getWindowHandles();
		for(String id:winIDs)
		{
			if(!id.equals(mainID))
			{
				String str="Pizza";
				driver.switchTo().window(id);
				driver.findElement(By.id("search_txt")).sendKeys(str);
				driver.findElement(By.xpath("//input[@name='search']")).click();
				driver.findElement(By.xpath("//a[.='"+str+"']")).click();
				driver.switchTo().window(mainID);
			}
		}
		
		
		
		//Step 7: Save the information
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		
		//Step 8:Validate the Information
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("Bhandari"))
		{
			System.out.println("PASS");
			System.out.println(contactHeader);
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
		Thread.sleep(3000);
		driver.close();

		
		
		
		
		
		
		
	}

}
