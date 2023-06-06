package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;//for logger




public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger;//for logging
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {
		rb=ResourceBundle.getBundle("config");//Load config.properties file
		
		logger=LogManager.getLogger(this.getClass());
		
		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome")) {
			 ChromeOptions option = new ChromeOptions();
			    option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		}
		else if(br.equals("edge")) {
			EdgeOptions option = new EdgeOptions();
		    option.addArguments("--remote-allow-origins=*");
			driver=new EdgeDriver(option);
		}
		else {
			FirefoxOptions option = new FirefoxOptions();
		    option.addArguments("--remote-allow-origins=*");
			driver=new FirefoxDriver(option);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
   
   @AfterClass(groups= {"Master","Sanity","Regression"})
  public void teardown() {
	   driver.quit();
   }
   
   public String randomString() {
	  String generatedString= RandomStringUtils.randomAlphabetic(5);
	  return (generatedString);
   }
   public String randomNumber() {
		  String generatedString1= RandomStringUtils.randomNumeric(4);
		  return (generatedString1);
	   }
   public String randomAlphaNumber() {
	   String st= RandomStringUtils.randomAlphabetic(4);
		  String num= RandomStringUtils.randomNumeric(3);
		  return(st+"@"+num);
	   }
   public String CaptureScreen(String tname) {
	   String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
	   File source=takesscreenshot.getScreenshotAs(OutputType.FILE);
	  String destination= System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timestamp + ".png";
	  try {
		  FileUtils.copyFile(source,new File(destination));
	  }
	  catch(Exception e) {
		  e.getMessage();
	  }
	  return destination;
   }
}
