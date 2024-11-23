package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {
@Test
	public void differentWaysToNaviagteToRegsiterPage() {
		
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//*[@class='dropdown open']//a[text()='Register']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//*[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Login']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Register Account']")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@class=\"well\"]//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		driver.findElement(By.xpath("//*[@class=\"dropdown\"]//span[text()=\"My Account\"]")).click();
		driver.findElement(By.xpath("//*[@class='dropdown open']//a[text()='Register']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@class=\"list-group\"]//a[text()='Register']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Register']")).isDisplayed());
		
		
		
		driver.quit();
		
	}
}
