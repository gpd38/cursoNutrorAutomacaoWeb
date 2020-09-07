package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Driver;

public class InicialPage {

	String elElemento = "search";
	String elTituloLivro = "//h2/a";
	String elTituloLivroLista = "h2 > a";
	String elPreco = "#product-price-44 > span";
	String elLivros = "ul.products-grid > li";
	String elPrecoLista = "span.price";

	/**
	 * @param valor
	 *            Como escolhemos usar CharSequence podemos passar os comando do
	 *            selenium. Se fosse string não funcionaria
	 */
	public void setPesquisa(CharSequence... valor) {
		WebElement pesquisa = Driver.getDriver().findElement(By.id(elElemento));
		pesquisa.sendKeys(valor);
	}

	public String getTituloLivro() {
		WebElement tituloLivro = Driver.getDriver().findElement(By.xpath(elTituloLivro));
		String livro = tituloLivro.getText();
		return livro;
	}

	public String getPreco() {
		WebElement preco = Driver.getDriver().findElement(By.cssSelector(this.elPreco));
		String valor = preco.getText();
		return valor;
	}

	public String getPrecoLista() {
		List<WebElement> listaLivros = Driver.getDriver().findElements(By.cssSelector(elLivros));
		for (WebElement elLivro : listaLivros) {
			WebElement tituloLivro = elLivro.findElement(By.xpath(elTituloLivroLista));
			String tituloLivrounitario = tituloLivro.getText();
			if (tituloLivrounitario.contains("Ajax com Java")) {
				WebElement preco = elLivro.findElement(By.cssSelector(elPrecoLista));
				return preco.getText();
			}
		}
		return null;
	}

}
