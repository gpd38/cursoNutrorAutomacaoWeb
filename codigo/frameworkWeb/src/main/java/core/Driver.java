package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;

	@Before
	public static void abreNavegador() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public static void fechaNavegador() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUrl(String url) {
		driver.get(url);
	}

}
