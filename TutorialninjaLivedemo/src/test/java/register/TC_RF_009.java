package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_009 {
	@Test
	
	public void verifyRegisteringAccountUsingExistingDetails() {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//*[@class=\"dropdown-toggle\"]//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("Motoori");
		driver.findElement(By.id("input-email")).sendKeys("amotoori1@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("12345");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@name='agree'][@value='1']")).click();
		driver.findElement(By.xpath("//*[@value=\"Continue\"]")).click();
		
		String actualAlert = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText();
		System.out.println(actualAlert);
		String expectedAlert ="Warning: E-Mail Address is already registered!";
		Assert.assertEquals(actualAlert, expectedAlert);
		
		driver.quit();
	}

}
