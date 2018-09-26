package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestingAmazon {
	static WebDriver driver;
	
	
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\matson\\Desktop\\Eclipse_photon\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		String baseURL = "https://www.amazon.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
	}

	@Then("^User search for the item$")
	public void user_search_for_the_item() throws Throwable {
		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
		searchField.sendKeys("Dash Tag");
		WebElement searchButton = driver.findElement(By.xpath("//input[@value='Go']"));
		searchButton.click();
		Thread.sleep(3000);
		
	}

	@When("^User click the first item to check the price$")
	public void user_click_the_first_item_to_check_the_price() throws Throwable {
		WebElement firstItem = driver.findElement(By.xpath("//*[@id='result_0']//h2"));
		firstItem.click();
		WebElement thePrice= driver.findElement(By.id("priceblock_ourprice"));
		System.out.println("The price of this item is " + thePrice.getText());
		Thread.sleep(3000);
	}

	@Then("^Display a successful message$")
	public void display_a_successful_message() throws Throwable {
		System.out.println("SUCCESSFUL FUNCTIONALITY TEST");
	}
}