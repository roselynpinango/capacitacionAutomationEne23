package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicio {
	// Atributos del Objeto (Elementos de la Página Web)
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Métodos con las Acciones que se puedan hacer
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerClicEnBuscar() {
		btnBuscar.click();
	}
	
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
}
