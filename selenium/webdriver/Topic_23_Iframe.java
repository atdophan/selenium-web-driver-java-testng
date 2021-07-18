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

public class Topic_23_Iframe {
//Iframe means which contains video, image, or link leads to another source
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	@BeforeClass
	public void beforeClass() {
		//Declare path to chromedriver.exe, . means current path, no need to list absolute path
		System.setProperty("webdriver.chrome.driver",".\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}
		
	//@Test
	public void TC_01_Iframe_kynaFacebook() throws InterruptedException {
		
		driver.get("https://kyna.vn/");
		
		//Mazimize current window
		driver.manage().window().maximize();
		
		//Work in Search bar
			//Search by entering "excel"
				driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
						
			// Click on "Search" button
				driver.findElement(By.className("search-button")).click();
				
			//Save a list of excel elements
				java.util.List<WebElement> courseName = driver.findElements(By.cssSelector("div.content>h4"));
				
			//Verify size of list
				Assert.assertEquals(courseName.size(), 9);
			//Verify all elements contain "excel", use lowecase for the first capital letter
				//This function loops each couse as a singular var in courseName as plural var
				for (WebElement course:courseName) {
				Assert.assertTrue(course.getText().toLowerCase().contains("excel"));
				}
							
	}
			
	//@Test
	public void TC_02_Iframe(){
		//Navigate to this page
		driver.get("https://kyna.vn/");
				
		// Call scroll down to the bottom page func	
        scrollTobottomPage();
		        
      //Verify facebook iframe displays
        //1-Switch to iframe facebook
		driver.switchTo().frame(driver.findElement(By.cssSelector("div.fanpage iframe")));
		//Thread.sleep(1000);
		
		//2-Verify facebook name page is display
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//a[@title='Kyna.vn']")).isDisplayed());
		
		//3-Verify total likes of facebook page = 169k
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']//parent::div//following-sibling::div")).getText(), "168K lượt thích");	
	
		//Switch to the current frame
		driver.switchTo().parentFrame();
		
				
		//Switch to chat iframe
		driver.switchTo().frame(driver.findElement(By.id("cs_chat_iframe")));
		
	    //Work in chat box
		//Click on chat box
		driver.findElement(By.className("border_overlay")).click();
		
		//Enter in compulsory field
		driver.findElement(By.className("input_name")).sendKeys("Thu Do");
		driver.findElement(By.className("input_phone")).sendKeys("0345135228");
		
		//Click on "Gui tin nhan"
		driver.findElement(By.className("submit")).click();
		
		//Verify error msg displays
		Assert.assertEquals("Bạn chưa chọn dịch vụ hỗ trợ", driver.findElement(By.cssSelector("#serviceSelect+div.error_message")).getText());
	}

	
	
	private void scrollTobottomPage() {
		// This function scroll down the page to the bottom
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
}
