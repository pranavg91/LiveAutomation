package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import utilies.CommonUtilies;

public class TC_RF_011 {
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyRegisteringAccountUsingInvalidTelephoneNumber() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Praveen");
		driver.findElement(By.id("input-lastname")).sendKeys("Sharma");
		
		driver.findElement(By.id("input-email")).sendKeys(CommonUtilies.generateBrandNewEmail());
		
		driver.findElement(By.id("input-telephone")).sendKeys("abcd");
		driver.findElement(By.id("input-password")).sendKeys("89659");
		driver.findElement(By.id("input-confirm")).sendKeys("89659");
		driver.findElement(By.xpath("//*[@name=\"newsletter\"][@value='1']")).click();
		
		driver.findElement(By.xpath("//*[@name=\"agree\"][@value='1']")).click();
		driver.findElement(By.xpath("//*[@value=\"Continue\"]")).click();
		
		
		String expectedErrorMessage ="Telephone entered by you is incorrect";
		Assert.assertEquals(driver.findElement(By.xpath("//*[@input-telephone]//following-sibling::div")).getText(), expectedErrorMessage);
		
		Assert.assertFalse(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Success']")).isDisplayed());
		
		
	}
}
