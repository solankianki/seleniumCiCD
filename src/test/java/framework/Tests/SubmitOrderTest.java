package framework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.PageObjects.CartPage;
import framework.PageObjects.CataloguePage;
import framework.PageObjects.ConfirmationPage;
import framework.PageObjects.OrderPage;
import framework.PageObjects.OrdersPage;
import framework.TestComponents.BaseTest;

//Submitting the product in ecommerceApp
public class SubmitOrderTest extends BaseTest{
	
	@Test(dataProvider = "getData",groups = "sanity")
	public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException {
		
		
		CataloguePage cataloguePage=landingPage.loginApp(input.get("id"), input.get("pass"));
		cataloguePage.addProductToCart(input.get("productName"));
		CartPage cartPage=cataloguePage.goToCartPage();
		Boolean match=cartPage.verifyProduct(input.get("productName"));
		Assert.assertTrue(match);
		OrderPage orderPage = cartPage.checkOut();
		orderPage.selectCountry("India");
		ConfirmationPage cp=orderPage.confirmPage();
		String Confirm=cp.ConfirmationMessage();
		Assert.assertTrue(Confirm.equalsIgnoreCase("Thankyou for the order."));
			
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		String productName="IPHONE 13 PRO";
		CataloguePage cataloguePage=landingPage.loginApp("ankit.solanki@appfoster.com", "ankit123");
		OrdersPage ordersPage=cataloguePage.productOrdersPage();
		Assert.assertTrue(ordersPage.verifyProduct(productName));
		

	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//framework//data//JsonData.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}
