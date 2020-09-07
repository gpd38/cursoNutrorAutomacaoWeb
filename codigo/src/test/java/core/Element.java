package core;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import enums.ByValue;

public class Element {
	ByValue by;
	String map;
	WebElement webElement;

	public Element(ByValue by, String _map) {
		this.by = by;
		map = _map;
	}

	public void setWebElement(WebElement _element) {
		webElement = _element;
	}

	public WebElement getElement() {
		WebElement element = null;
		switch (by) {
		case ID:
			element = get(By.id(map));
			break;

		case XPATH:
			element = get(By.xpath(map));
			break;

		case CSS:
			element = get(By.cssSelector(map));
			break;

		case LINKTEXT:
			element = get(By.linkText(map));
			break;

		case NAME:
			element = get(By.name(map));
			break;

		default:
			break;
		}
		return element;
	}

	private WebElement get(By by) {
		if (webElement == null) {
			return Driver.getDriver().findElement(by);
		} else {
			return webElement.findElement(by);
		}
	}

	public List<WebElement> getElements() {
		List<WebElement> elements = null;
		switch (by) {
		case ID:
			elements = Driver.getDriver().findElements(By.id(map));
			break;

		case XPATH:
			elements = Driver.getDriver().findElements(By.xpath(map));
			break;

		case CSS:
			elements = Driver.getDriver().findElements(By.cssSelector(map));
			break;

		case LINKTEXT:
			elements = Driver.getDriver().findElements(By.linkText(map));
			break;

		case NAME:
			elements = Driver.getDriver().findElements(By.name(map));
			break;

		default:
			break;
		}
		return elements;
	}

	public void sendKeys(CharSequence... value) {
		getElement().sendKeys(value);
	}

	public String getText() {
		return getElement().getText();
	}

	public void click() {
		getElement().click();
	}

	public void getAttribute(String value) {
		getElement().getAttribute(value);
	}

	public void clear() {
		getElement().clear();
	}

	public void isEnabled() {
		getElement().isEnabled();
	}

	public void isDisplayed() {
		getElement().isDisplayed();
	}

	public void isSelected() {
		getElement().isSelected();
	}

	public void select(String value) {
		Select select = new Select(getElement());
		select.selectByVisibleText(value);
	}

}
