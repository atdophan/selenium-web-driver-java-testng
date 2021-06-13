package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Topic_02_Exercise {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/");
	}

	//@Test
	public void TC_01_emptyEmail_Pwd() {
		//Click on "My Account"
		driver.findElement(By.xpath("//div[@class='footer']//a[@title ='My Account']")).click();
		
		//Empty username
		driver.findElement(By.id("email")).sendKeys("");
		
		//Empty password
		driver.findElement(By.className("validate-password")).sendKeys("");
		
		//Click on "Login"
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Verify error message of empty email
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText(), "This is a required field.");
		
		//Verify error message of empty pwd
		//Assert.assertTrue(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText(), "This is a required field.");		
	}
	
	//@Test
	public void TC_02_invalid_Email() {
		//Click on "My Account"
			driver.findElement(By.xpath("//div[@class='footer']//a[@title ='My Account']")).click();
			
		//Enter invalid email
			driver.findElement(By.id("email")).sendKeys("123456@23.12");
			
		//Enter valid pwd
			driver.findElement(By.className("validate-password")).sendKeys("123456");
			
		//Click on "Login"
			driver.findElement(By.xpath("//button[@title='Login']")).click();
			
		//Verify error msg
			//Assert.assertEquals(driver.findElement(By.id("advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
			Assert.assertTrue(driver.findElement(By.id("advice-validate-email-email")).isDisplayed());		
	}
	
	//@Test
	public void TC_03_pwd_less_than_6_chars() {
		//Click on "My Account"
		driver.findElement(By.xpath("//div[@class='footer']//a[@title ='My Account']")).click();
		
		//Enter invalid email
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		
		//Enter valid pwd
		driver.findElement(By.className("validate-password")).sendKeys("123");
		
		//Click on "Login"
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Verify error msg
		//Assert.assertTrue(driver.findElement(By.id("advice-validate-password-pass")).isDisplayed());
		Assert.assertEquals(driver.findElement(By.id("advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test
	public void TC_04_invalid_Pwd() {
		//Click on "My Account"
		driver.findElement(By.xpath("//div[@class='footer']//a[@title ='My Account']")).click();
		
		//Enter invalid email
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		
		//Enter valid pwd
		driver.findElement(By.className("validate-password")).sendKeys("12312345");
		
		//Click on "Login"
		driver.findElement(By.xpath("//button[@title='Login']")).click();
		
		//Verify error msg
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='error-msg']//span")).isDisplayed());
		//Assert.assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
	}
}
