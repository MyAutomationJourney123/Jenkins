package vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class NewOrganizationPage extends WebDriverUtility
{
	//Declaration
	@FindBy(name="accountname")
	private WebElement accountNameTxt;
	
	@FindBy(name="industry")
	private WebElement industrydrpdown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//Initialization
	public NewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getAccountNameTxt() {
		return accountNameTxt;
	}

	public WebElement getIndustrydrpdown() {
		return industrydrpdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//BusinessLibrary
	/**
	 * This method will create organization by handling industry dropdown
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME,String INDUSTRY)
	{
		accountNameTxt.sendKeys(ORGNAME);
		handleDropdown(industrydrpdown, INDUSTRY);
		saveBtn.click();
		
	}
	/**
	 * This method will create organization using mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		accountNameTxt.sendKeys(ORGNAME);
		saveBtn.click();
		
	}
	
}
