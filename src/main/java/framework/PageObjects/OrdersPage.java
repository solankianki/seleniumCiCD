package framework.PageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{
    WebDriver driver;

	public OrdersPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	
	public Boolean verifyProduct(String productName)
	{
		Boolean match=productNames.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
		return match;
	}

}
