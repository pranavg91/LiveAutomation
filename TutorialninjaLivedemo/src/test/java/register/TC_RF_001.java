package register;

import java.time.Duration;
import utilies.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilies.CommonUtilies;

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

		
		driver.findElement(By.id("input-email")).sendKeys(CommonUtilies.generateBrandNewEmail());
	

		driver.findElement(By.xpath("//input[@type ='tel']")).sendKeys("9988238918");
		driver.findElement(By.id("input-password")).sendKeys("toto1111");
		driver.findElement(By.id("input-confirm")).sendKeys("toto1111");

		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value ='Continue']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());

		String detailOne = "Your Account Has Been Created!";
		String detailTwo = "Congratulations! Your new account has been successfully created!";
		String detailThree = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String detailFour = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String detailFive = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(detailOne));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(detailTwo));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(detailThree));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(detailFour));
		Assert.assertTrue(driver.findElement(By.id("content")).getText().contains(detailFive));
		
		driver.findElement(By.linkText("Continue")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}

}
