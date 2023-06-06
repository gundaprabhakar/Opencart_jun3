package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
  
    @Test(groups= {"Regression","Master"})
   void test_account_registration() {
    	
    	logger.info("***  staring TC_001_AccountRegistrationTest  *** ");
    try {
	   HomePage hp=new HomePage(driver);
	   hp.clickMyAccount();
	   logger.info("clicked on myAccount");
	   hp.clickRegister();
	   logger.info("clicked on registered link");
	   AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
	   logger.info("providing cudtomer data");
	   regpage.setFirstname(randomString().toUpperCase());
	   regpage.setLastname(randomString().toUpperCase());
	   regpage.setEmail(randomString()+"@gmail.com");//randomly generated email
	   String password=randomString();
	   regpage.setpassword(password);
	   regpage.setPrivacypolicy();
	   regpage.clickContinue();
	   logger.info("clicked on continue");
	  String confmsg=regpage.getconfirmationmsg();
	  logger.info("validating Excepted message");
	  Assert.assertEquals(confmsg,"Your Account Has Been Created!","test failed");
     }
    catch(Exception e) {
    	logger.error("test failed");
   //Assert.fail();
    }
    logger.info("***  Finished TC_001_AccountRegistrationTest  *** ");
    }
}
