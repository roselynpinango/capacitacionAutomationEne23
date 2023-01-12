package Edit.AutomationPractice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Utilities.CapturaEvidencia;

public class Clase5 {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	File pantalla;
	String rutaEvidencia = "..\\AutomationPractice\\Evidencias\\";
	String nombreDocumento = "Evidencia AutomationPractice.docx";
	
	// Método para configurar qué navegador vamos a usar y abrirlo
	@BeforeSuite
	public void abrirNavegador() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	// Método con el caso de prueba
	@Test(description="CP01 - Formulario de Contacto", priority=100)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencias
		CapturaEvidencia.escribirTituloEnDocumento(rutaEvidencia + nombreDocumento, "Documento de Evidencias AutomationPractice", 18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg", rutaEvidencia + nombreDocumento, "Paso 1 - Página Inicial");
		
		// Paso 1: Hacer clic en "Contact Us"
		/*WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();*/
		driver.findElement(By.linkText("Contact us")).click(); // hace el clic sobre el link
		
		// Incorporar una espera explicita (preventiva)
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
				
		// Captura de Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg", rutaEvidencia + nombreDocumento, "Paso 2 - Dentro de Contact Us");
		
		// Paso 2: Completar el formulario
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Customer service");
		//lista.selectByValue("2");
		//lista.selectByIndex(1);
				
		Faker faker = new Faker();
		String email = faker.internet().emailAddress();
		//int numeroAleatorio = faker.random().nextInt(1, 1000);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
				
		driver.findElement(By.cssSelector("#id_order")).sendKeys("123ABC");
				
		// Enviando la ruta del archivo a cargar en el formulario (elemento input oculto)
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
				
		driver.findElement(By.id("message")).sendKeys("Mensaje a ser enviado");
				
		// Captura de Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg", rutaEvidencia + nombreDocumento, "Paso 3 - Formulario lleno");
		
		// Paso 3: Hacer clic en el botón "Send"
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
		
		// Captura de Evidencias
		CapturaEvidencia.capturarPantallaEnDocumento(driver, rutaEvidencia + "img.jpg", rutaEvidencia + nombreDocumento, "Paso 4 - Al enviar el formulario");
	}
	
	@Test(description="CP02 - Búsqueda de Palabras", priority=200)
	public void buscarPalabra() throws IOException {
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencia + "01_pantallaPrincipal.jpg"));
		
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencia + "02_palabraABuscar.jpg"));
		
		driver.findElement(By.name("submit_search")).click();
		
		// Captura de Evidencia
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(rutaEvidencia + "03_resultadoObtenido.jpg"));
		
		// Comprobar que luego de la búsqueda
		// * El título nuevo será Search - My Store
		// * La URL nueva será..
		String urlEsperada = "http://automationpractice.pl/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=";
		String tituloEsperado = "Search - My Store";
		String urlActual = driver.getCurrentUrl();
		String tituloActual = driver.getTitle();
		
		Assert.assertEquals(urlActual, urlEsperada);
		Assert.assertEquals(tituloActual, tituloEsperado);
		/*Assert.assertNotEquals("", "");
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		Assert.assertNull(tituloActual);*/
	}
	
	// Método para cerrar el navegador
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}

