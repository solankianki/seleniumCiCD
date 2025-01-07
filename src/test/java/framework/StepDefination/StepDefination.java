package framework.StepDefination;

import java.io.IOException;

import org.testng.Assert;

import framework.PageObjects.CartPage;
import framework.PageObjects.CataloguePage;
import framework.PageObjects.ConfirmationPage;
import framework.PageObjects.LandingPage;
import framework.PageObjects.OrderPage;
import framework.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination extends BaseTest {

	public LandingPage landingPage;
	public CataloguePage cataloguePage;
	public OrderPage orderPage;
	public ConfirmationPage cp;
	
	@Given("I landed on Ecommerce Page")
	public void i_landed_on_ecommerce_page() throws IOException {
		
		landingPage=launchApplication();
	}

	@Given("^Logged in with emailId (.+) and password (.+)$")
	public void logged_in_with_email_id_and_password(String username,String password) {
	   
		cataloguePage=landingPage.loginApp(username, password);

	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException {
	    
		cataloguePage.addProductToCart(productName);
	    
	}

	@When("^Checkout (.+) and submit to the cart$")
	public void checkout_and_submit_to_the_cart(String productName) {
		
		CartPage cartPage=cataloguePage.goToCartPage();
		Boolean match=cartPage.verifyProduct(productName);
		Assert.assertTrue(match);
		orderPage = cartPage.checkOut();
		orderPage.selectCountry("India");
		cp=orderPage.confirmPage();
	    
	}

	@Then("{string} msg is displayed on ConfirmationPage")
	public void msg_is_displayed_on_confirmation_page(String msg) {
	    
		String Confirm=cp.ConfirmationMessage();
		Assert.assertTrue(Confirm.equalsIgnoreCase(msg));
		driver.close();

	}
	
	@Then("{string} msg is displayed")
	public void msg_is_displayed(String ErrorMsg) {
	    
		String errorMsg = landingPage.errorMsg();
		Assert.assertEquals(errorMsg, ErrorMsg);
		driver.close();
	}


}
