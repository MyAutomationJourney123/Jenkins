package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithIndustryandType 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Step 1:Launch Browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//Step 2:Open Webpage
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:8888");
		
		//Step 3:Enter Login Credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5:Create Organization and select industry as Energy and Type as Customer
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("Sankhya");
		
		WebElement ind=driver.findElement(By.name("industry"));
		Select sel=new Select(ind);
		sel.selectByValue("Energy");
		
		WebElement type=driver.findElement(By.name("accounttype"));
		sel=new Select(type);
		sel.selectByValue("Customer");
		
		//Step 6: Save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7:Validate
		String orgHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("Sankhyaa"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");

		}

		//Step 8:Logout of app
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		//Step 9: Close Browser
		Thread.sleep(1000);
		driver.close();

	}
}
