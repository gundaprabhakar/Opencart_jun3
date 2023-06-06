package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	//Elements
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']") WebElement linklogin;//link login added in step 6
	
	//Action Methods
    public void clickMyAccount() {
    	lnkMyAccount.click();
    }
    public void clickRegister() {
    	lnkRegister.click();
    }
    public void clicklogin() {
    	linklogin.click();
    }
}
