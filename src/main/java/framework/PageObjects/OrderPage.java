package framework.PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
    WebDriver driver;

	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".action__submit")
	private WebElement confirmMsg;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectedCountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		WaitForElementToAppear(results);
		selectedCountry.click();
	}
	
	public ConfirmationPage confirmPage()
	{
		confirmMsg.click();
		return new ConfirmationPage(driver);
	}

}
