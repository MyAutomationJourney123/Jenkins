package vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	//Declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationImg;
	
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public WebElement getCreateOrganizationImg() 
	{
		return createOrganizationImg;
	}
	
	//Business Library
	public void clickOncreateOrganizationImg()
	{
		createOrganizationImg.click();
	}
	
	
	
	
	
}
