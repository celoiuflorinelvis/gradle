package ro.gradle.webapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class SayGreetingsHttpServletUnitTest {

	private WebDriver driver;
	
	
	@BeforeClass
	public static void setupClass() {
		ChromeDriverManager.getInstance().setup();
	}
	
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
	}
	
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	
	@Test
	public void greetingsTest01() {
		
		// define: HTTP_PROXY / HTTPS_PROXY
		
		driver.get("http://localhost:8080/java-web-demo");
		
		driver.findElement(By.id("greetings_name")).sendKeys("ion");
		driver.findElement(By.id("say_greetings")).click();
		
		Assert.assertEquals("Greetings!", driver.getTitle());
		Assert.assertEquals("Greetings ion!", driver.findElement(By.tagName("b")).getText());
		
	}
	
}
