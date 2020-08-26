package cursoTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class LojaVirtualTest extends BaseTest {

	@Test
	public void pesquisaLivro() throws InterruptedException {
		WebElement pesquisa = driver.findElement(By.id("search"));
		// Opção 1
		// pesquisa.sendKeys("fortaleza digital");
		// pesquisa.sendKeys(Keys.ENTER);

		// Opção 2
		pesquisa.sendKeys("fortaleza digital", Keys.ENTER);

		WebElement elTituloLivro = driver.findElement(By.xpath("//h2/a"));
		String livro = elTituloLivro.getText();

		Assert.assertEquals("[PRODUTO DE EXEMPLO] - Fortaleza Digital", livro);
		Thread.currentThread().sleep(5000);

		// #   -> id
		// .   -> class
		// ' ' -> tag

		WebElement elPreco = driver.findElement(By.cssSelector("#product-price-44 > span"));
		String preco = elPreco.getText();
		Assert.assertEquals("R$519,90", elPreco);

	}

}
