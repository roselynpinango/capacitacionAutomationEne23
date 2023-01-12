package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']")
	WebElement btnEnter;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnEnter() {
		btnEnter.click();
	}
	
	public void ingresarCredenciales(String email, String password) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(password);
		btnEnter.click();
	}
}
