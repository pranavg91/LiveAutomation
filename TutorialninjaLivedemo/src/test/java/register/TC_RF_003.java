package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {
	
	@Test

	public void verifyRegisterAccountUsingAllFields() {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();   
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("pranav");
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		driver.findElement(By.id("input-email")).sendKeys("pranav.gupta1@gmail.com");
		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("9988238918");
		driver.findElement(By.id("input-password")).sendKeys("toto1111");
		driver.findElement(By.id("input-confirm")).sendKeys("toto1111");
		driver.findElement(By.xpath("//*[text()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value ='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
	}

}
