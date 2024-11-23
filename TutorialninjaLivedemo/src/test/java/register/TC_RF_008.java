package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilies.*;
public class TC_RF_008 {
	
	@Test
	public void registeringAccountUsingDifferentPasswordInConfirmPasswordField() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//*[@class=\"dropdown\"]//span[text()='My Account']")).click();
		
		driver.findElement(By.xpath("//*[@class=\"dropdown open\"]//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Pranav");
		driver.findElement(By.id("input-firstname")).sendKeys("Pranav");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Gupta");
		
		driver.findElement(By.id("input-email")).sendKeys(CommonUtilies.generateBrandNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("90034999");
		driver.findElement(By.id("input-confirm")).sendKeys("abcde");
		driver.findElement(By.xpath("//*[@value='Continue']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@type='password']//following-sibling::div")).isDisplayed());
		String actualWarningMessage = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']")).getText();
		String expectedWarningMessage ="Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		driver.quit();
		
	}

}
