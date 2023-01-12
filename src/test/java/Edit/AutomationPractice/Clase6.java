package Edit.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Clase6 {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@Parameters("navegador")
	@BeforeTest
	public void abrirNavegador(String navegador) {
		if (navegador.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (navegador.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (navegador.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	@Test
	public void buscarPalabra() {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		txtBuscador.sendKeys(Keys.ENTER);
	}
}
