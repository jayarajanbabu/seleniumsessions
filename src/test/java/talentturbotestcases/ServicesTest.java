package talentturbotestcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServicesTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void servicesTest() {
		driver.get("https://www.talentturbo.us/services.html");
		
		List<WebElement> headersList = driver.findElements(By.xpath("//div[@class='card-body']//h2"));
		
		for(WebElement e: headersList) {
			String text = e.getText();
			System.out.println(text);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
