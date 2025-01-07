package framework.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		String productName="IPHONE 13 PRO";
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("ankit.solanki@appfoster.com");
		driver.findElement(By.id("userPassword")).sendKeys("ankit123");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> productList = driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod = productList.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:nth-of-type(2)")).click();
//		for (WebElement product : productList) {
//			String productName=product.findElement(By.cssSelector("b")).getText();
//			if(productName.equals("IPHONE 13 PRO"))
//			{
//				driver.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//			}div[aria-label='Product Added To Cart']
//		}//div[@class='ng-tns-c4-4 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-success']		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(item->item.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//		(Via Actions)
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
//		(Via Streams)
//		List<WebElement> selectCountry=driver.findElements(By.cssSelector(".list-group-item"));
//		WebElement Selcountry= selectCountry.stream().filter(country->country.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
//		Selcountry.click();
		System.out.println("It worked");
		driver.findElement(By.cssSelector(".action__submit")).click();
		String Confirm=driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(Confirm);
		Assert.assertTrue(Confirm.equalsIgnoreCase("Thankyou for the order."));
		
		
		
	}

}
