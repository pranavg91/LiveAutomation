package register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilies.CommonUtilies;

public class TC_RF_012 {
	@Test

	public void verifyRegisteringAnAccountUsingKeyboardKeys() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://tutorialsninja.com/demo");

		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)
				.sendKeys(Keys.ENTER).build().perform();

		for (int i = 1; i <= 23; i++) {
			action.sendKeys(Keys.TAB).build().perform();

		}
		action.sendKeys("Pranav").sendKeys(Keys.TAB).sendKeys("Gupta").sendKeys(Keys.TAB).sendKeys(CommonUtilies.generateBrandNewEmail()).sendKeys(Keys.TAB).
		sendKeys("989898").sendKeys(Keys.TAB).sendKeys("12341234").sendKeys(Keys.TAB).sendKeys("12341234").sendKeys(Keys.TAB).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"list-group-item\"][text()='Logout']")).isDisplayed());

		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
	}

}
