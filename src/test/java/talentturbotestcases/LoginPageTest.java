package talentturbotestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void loginTest() {
		driver.get("https://main.talentturbo.us/login");
		driver.findElement(By.name("email")).sendKeys("seleniumjan2022@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@123");
		WebElement dropDown = driver.findElement(By.id("userType"));
		
		Select selectDD = new Select(dropDown);
		selectDD.selectByVisibleText("Interviewer");
		WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
		
		Actions action = new Actions(driver);
		action.click(loginBtn).build().perform();
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
