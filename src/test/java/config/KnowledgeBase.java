package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import testBase.lib;

/* This Class acts as a respository to the Xpaths and the From and To locations, which can be modified/changed according to our needs*/
public class KnowledgeBase extends lib {
	
	By FromLocation = By.xpath("//*[@id=\"tniFromTripLocation\"]");
	By ToLocation = By.xpath("//*[@id=\"tniToTripLocation\"]");
	By OutOfLocation = By.xpath("//*[@id=\"trip-planner-left-panel\"]/div[1]/tni-trip-search-form/div/form/div[1]");
	By ViewElement = By.xpath("//*[@id=\"trip-planner-left-panel\"]/div[2]/div/div[2]/tni-append-trips/div/button");
	
	public String From = "North Sydney Station";
	public String To = "Town Hall Station";
	
	public void EnterFromLocation() {
		
		driver.findElement(FromLocation).sendKeys(From);
		
	};
	
	public void EnterToLocation() {
		
		driver.findElement(ToLocation).sendKeys(To);
		
	};
	
	// This class merely is used to take the WebDriver reference out of the To Location, so that the Ajax component can auto-fill the exact 'To location'.
	public void ClickOutsideOfLocations() {
		
		driver.findElement(OutOfLocation).click();
	};
	
	// This method will scroll down the relevant scroll bar, so that we can see the results/List till the end.
	public void SearchForTripsLaterButton()  {
		
		driver.findElement(ViewElement);
		WebElement viewelement = driver.findElement(ViewElement);
		Actions actions = new Actions(driver);
		actions.moveToElement(viewelement);
		actions.perform();
	};

}
