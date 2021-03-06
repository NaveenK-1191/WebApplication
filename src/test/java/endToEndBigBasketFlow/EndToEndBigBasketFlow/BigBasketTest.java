package endToEndBigBasketFlow.EndToEndBigBasketFlow;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BeveragesSelectionPage;
import pageObjects.LandingPage;
import resources.Base;
import resources.ExcelUtility;
//This Class is our Actual TestClass where our Test Case exists
public class BigBasketTest extends Base {
	public static WebDriver driver;
	//This method is to initiate browser & navigate to the Url for the Application to test by taking the
	//properties from Base class and properties file
	@BeforeTest
	public void initiation() throws IOException {
	    driver=initializeDriver();
	    driver.get(prop.getProperty("Url"));
	}
	//This method is a method where our actual TestCase lies
	@Test
	public void productDetailsConfirmation() throws InterruptedException, IOException {
		 Thread.sleep(10000);
		 LandingPage l=new LandingPage(driver);
		 l.addressSelection().click();
		 Thread.sleep(5000);
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys("Hyderabad").sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(5000);
		 l.areaSelection().sendKeys("Ameerpet");
		 Thread.sleep(4000);
		 act.sendKeys(Keys.ENTER).build().perform();
		 Thread.sleep(4000);
		 l.continueBtn().click();
		 Thread.sleep(6000);
		 l.shopByCategoryOption().click();
		 Thread.sleep(7000);
	     act.sendKeys(Keys.ARROW_DOWN).perform();
	     act.sendKeys(Keys.ARROW_DOWN).perform();
	     act.sendKeys(Keys.ARROW_DOWN).perform();
	     act.sendKeys(Keys.ARROW_DOWN).perform();
	     act.sendKeys(Keys.ENTER).perform();
	     Thread.sleep(8000);
	     BeveragesSelectionPage b=new BeveragesSelectionPage(driver);
         b.productOne().click();
	     Thread.sleep(8000);
         String productOneDescription=b.productOneDescription().getText();
	     System.out.println(productOneDescription);
		 Thread.sleep(5000);
		 String productOneBrand=b.productOneBrand().getText();
		 System.out.println(productOneBrand);
		 Thread.sleep(5000);
		 driver.navigate().back();
		 Thread.sleep(25000);
		 driver.findElements(By.xpath("//img[@class='img-responsive blur-up lazyautosizes lazyloaded']")).get(8).click();
		 Thread.sleep(8000);
		 String productTwoDescription=b.productTwoDescription().getText();
		 System.out.println(productTwoDescription);
		 Thread.sleep(5000);
		 String productTwoBrand=b.productTwoBrand().getText();
		 System.out.println(productTwoBrand);
		 ExcelUtility e=new ExcelUtility(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Writing in excel.xlsx");
		 e.setCellData("TestData", "Product Description", 2, productOneDescription);
		 Thread.sleep(5000);
		 e.setCellData("TestData", "Product Description", 3, productTwoDescription);
		 Thread.sleep(5000);
		 e.setCellData("TestData","Product Brand", 2, productOneBrand);
		 Thread.sleep(5000);
		 e.setCellData("TestData","Product Brand", 3, productTwoBrand);
		 Thread.sleep(5000);    
	}
	//This method is used to close the browser after the test execution
	@AfterTest
	public void tearDown() {
		driver.close();
		driver=null;
	}
}
