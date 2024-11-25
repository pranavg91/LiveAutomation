package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TC_RF_013 {

	WebDriver driver;

	@AfterMethod
	public void teardown() {

		driver.quit();
	}

	@Test
	public void verifyPlaceHolderOnRegisteringAccount() {

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://tutorialsninja.com/demo");

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()='Register']"))
				.click();

		String firstNamePlaceholder = driver.findElement(By.id("input-firstname")).getAttribute("placeholder");
		System.out.println("firstName Placeholder value is: " +  firstNamePlaceholder);

		String lastName = driver.findElement(By.id("input-lastname")).getAttribute("placeholder");
		System.out.println(lastName);

		String emailID = driver.findElement(By.id("input-email")).getAttribute("placeholder");
		System.out.println(emailID);

		String telephone = driver.findElement(By.id("input-telephone")).getAttribute("placeholder");
		System.out.println(telephone);

		String passwordPlaceholder = driver.findElement(By.id("input-password")).getAttribute("placeholder");
		System.out.println(passwordPlaceholder);

		String passwordConfirmPlaceholder = driver.findElement(By.id("input-confirm")).getAttribute("placeholder");
		System.out.println(passwordConfirmPlaceholder);

	}
}
