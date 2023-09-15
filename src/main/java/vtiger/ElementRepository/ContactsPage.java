package vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactsImg;
	
	//Initialization
		public ContactsPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		//Utilization
		public WebElement getcreateContactsImg() 
		{
			return createContactsImg;
		}
		
		//Business Library
		public void clickOncreateContactsImg()
		{
			createContactsImg.click();
		}
	
		
	
}
