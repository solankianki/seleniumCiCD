package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponents;

public class CataloguePage extends AbstractComponents{
	WebDriver driver;

	public CataloguePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	private List<WebElement> productList;
	
	@FindBy(css=".ng-animating")
	private WebElement animation;
	
	By addToCart =     By.cssSelector(".card-body button:nth-of-type(2)");
	By waitforProduct= By.cssSelector(".mb-3");
	By toastMsg=       By.cssSelector(".toast-container");
	
	public List<WebElement> getProductList()
	{
		WaitForElementToAppear(waitforProduct);
		return productList;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText()
				.equalsIgnoreCase(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		WaitForElementToAppear(toastMsg);
		WaitForWebElementToDisAppear(animation);
	}

}
