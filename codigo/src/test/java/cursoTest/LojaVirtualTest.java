package cursoTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import core.Driver;
import pages.InicialPage;

public class LojaVirtualTest extends BaseTest {

	InicialPage inicialPage = new InicialPage();

	@Test
	public void testPesquisaLivro() throws InterruptedException {
		inicialPage.setPesquisa("fortaleza digital", Keys.ENTER);
		String livro = inicialPage.getTituloLivro();
		Assert.assertEquals("[PRODUTO DE EXEMPLO] - Fortaleza Digital", livro);
		String preco = inicialPage.getPreco();
		Assert.assertEquals("R$519,90", preco);
	}

	@Test
	public void pesquisaLivroAssertThat() {
		inicialPage.setPesquisa("fortaleza digital", Keys.ENTER);
		String livro = inicialPage.getTituloLivro();
		Assert.assertEquals("[PRODUTO DE EXEMPLO] - Fortaleza Digital", livro);

		WebElement elPreco = Driver.getDriver().findElement(By.cssSelector("#product-price-44 > span"));
		String preco = elPreco.getText();

		assertThat("R$519,90", is(preco));
		assertThat("R$519,908", containsString(preco));
	}

	@Test
	public void testClickLista() {
		inicialPage.setPesquisa("html", Keys.ENTER);
		String preco = inicialPage.getPrecoLista();
		assertThat("R$444,50", is(preco));
	}
}
