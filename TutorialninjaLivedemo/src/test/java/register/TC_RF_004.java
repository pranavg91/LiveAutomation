package register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

	@Test
	public void verifyRegisterAccountPagewithoutFillingMandatoryDetails() {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//*[@title='My Account']")).click();
		
		driver.findElement(By.linkText("Register")).click();
		
		
		driver.findElement(By.xpath("//*[@name='agree']")).click();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String actualFirstName =driver.findElement(By.xpath("//*[@name='firstname']/following-sibling::div")).getText();
		String ExpectedFirstName ="First Name must be between 1 and 32 characters!";
		System.out.println(actualFirstName);
		
		Assert.assertEquals(actualFirstName, ExpectedFirstName);
		
		
		
		
		
		

	}

}
