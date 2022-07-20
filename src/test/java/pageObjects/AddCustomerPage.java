package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//i[@class='nav-icon far fa-user']/following-sibling :: p") 
	WebElement lnkCustomers_menu; 
	
	@FindBy(xpath ="//a[@href='/Admin/Customer/List']/child::p")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
	WebElement btnAddnew;
	
	@FindBy(id = "Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(id = "FirstName")
	WebElement txtFirstName;
	
	@FindBy(id = "LastName")
	WebElement txtLastName;
	
	@FindBy(id = "Gender_Male")
	WebElement rdMaleGender;
	@FindBy(id = "Gender_Female")
	WebElement rdFemaleGender;
	
	@FindBy(id = "DateOfBirth")
	WebElement txtDOB;
	
	@FindBy(id = "Company")
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent :: div/parent :: div/parent :: div")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")
	WebElement defaultCustRole;
	
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
	WebElement lstItemAdministators;
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")
	WebElement lstForumModerators;
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
	WebElement lstItemGuests;
	@FindBy(xpath = "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]")
	WebElement lstItemRegistered;
	@FindBy(xpath= "//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]")
	WebElement lstItemVendors;
	
	@FindBy(id = "VendorId")
	WebElement drpmgrOfVendors;
	
	@FindBy(id = "AdminComment")
	WebElement txtAdminComment;
	
	@FindBy(name = "save")
	WebElement btnSave;
	
	//Action Methods
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	public void clickOnCustomerMenu() {
		lnkCustomers_menu.click();
	}
	public void clickOnCustomerMenuItem() {
		lnkCustomers_menuitem.click();
	}
	public void clickOnAddnew() {
		btnAddnew.click();
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("Male"))
		{
			rdMaleGender.click();
		}
		else
		{
			rdFemaleGender.click();
		}
		
	}
	
	public void setDOB(String dob)
	{
		txtDOB.sendKeys(dob);
	}
	
	public void setCompanyName(String companyname)
	{
		txtCompanyName.sendKeys(companyname);
	}
	
	
	public void setCustomerRoles(String role) throws InterruptedException
	{
		defaultCustRole.click();;
		txtCustomerRoles.click();
		Thread.sleep(3000);
	
		if(role.equals("Administators")) 
		{
		 lstItemAdministators.click();;
		}
		else if(role.equals("Guests"))
		{
			lstItemGuests.click();;
		}
		else if(role.equals("Registered"))
		{
			lstItemRegistered.click();;
		}
		else if(role.equals("Vendors"))
		{
			lstItemVendors.click();;
		}
		else
		{
			lstForumModerators.click();;
		}
		
	}
		public void setManagerOfVendor(String value)
		{
			
				Select drp = new Select(drpmgrOfVendors);
				drp.selectByVisibleText(value);
		
			
		}
		public void setAdminComment(String comment)
		{
			txtAdminComment.sendKeys(comment);
		}
		
		public void clickOnSave()
		{
			btnSave.click();
		}
	}

	


