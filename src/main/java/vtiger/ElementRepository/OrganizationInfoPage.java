package vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{

	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrganizationHeaderTxt;
	
	//Initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getOrganizationHeaderTxt() {
		return OrganizationHeaderTxt;
	}
	
	//Business Library
	/*
	public void validateOrganizationHeader(String ORGNAME)
	{
		if( OrganizationHeaderTxt.getText().contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrganizationHeaderTxt.getText());
		}
		else
		{
			System.out.println("FAIL");
		}
	}*/
	
	//NEVER EVER WRITE validation in src/main/java
	
	public String getOrgHeader() 
	{
		return OrganizationHeaderTxt.getText();
	}
	
	
	
	
}
