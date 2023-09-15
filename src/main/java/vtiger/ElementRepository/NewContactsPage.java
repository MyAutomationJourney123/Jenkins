package vtiger.ElementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class NewContactsPage extends WebDriverUtility
{	
	//Declaration
	@FindBy(name="lastname")
	private WebElement lnameTxt;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectOrgBtn;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]") // mam has not given in index
	private WebElement saveBtn;
	
	//In a different window
	@FindBy(id="search_txt")
	private WebElement searchOrgTxt;
	
	//@FindBy(xpath="//input[@name='search']")
	@FindBy(name="search")
	private WebElement searchOrgBtn;
	
	
	//Initialization
	public NewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilization
	public WebElement getLnameTxt() {
		return lnameTxt;
	}

	public WebElement getSelectOrgBtn() {
		return selectOrgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getSearchOrgTxt() {
		return searchOrgTxt;
	}

	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}
	
	//Business Library
	
	
	public void createNewContact(String LNAME)
	{
		lnameTxt.sendKeys(LNAME);
		saveBtn.click();
		
	}
	
	public void createNewContact(String LNAME,String ORGNAME,WebDriver driver)
	{
		lnameTxt.sendKeys(LNAME);
		selectOrgBtn.click();
		switchToWindow(driver,"Accounts");
		searchOrgTxt.sendKeys(ORGNAME);
		searchOrgBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click(); //dynamic xpath
		//a[text()='ch399'] - regular xpath for reference
		//a[text()='"+ORGNAME+"'] -> Dynamic Xpath
		//driver.findElement(By.linkText(ORGNAME));
		
		switchToWindow(driver, "Contacts");
		
		saveBtn.click();
		
	}
	
		
}
