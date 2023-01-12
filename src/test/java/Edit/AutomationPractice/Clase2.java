package Edit.AutomationPractice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Clase2 {
	// Seccion 1 : Atributos o Variables de uso comun
	String url = "http://automationpractice.pl";
	
	// Seccion 2: Métodos de prueba
	@Test
	public void hacerBusquedaEnChrome() 
	{
		// Acciones para poder hacer la búsqueda en el navegador Chrome
		// Paso 1. Configurar el navegador que vamos a usar
		WebDriver navegador = new ChromeDriver();
		
		// Paso 2. Abrir el navegador en la URL requerida
		navegador.get(url);
		navegador.manage().window().maximize(); // maximizo la ventana
		
		// Paso 3. Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); 
				
		// Paso 4. Hacer la búsqueda (Presionar ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionamos la tecla ENTER
		/*
		 * Si hiciéramos clic sobre el boton sería:
		WebElement btnBuscar = navegador.findElement(By.name("submit_search"));
		btnBuscar.click();
		*/
		
		System.out.println("URL Actual: " + navegador.getCurrentUrl());
		System.out.println("Título de la Página: " + navegador.getTitle());
		
		// Paso 5. Cerrar el navegador
		navegador.close();
	}
	
	@Test
	public void hacerBusquedaEnFirefox() 
	{
		// Acciones para poder hacer la búsqueda en el navegador Chrome
		// Paso 1. Configurar el navegador que vamos a usar
		WebDriver navegador = new FirefoxDriver();
		
		// Paso 2. Abrir el navegador en la URL requerida
		navegador.get(url);
		
		// Paso 3. Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); 
				
		// Paso 4. Hacer la búsqueda (Presionar ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionamos la tecla ENTER
		
		// Paso 5. Cerrar el navegador
		
	}
	
	@Test
	public void hacerBusquedaEnEdge() 
	{
		// Acciones para poder hacer la búsqueda en el navegador Chrome
		// Paso 1. Configurar el navegador que vamos a usar
		WebDriver navegador = new EdgeDriver();
		
		// Paso 2. Abrir el navegador en la URL requerida
		navegador.get(url);
		
		// Paso 3. Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); 
				
		// Paso 4. Hacer la búsqueda (Presionar ENTER)
		txtBuscador.sendKeys(Keys.ENTER); // Simula que presionamos la tecla ENTER
		
		// Paso 5. Cerrar el navegador
		
	}
}
