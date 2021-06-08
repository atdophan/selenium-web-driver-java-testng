package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Template {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
	}

	@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Thu auto");
		driver.findElement(By.id("LastName")).sendKeys("Thuauto@gmail.com");
	}
	
	@Test
	//Đối với class, chỉ lấy 1 phần tên của class
	public void TC_02_Classname() {
		driver.findElement(By.className("search-box-text")).sendKeys("macbook");
	}
	
	@Test
	public void TC_03_name() {
		driver.findElement(By.name("Company")).sendKeys("Selenium");
	}
	
	@Test
	//Sd khi cần đếm số lượng elements trên 1 màn hình
	public void TC_04_Tagname() {
		driver.findElements(By.tagName("select")).size();
	}
	
	@Test
	public void TC_05_LinkText() {
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());
		}
	
	@Test
	public void TC_06_Partial_Link_Text() {
		Assert.assertTrue(driver.findElement(By.partialLinkText("Digital")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.partialLinkText("downloads")).isDisplayed());
	}
	
	@Test
	public void TC_07_CSS() {
		driver.findElement(By.cssSelector("#Password")).sendKeys("Pwd12345");
		driver.findElement(By.cssSelector("input[name='ConfirmPassword']")).sendKeys("Pwd12345");
	}
	
	@Test
	public void TC_08_Xpath() {
		driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).clear();
		driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys("Pwd12345");
	}

	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}