package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005 {
	@Test
	public void verifyRegisteringAccountUsingNewsletterAsYes() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("pranav");
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		
		String randomEmail = "toto.gupta" + System.currentTimeMillis() + "@gmail.com";
		
		WebElement email= driver.findElement(By.id("input-email"));
		
		email.sendKeys(randomEmail);
		
		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("9988238918");
		driver.findElement(By.id("input-password")).sendKeys("toto1111");
		driver.findElement(By.id("input-confirm")).sendKeys("toto1111");
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
		driver.findElement(By.xpath("//*[@name='agree']")).click();
		driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
		
		
		driver.findElement(By.linkText("Continue")).click();
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Yes ']")).isDisplayed(), "Passed Case");

	}

}