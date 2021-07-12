package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_23_Iframe_Frame {
//Iframe means which contains video, image, or link leads to another source
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
	
	@Test
	public void TC_01_Iframe() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Automation training\\Online_Class\\02-Selenium API\\Chrome Driver.exe");
		//Navigate to this page
		driver.get("https://kyna.vn/");
				
		// This  will scroll down to the bottom page	
        scrollTobottomPage();
		        
      //Verify facebook iframe displays
        //1-Switch to iframe facebook
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));
		Thread.sleep(1000);
		
		//2-Verify facebook name page is display
		Assert.assertTrue(driver.findElement(By.xpath("//a[@title='Kyna.vn']")).isDisplayed());
		
		//3-Verify total likes of facebook page = 169k
		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']//parent::div//following-sibling::div")).getText(), "169K likes");
		
	}
	
	
	private void scrollTobottomPage() {
		// This function scroll down the page to the bottom
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
}
