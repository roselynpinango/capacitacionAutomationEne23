package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase8Test {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.escribirPalabra("dress");
		inicio.hacerClicEnBuscar();
	}
	
	@Test(dataProvider="Datos Login")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnEnter();
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() throws Exception {
		return DatosExcel.leerExcel(
				"..\\AutomationPractice\\Datos\\Datos_Login.xlsx", 
				"Hoja1");
	}
}
