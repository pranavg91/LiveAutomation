package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

	@Test
	public void verifyRegisterAccountPagewithoutFillingMandatoryDetails() throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");

		driver.findElement(By.xpath("//*[@title='My Account']")).click();

		driver.findElement(By.linkText("Register")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String actualFirstName = driver.findElement(By.xpath("//*[@name='firstname']/following-sibling::div"))
				.getText();
		String expectedFirstName = "First Name must be between 1 and 32 characters!";
		System.out.println(actualFirstName);

		Assert.assertEquals(actualFirstName, expectedFirstName);

		String actualLastName = driver.findElement(By.xpath("//*[@name='lastname']/following-sibling::div")).getText();
		String expectedLastName = "Last Name must be between 1 and 32 characters!";
		System.out.println(actualLastName);

		Assert.assertEquals(actualLastName, expectedLastName);

		String actualEmail = driver.findElement(By.xpath("//*[@name='email']//following-sibling::div")).getText();
		String expectedEmail = "E-Mail Address does not appear to be valid!";
		System.out.println(actualEmail);

		Assert.assertEquals(actualEmail, expectedEmail);

		String actualTelephone = driver.findElement(By.xpath("//*[@name='telephone']//following-sibling::div"))
				.getText();
		String expectedTelephone = "Telephone must be between 3 and 32 characters!";
		System.out.println(actualTelephone);
		Assert.assertEquals(actualTelephone, expectedTelephone);

		String actualPassword = driver.findElement(By.xpath("//*[@name='password']//following-sibling::div")).getText();
		String expectedPassword = "Password must be between 4 and 20 characters!";
		System.out.println(actualPassword);

		Assert.assertEquals(actualPassword, expectedPassword);

		Thread.sleep(5);

		String alertMessage = driver.findElement(By.xpath("//*[@class='alert alert-danger alert-dismissible']"))
				.getText();
		String expectedAlertMessage = "Warning: You must agree to the Privacy Policy!";
		System.out.println(alertMessage);
		
		Assert.assertEquals(alertMessage, expectedAlertMessage);
		driver.quit();
	}

}
