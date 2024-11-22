package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilies.*;

public class TC_RF_006 {
	@Test
	public void verifyRegisteringAccountByNotSubscribingToNewsletter() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://tutorialsninja.com/demo");

		driver.findElement(By.xpath("//*[@title=\"My Account\"]//span[text()='My Account']")).click();

		driver.findElement(By.xpath("//*[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("pranav");

		driver.findElement(By.name("lastname")).sendKeys("gupta");

		driver.findElement(By.xpath("//*[@type='email']")).sendKeys(CommonUtilies.generateBrandNewEmail());

		driver.findElement(By.id("input-telephone")).sendKeys("898956896");

		driver.findElement(By.id("input-password")).sendKeys("213435");

		driver.findElement(By.id("input-confirm")).sendKeys("213435");
		driver.findElement(By.xpath("//*[@type='radio'][@value='0']")).click();

		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//*[@value='Continue']")).click();

		Thread.sleep(5000);

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		driver.findElement(By.xpath("//*[@class=\"pull-right\"]//a[text()='Continue']")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@class=\"breadcrumb\"]//a[text()='Account']")).isDisplayed());

		driver.findElement(By.xpath("//*[@class=\"list-unstyled\"]//a[text()='Subscribe / unsubscribe to newsletter']"))
				.click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@name=\"newsletter\"][@value='0']")).isSelected());
		driver.quit();

	}

}
