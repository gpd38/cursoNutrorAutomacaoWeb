package cursoTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.Driver;

public class BaseTest {

	@Before
	public void abreNavegador() {
		Driver.abreNavegador("https://lojaexemplod.lojablindada.com");
	}

	@After
	public void fechaNavegador() {
		Driver.fechaNavegador();
	}

}
