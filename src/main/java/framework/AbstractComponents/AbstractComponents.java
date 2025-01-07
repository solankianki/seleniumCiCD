package framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjects.CartPage;
import framework.PageObjects.OrdersPage;

public class AbstractComponents {
	private WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	private WebElement cartPage;
	
	@FindBy(css="[routerlink*='myorders']")
	private WebElement ordersHeader;

	
	public void WaitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void WaitForWebElementToDisAppear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage()
	{
		cartPage.click();
		return new CartPage(driver);

	}
	
	public OrdersPage productOrdersPage()
	{
		ordersHeader.click();
		return new OrdersPage(driver);

	}

}
