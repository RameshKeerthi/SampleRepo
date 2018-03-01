package ReusableCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Browsers {
	
	public WebDriver driver;
	
  @BeforeTest
  public void useChromeBrowser() 
  {
	  System.setProperty("webdriver.chrome.driver","E:\\AnushaSoftwares\\chromedriver.exe");
	  
	  driver=new ChromeDriver();
  }
  
  @AfterTest
  public void quiteBrowser()
  {
	  driver.quit();
  }

 }
