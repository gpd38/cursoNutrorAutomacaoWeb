package pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import map.InicialMap;

public class InicialPage {

	InicialMap inicialMap = new InicialMap();
	String elTituloLivroLista = "h2 > a";
	String elLivros = "ul.products-grid > li";
	String elPrecoLista = "span.price";

	/**
	 * @param valor
	 *            Como escolhemos usar CharSequence podemos passar os comando do
	 *            selenium. Se fosse string não funcionaria
	 */
	public void setPesquisa(CharSequence... valor) {
		inicialMap.pesquisa.sendKeys(valor);
	}

	public String getTituloLivro() {
		String livro = inicialMap.tituloLivro.getText();
		return livro;
	}

	public String getPreco() {
		return inicialMap.preco.getText();
	}

	public String getPrecoLista() {
		List<WebElement> livros = inicialMap.livros.getElements();
		for (WebElement elLivro : livros) {
			inicialMap.tituloLivroLista.setWebElement(elLivro);
			String titulo = inicialMap.tituloLivroLista.getText();
			if (titulo.contains("Ajax com Java")) {
				inicialMap.precoLista.setWebElement(elLivro);
				return inicialMap.precoLista.getText();
			}
		}
		return null;
	}
}
