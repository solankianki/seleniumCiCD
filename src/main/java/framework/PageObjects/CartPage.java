package framework.PageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
    WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	
	public Boolean verifyProduct(String productName)
	{
		Boolean match=cartProducts.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public OrderPage checkOut()
	{
		checkout.click();
		return new OrderPage(driver);
	}

}
