package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilies.CommonUtilies;

public class TC_RF_003 {

	@Test

	public void verifyRegistringAccountUsingAllFields() {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();

		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("pranav");
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		

		driver.findElement(By.id("input-email")).sendKeys(CommonUtilies.generateBrandNewEmail());
		

		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("9988238918");
		driver.findElement(By.id("input-password")).sendKeys("toto1111");
		driver.findElement(By.id("input-confirm")).sendKeys("toto1111");
		driver.findElement(By.xpath("//*[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value ='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@class='pull-right']//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']//a[text()='Modify your address book entries']")).isDisplayed());

	}

}
