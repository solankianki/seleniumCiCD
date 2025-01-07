package framework.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.PageObjects.CartPage;
import framework.PageObjects.CataloguePage;
import framework.TestComponents.BaseTest;
import framework.TestComponents.Retry;

//ErrorValidations Test
public class ErrorValidationsTest extends BaseTest{
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void submitOrder() throws InterruptedException, IOException {
		
		landingPage.loginApp("ankit.solanki@appfoster.com", "ankit13");
		String errorMsg = landingPage.errorMsg();
		System.out.println(errorMsg);
		Assert.assertEquals(errorMsg, "Incorrect email or password.");
		
	}
	
	@Test
	public void productErrorValidation() throws InterruptedException, IOException {
		
		String productName="IPHONE 13 PRO";
		CataloguePage cataloguePage=landingPage.loginApp("solankiankit66@gmail.com", "Rahul@123");
		cataloguePage.addProductToCart(productName);
		CartPage cartPage=cataloguePage.goToCartPage();
		Boolean match=cartPage.verifyProduct("IPHONE 1 PRO");
		Assert.assertFalse(match);
			
	}

}
