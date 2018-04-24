package implimentation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GlueCode {
	WebDriver driver;
	@Given("^I am on Flipkart login page$")
	public void i_am_on_Flipkart_login_page() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Stuff\\chromedriver.exe");
		driver=new ChromeDriver();	
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com");
		
	}

	@When("^I enter valid username and password$")
	public void i_enter_valid_username_and_password() throws Throwable {
	    driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[9]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("anilraju.kk@gmail.com");
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("anilraju");
	   
	    
	}
	
	@After
	public void error(Scenario s) throws IOException{
		if (s.isFailed()){
			Reporter.addScreenCaptureFromPath(takeScreenShot());
			 //System.out.println(takeScreenShot());
			 Reporter.addScreenCast(takeScreenShot());
		}
	}

	@When("^I click on signIN button$")
	public void i_click_on_signIN_button() throws Throwable {
		 driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[3]/button")).click();
		 
	}
	
	public String takeScreenShot() throws IOException{
		TakesScreenshot f=(TakesScreenshot)driver;
		File source=f.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\errorScreenShots\\img1.png";
		File dest=new File(destination);
		FileUtils.copyFile(source, dest);
		return destination;
	}


	@Then("^home page should be displayed$")
	public void home_page_should_be_displayed() throws Throwable {
	   Assert.assertTrue(false);
	}

	@When("^I enter in INvalid username and password$")
	public void i() throws Throwable {
	   
	}
	
	@When("^I enter in INvalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_in_INvalid_username_and_password(String arg1, String arg2) throws Throwable {
		driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[9]/a")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys(arg1);
	    driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys(arg2);
	   
	}


	@Then("^error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
	    
	}

}
