package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_010 {
	@Test
	public void registeringAnAccountWithInvalidEmailId() throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://tutorialsninja.com/demo");

		driver.findElement(By.xpath("//span[text() ='My Account']")).click();
		driver.findElement(By.xpath("//*[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()='Register']")).click();
		driver.findElement(By.xpath("//*[@name=\"firstname\"][@id='input-firstname']")).sendKeys("Arun");
		driver.findElement(By.id("input-lastname")).sendKeys("motoori");
		driver.findElement(By.id("input-telephone")).sendKeys("868989756");
		driver.findElement(By.id("input-password")).sendKeys("34345");
		driver.findElement(By.xpath("//*[@type='password'][@id='input-password']")).sendKeys("34345");
		driver.findElement(By.xpath("//*[@name='agree'][@value='1']")).click();
		driver.findElement(By.id("input-email")).sendKeys("motoori");
		driver.findElement(By.xpath("//*[@value='Continue']")).click();
		Thread.sleep(3000);
		
		String expectedError1 = "Please include an '@' in the email address. 'motoori' is missing an '@'.";
		String actualerror1 = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		Assert.assertEquals(actualerror1, expectedError1);

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@");
		driver.findElement(By.xpath("//*[@value='Continue']")).click();

		String expectedError2 = "Please enter a part following '@'. 'amotoori@' is incomplete.";
		String actualError2 = driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		Assert.assertEquals(actualError2, expectedError2);

		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail");
		driver.findElement(By.xpath("//*[@value='Continue']")).click();
		
		String expectedError3 ="E-Mail Address does not appear to be valid!";
		
		String actualError3 = driver.findElement(By.xpath("//*[@name=\"email\"]//following-sibling::div")).getText();
		Assert.assertEquals(actualError3,expectedError3);
		
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("amotoori@gmail.");
		driver.findElement(By.xpath("//*[@value='Continue']")).click();
		
		String actualError4= driver.findElement(By.id("input-email")).getAttribute("validationMessage");
		String expectedError4 ="'.' is used at a wrong position in 'gmail.'.";
		
		Assert.assertEquals(actualError4, expectedError4);
		
		
		
		Thread.sleep(4000);
		driver.quit();

	}
}
