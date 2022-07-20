package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass 
{
	@Before
	public void setUp() throws IOException
	{
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		String br = configProp.getProperty("browser");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
		driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
		driver = new FirefoxDriver();
		}
		
		else if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver",configProp.getProperty("edgepath"));
		driver = new EdgeDriver();
		}
	}
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enters Email {string} and Password {string}")
	public void user_enters_email_and_password(String email, String pwd) {
		lp.setUserName(email);
		lp.setPassword(pwd);
		
	}

	@When("Click on Login")
	public void click_on_login() {
		
		lp.clickLogin();
		
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String pgtitle) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertEquals(pgtitle,driver.getTitle());
		}
			
		
	}

	@When("User Click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
		
	}

	@Then("Close browser")
	public void close_browser() {
		driver.quit();
	 
	}
	
	//Customer Feature Steps
	

	@Then("User can view the Dashboad")
	public void user_can_view_the_dashboad() {
		addCust = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	    
	}
	@When("User clicks on Customers Menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomerMenu();
	
	}
	   
	@When("User clicks on Customers Menu Item")
	public void user_clicks_on_customers_menu_item() {
	 addCust.clickOnCustomerMenuItem();   
	}
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	   
	}
	@Then("User can view Add new Customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}
	@When("User enter Customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("tester");
		addCust.setFirstName("Silpa");
		addCust.setLastName("Jakkareddy");
		addCust.setGender("Female");
		addCust.setDOB("4/13/1982"); 
		addCust.setCompanyName("Xyz");
		addCust.setCustomerRoles("Guests");
		Thread.sleep(3000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setAdminComment("Testing Practice");
	    
	}
	@When("Click on Save button")
	public void click_on_save_button() {
		addCust.clickOnSave();
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));  
	}
	
	//Steps for searching a customer using EmailID
	
	@When("Enter Customer Email")
	public void enter_customer_email() {
	    searchCust = new SearchCustomerPage(driver);
	    searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		Thread.sleep(3000);
	    
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(true,status);
	}

	//Steps for searching customer by using Firstname and Lastname
	
	

	@When("Enter Customer FirstName")
	public void enter_customer_first_name() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	    
	}
	@When("Enter Customer LastName")
	public void enter_customer_last_name() {
	    searchCust.setLastName("Terces");
	}
	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
	  boolean status = searchCust.searchCustomerByName("Victoria Terces");
	  Assert.assertEquals(true,status); 
	}



}
