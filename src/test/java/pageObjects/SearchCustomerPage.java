package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waitHelper;
	
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper = new WaitHelper(ldriver);
	}
	
	@FindBy(id = "SearchEmail")
	WebElement txtEmail;
	
	@FindBy(id = "SearchFirstName")
	WebElement txtFirstNmae;
	
	@FindBy(id = "SearchLastName")
	WebElement txtLastName;
	
	@FindBy(id = "SearchMonthOfBirth")
	WebElement drodobMonth;
	
	@FindBy(id = "searchDayOfBirth")
	WebElement drpdobDay;
	
	@FindBy(id = "SearchCompany")
	WebElement txtCompany;
	
	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath = "//li[text()='Administrators']")
	WebElement listItemAdministrators;
	
	@FindBy(xpath = "//li[text()='Forum Moderators']")
	WebElement listForumModerators;
	
	@FindBy(xpath = "//li[text()='Guests']")
	WebElement listItemGuests;
	
	@FindBy(xpath = "//li[text()='Registered']")
	WebElement listItemRegistered;
	
	@FindBy(id = "search-customers")
	WebElement btnSearch;

	@FindBy(xpath = "//li[text()='Vendors']")
	WebElement listItemVendors;
	
	@FindBy(xpath = "//table[@role='grid']")
	WebElement tbleSearchResults;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waitHelper.waitForElement(txtEmail,Duration.ofSeconds(10) );
		txtEmail.clear();
		txtEmail.sendKeys(email);
		
	}
	
	public void setFirstName(String fname) {
		waitHelper.waitForElement(txtFirstNmae ,Duration.ofSeconds(10) );
		txtFirstNmae.clear();
		txtFirstNmae.sendKeys(fname);
		
	}
	
	public void setLastName(String lname) {
		waitHelper.waitForElement(txtLastName,Duration.ofSeconds(10) );
		txtLastName.clear();
		txtLastName.sendKeys(lname);
		
	}
	
	public void clickSearch() {
		btnSearch.click();
		waitHelper.waitForElement(btnSearch,Duration.ofSeconds(10) );
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++)
		{
		String emailId = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
	    System.out.println(emailId);
	    if(emailId.equals(email))
	    {
	    	flag = true;
	    }
	
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag = false;
		for(int i =1;i<=getNoOfRows();i++)
		{
			String name = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[3]")).getText();
			String names[] = name.split(" ");
			if(names[0].equals("Victoria") && names[1].equals("Terces"))
			{
				flag = true;
			}
		
		}
		return flag;
	}
}
