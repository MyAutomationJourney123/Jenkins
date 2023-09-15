package weekend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarDate {

	public static void main(String[] args) 
	{
	
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		String month="October 2023";
		String date="15";
		driver.findElement(By.xpath("//div[text()='"+month+"']//ancestor::div[@class='DayPicker-Month']//descendant::p[text()='"+date+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Done']"));
		
		// Do the same for return date and selecting the no.of adults, children, infant, to and from places and click on search filghts.
		
	}

}
