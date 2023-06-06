package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	//Elements
	@FindBy(name="firstname") WebElement txtfirstname;
	@FindBy(name="lastname") WebElement txtLastname;
	@FindBy(name="email") WebElement txtEmail;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="agree") WebElement chkdPolicy;
	
	@FindBy(xpath="//button[@type='submit']") WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
	
	//Actions
	
	public void setFirstname(String fname) {
		txtfirstname.sendKeys(fname);
	}
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setpassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setPrivacypolicy() {
		chkdPolicy.click();
	}
	public void clickContinue() {
		btncontinue.click();
	}
	public String getconfirmationmsg() {
		try {
		return(msgConfirmation.getText());
		}
		catch(Exception e) {
			return(e.getMessage());
		}
		
	}
}
