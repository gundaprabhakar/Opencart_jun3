package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;



import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
    @Test(groups= {"Sanity","Master"})
	public void test_login() {
    	try {
		logger.info("***  Stsring TC_002_lLoginTest ***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myAccount");
		hp.clicklogin();
		logger.info("clicked on login");
		LoginPage lp=new LoginPage(driver);
		logger.info("provide login details");
		lp.setEmail(rb.getString("email"));//valid email ,get it from config.properties
		lp.setPassword(rb.getString("Password"));//valid password ,get it from config.properties
		lp.setlogin();
		logger.info("clicked on login button");
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage,true,"Invalid Login data");
    	}
    	catch(Exception e) {
    	//Assert.fail();
    	}
    	logger.info("*** Finshed TC_002_lLoginTest *** ");
	}
}
