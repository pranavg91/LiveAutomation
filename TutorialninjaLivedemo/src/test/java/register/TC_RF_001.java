package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {
	
	@Test
	public void verifyRegisterAccountUsingMandatoryFields() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		Thread.sleep(5);		
		driver.findElement(By.id("input-firstname")).sendKeys("pranav");
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		driver.findElement(By.id("input-email")).sendKeys("pranav.gupta@gmail.com");
		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("9988238918");
		driver.findElement(By.id("input-password")).sendKeys("toto1111");
		driver.findElement(By.id("input-confirm")).sendKeys("toto1111");
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value ='Continue']")).click();
		
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		
	}

}
