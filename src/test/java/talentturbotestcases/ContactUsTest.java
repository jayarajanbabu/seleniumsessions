package talentturbotestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void companyNameTest() {
		driver.get("https://talentturbo.com/contactus.html");
		String companyName = driver.findElement(By.xpath("//div[@class='card-body']//h2")).getText();
		System.out.println(companyName);
		Assert.assertEquals(companyName, "Talentturbo Technologies LLC");
	}
	
	@Test (priority = 2)
	public void addressTest() {
		driver.get("https://talentturbo.com/contactus.html");
		String actAddress = driver.findElement(By.cssSelector(".card-body address")).getText();
		System.out.println(actAddress);
		if (actAddress.contains("691 S Milpitas Blvd")) {
			System.out.println("Address is correct");
		} else {
			System.out.println("Address is incorrect");
		}
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
