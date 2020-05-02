package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//This Class handles LandingPage in our Application, so we will have in this class "the webelements on that page we are going to 
//work with and their methods"
public class LandingPage {
	public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[@class='arrow-marker']")
	WebElement addressSelection;
	@FindBy(xpath = "//span[@class='btn btn-default form-control ui-select-toggle']")
	WebElement citySelection;
	@FindBy(xpath = "//input[@id='areaselect']")
	WebElement areaSelection;
	@FindBy(xpath = "//button[@class='btn btn-default ng-scope']")
	WebElement continueBtn;
	@FindBy(xpath = "//i[@class='icon svg-header svg-arrow-down-hover svg-arrow-down-hover-dim']")
	WebElement shopByCategoryOption;
	@FindBy(xpath = "//a[@class='ng-binding active'][contains(text(),'Beverages')]")
	WebElement beveragesSelection;
	
	public WebElement addressSelection() {
		return addressSelection;	
    }
	public WebElement citySelection() {
		return citySelection;	
    }
	public WebElement areaSelection() {
		return areaSelection;	
    }
	public WebElement continueBtn() {
		return continueBtn;	
    }
	public WebElement shopByCategoryOption() {
		return shopByCategoryOption;	
    }
	public WebElement beveragesSelection() {
		return beveragesSelection;	
    }
	nav
}
