package webdriver;
import org.testng.annotations.Test;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import junit.framework.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_23_Frame {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver",".\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	}

	@Test
	public void TC_Frame() {
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));
		driver.switchTo().frame("login_page");
		driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("ThuDo");
		driver.findElement(By.cssSelector("table.lForm img[alt='continue']")).click();
		
		//Click on terms and condition
		//2 ways to switch to the default frame
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		//switch to the footer frame which contains Terms and Conditions
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='footer']")));
		driver.findElement(By.xpath("//a[contains(text(),'Terms and Conditions')]")).click();;
}
}
