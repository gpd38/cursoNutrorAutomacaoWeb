package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;

	@Before
	public static void abreNavegador(String url) {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
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
		;
	}

}
