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

public class TvValidationSteps {
	
	static WebDriver driver;
	
	@Given("User launches flipkart application for Tv Purchase")
	public void user_launches_flipkart_application_for_Tv_Purchase() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

	}

	@Given("User handles login for Tv purchase")
	public void user_handles_login_for_Tv_purchase() {
		
		try {
			WebElement closeicon = driver.findElement(By.xpath("//button[text()='✕']"));
			closeicon.isDisplayed();
			closeicon.click();
			}catch (Exception e) {
		System.out.println("Login is not required");
			}

	}

    String name = "";
	@When("User search Tv")
	public void user_search_Tv() {
    	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(name+" Tv",Keys.ENTER);
    	}
	
	@When("User search Tv {string}")
	public void user_search_Tv(String Tv) {
		
	 	name = Tv;
    	WebElement search = driver.findElement(By.name("q"));
    	search.sendKeys(name+" Tv",Keys.ENTER);
	   	}

	@When("User select the Tv and click add to cart")
	public void user_select_the_Tv_and_click_add_to_cart() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement selectTv = driver.findElement(By.xpath("(//a//div//div//div[contains(text(),'"+name+"')])[1]"));
	 	selectTv.click();
	 	Set<String> wH = driver.getWindowHandles();
	 	List<String> listWindow = new ArrayList<String>(wH);
	 	driver.switchTo().window(listWindow.get(1));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 	WebElement addtocart = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button"));
		addtocart.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

}

	@When("User doing the Tv payment")
	public void user_doing_the_Tv_payment() throws Exception {
		
		//Screenshot
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		if(name.equalsIgnoreCase("SAMSUNG"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\Samsung-TV.png");
	 	FileUtils.copyFile(src,trg);
	 	}
		if(name.equalsIgnoreCase("SONY"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\Sony-TV.png");
	 	FileUtils.copyFile(src,trg);
	 	}
		if(name.equalsIgnoreCase("LG"))
	 	{
	  	TakesScreenshot ts =(TakesScreenshot)driver;
	 	File src =ts.getScreenshotAs(OutputType.FILE);
	 	File trg = new File("C:\\Users\\vrder\\eclipse-workspace\\screenshot\\LG-TV.png");
	 	FileUtils.copyFile(src,trg);
	 	}

	}

	@Then("User receive the Tv payment confirmation message")
	public void user_receive_the_Tv_payment_confirmation_message() {
		
		//scrolldown
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor j =(JavascriptExecutor)driver; 
		j.executeScript("window.scrollBy(0,1000)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.quit();

	}
	
	@When("User search Tv by using OneD list")
	public void user_search_Tv_by_using_OneD_list(DataTable dataTable) {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<String> datas = dataTable.asList();
		name =datas.get(1);		
		driver.findElement(By.name("q")).sendKeys(name+" TV", Keys.ENTER);	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("User search Tv by using OneD map")
	public void user_search_Tv_by_using_OneD_map(DataTable dataTable) {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    Map<String, String> datas = dataTable.asMap(String.class, String.class);
	   	name= datas.get('C');
		driver.findElement(By.name("q")).sendKeys(name+" TV", Keys.ENTER);	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
}
