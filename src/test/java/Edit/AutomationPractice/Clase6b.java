package Edit.AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DatosExcel;

public class Clase6b {
	String url = "http://automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirNavegador() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@Test(dataProvider="Datos Login")
	public void login(String email, String password) {	
		driver.findElement(By.partialLinkText("Sign")).click();
		
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(password);
		driver.findElement(By.cssSelector("#SubmitLogin")).click();
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] leerDatosLogin() throws Exception {
		return DatosExcel.leerExcel(
								"..\\AutomationPractice\\Datos\\Datos_Login.xlsx", 
								"Hoja1");
	}
	
	@AfterSuite
	public void cerrarNavegador() {
		driver.close();
	}
}
