package resources;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//This class is for initiating the Browser on which we want to work
public class Base {
public WebDriver driver;
public Properties prop;
public WebDriver initializeDriver() throws IOException {
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\globalVariables.properties");
	prop=new Properties();
	prop.load(fis);
	String browserName=prop.getProperty("browser");
//If our requirement is to execute in chrome browser control will go through this block
  if(browserName.equals("chrome")) {
    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
    driver=new ChromeDriver();
  }
//If our requirement is to execute in firefox browser control will go through this block
  else if(browserName.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\geckodriver.exe");
	driver=new FirefoxDriver();
  }
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    return driver;
}

}
