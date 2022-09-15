package com.flipkart.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileValidationSteps {
	
	static WebDriver driver;
 	
	@Given("User launches flipkart application")
	public void user_launches_flipkart_application() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}

	@Given("User handles login")
	public void user_handles_login() {

		try {
			WebElement closeicon = driver.findElement(By.xpath("//button[text()='✕']"));
			closeicon.isDisplayed();
			closeicon.click();
			}catch (Exception e) {
		System.out.println("Login is not required");
			}
		}
	
    String name = "";
    @When("User search mobile ")
    public void user_search_mobile() {
    	name = "realme";
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(name,Keys.ENTER);
    	}	

    @When("User search mobile {string}")
    public void user_search_mobile(String mobile) {
    	name = mobile;
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(name,Keys.ENTER);
	   	}

	@When("User select the mobile and click add to cart")
	public void user_select_the_mobile_and_click_add_to_cart() {
		

		WebElement selectmobile = driver.findElement(By.xpath("(//a//div//div//div[contains(text(),'"+name+"')])[2]"));
		selectmobile.click();
		Set<String> wH = driver.getWindowHandles();
	 	List<String> listWindow = new ArrayList<String>(wH);
	 	driver.switchTo().window(listWindow.get(1));
		WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		addtocart.click();
	}

	@When("User doing the payment")
	public void user_doing_the_payment() throws Exception  {
		
		//Screenshot
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if(name.equalsIgnoreCase("realme"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\mobile.png");
	 	FileUtils.copyFile(src,trg);
	 	}
		if(name.equalsIgnoreCase("iphone"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\mobile.png");
	 	FileUtils.copyFile(src,trg);
	 	}
		if(name.equalsIgnoreCase("redmi"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\mobile.png");
	 	FileUtils.copyFile(src,trg);
	 	}
		
	}

	@Then("User receive the confirmation message")
	public void user_receive_the_confirmation_message() {
		//scrolldown
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor j =(JavascriptExecutor)driver; 
		WebElement down = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		j.executeScript("arguments[0].scrollIntoView(true)", down);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@When("User search mobile by using OneD list")
	public void user_search_mobile_by_using_D_list(DataTable dataTable) {

		List<String> datas = dataTable.asList();
		name=datas.get(1);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(name,Keys.ENTER);
	}
	

	@SuppressWarnings("unlikely-arg-type")
	@When("User search mobile by using OneD map")
	public void user_search_mobile_by_using_D_map(DataTable dataTable) {

	    Map<String, String> datas = dataTable.asMap(String.class, String.class);
	    char c = 'C';
		name= datas.get(c);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys(name,Keys.ENTER);
	}

		
}