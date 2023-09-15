package vtiger.ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	
	//Rule 1: Create a separate pom class for every web page.
	//Rule 2: Identify the web elements using @FIndBy, @FindAll and @FindBys
	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule 3:Create constructor to initialize the web elements
	//Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

		
	//Rule 4: Provide getters for accessing the web elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5: Provide Business library - Framework developers idea
	 //Is a generic method created using web elements present only in current page
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	
	public void  logintoApp(String USERNAME, String PASSWORD) 
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	

}
