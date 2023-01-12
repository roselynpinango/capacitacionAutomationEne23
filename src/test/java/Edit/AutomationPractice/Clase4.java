package Edit.AutomationPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Clase4 {
	String url = "http://automationpractice.pl";
	
	@Test
	public void irAContactanos() {
		WebDriver driver = new ChromeDriver();
		driver.navigate().to(url); // hace lo mismo que driver.get(url);
		driver.manage().window().maximize();
		
		// Paso 1: Hacer clic en "Contact Us"
		/*WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();*/
		driver.findElement(By.linkText("Contact us")).click(); // hace el clic sobre el link
		
		// Incorporar una espera explicita (preventiva)
		WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
		
		// Paso 2: Completar el formulario
		Select lista = new Select(driver.findElement(By.tagName("select")));
		lista.selectByVisibleText("Customer service");
		//lista.selectByValue("2");
		//lista.selectByIndex(1);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("correo22Dic@gmail.com");
		
		driver.findElement(By.cssSelector("#id_order")).sendKeys("123ABC");
		
		// Enviando la ruta del archivo a cargar en el formulario (elemento input oculto)
		driver.findElement(By.name("fileUpload")).sendKeys("C:\\addIntegerData.txt");
		
		driver.findElement(By.id("message")).sendKeys("Mensaje a ser enviado");
		
		// Paso 3: Hacer clic en el botón "Send"
		driver.findElement(By.xpath("//button[@id='submitMessage']")).click();
	}
}
