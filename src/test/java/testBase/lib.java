package testBase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

/*This Class acts as a parent to the TripPlanner and the KnowledgeBase classes*/

public class lib {
	
	protected static WebDriver driver = null; // The WebDriver reference declared here is used by the two child classes.
	public String baseUrl = "https://transportnsw.info/trip#/trip";	// URL of the Trip Planner Web application.
	
	// This method is used to setup the environment for chromedriver, as it is the most stable browser.	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup(); //We can make the changes here to use FirefoxDriver or InternetExplorer driver as needed.			
		driver = new ChromeDriver(); // In this Framework, we've made the use of ChromeDriver, as it is the most stable browser for our testing needs.		
		driver.get(baseUrl);		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	// This method will close any browser opened and used as a tear down for quitting the WebDriver reference.
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(6000); //Note: The explicit wait condition is purposely included, so as to see the results after scrolling down.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();	// The quit method will quit the WebDriver reference. And close the browser window.	
	}

}
