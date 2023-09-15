package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact 
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
						
				//Step 3:Navigate to Contacts Link
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 4:Click on Create Contact Look Up Image
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
								
				//Step 5:Create Contact with mandatory information
		//		driver.findElement(By.name("firstname")).sendKeys("A");
				driver.findElement(By.name("lastname")).sendKeys("Bhandari");
					
				
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
