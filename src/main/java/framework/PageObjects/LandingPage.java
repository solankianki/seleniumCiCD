package framework.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	private WebElement email;
	
	@FindBy(id="userPassword")
	private WebElement pass;
	
	@FindBy(id="login")
	private WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	private WebElement errorMsg;
	
	public CataloguePage loginApp(String username,String password)
	{
		email.sendKeys(username);
		pass.sendKeys(password);
		login.click();
		return new CataloguePage(driver);
	}
	
	public void goTo()
	{
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String errorMsg()
	{
		WaitForWebElementToAppear(errorMsg);
		return errorMsg.getText();
	}
}
