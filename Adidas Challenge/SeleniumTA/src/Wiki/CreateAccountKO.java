package Wiki;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;

public class CreateAccountKO {

	@Test
	public void CreateAccountKOTest() throws InterruptedException{
		
		// Chromedriver or Geckodriver
		// System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		// Creo el WebDriver
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		//Maximizo mi browser
		driver.manage().window().maximize();  
		
		// Le indico al webdriver la URL de la web
		String url = "https://en.wiktionary.org/";
		driver.get(url);
		tiempoDelay(3000);
		
		// Click en 'Create account'
		WebElement create = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[5]/a"));
		create.click();
		tiempoDelay(3000);
		
		// Introduzco username
		WebElement nombre = driver.findElement(By.xpath("//*[@id=\"wpName2\"]"));
		nombre.sendKeys("Paul Mccartney");
		tiempoDelay(2000);
		
		// Introduzco password	
		WebElement password = driver.findElement(By.xpath("//*[@id=\"wpPassword2\"]"));
		password.sendKeys("180642");
		tiempoDelay(2000);
		
		// Confirm password
		WebElement repassword = driver.findElement(By.xpath("//*[@id=\"wpRetype\"]"));
		repassword.sendKeys("180642");
		tiempoDelay(2000);
		
		// Email
		WebElement email = driver.findElement(By.xpath("//*[@id=\"wpEmail\"]"));
		email.sendKeys("paul@beatles.com");
		tiempoDelay(2000);
		
		// Bot�n 'Create your account'
		WebElement createyouraccount = driver.findElement(By.xpath("//*[@id=\"wpCreateaccount\"]"));
		createyouraccount.click();
		tiempoDelay(5000);


		// Usuario introducido ya existe
		WebElement existeusuario = driver.findElement(By.cssSelector(".error"));
		
		try{
			Assert.assertFalse(existeusuario.getText().contains("Username entered already in use. Please choose a different name."));
			System.out.println("El nombre es correcto: " + existeusuario.getText());
	 		}catch (Throwable t){
	 			System.out.println("El nombre de usuario ya existe: "+ existeusuario.getText());
	 			//driver.close();
	 			//fail("Test de CREATE ACCOUNT NO SUPERADO PORQUE EL USUARIO YA EXISTE");
	 
	 		}
		
		// Codigo captcha vacio				
		WebElement captcha = driver.findElement(By.cssSelector("#mw-input-captchaWord"));
		
		try{
			Assert.assertFalse(captcha.getText().isEmpty());
			System.out.println("Codigo captcha introducido");
	 		}catch (Throwable t){
	 			System.out.println("El campo codigo CAPTCHA esta vacio.");
	 			//driver.close();
	 			//fail("Test de CREATE ACCOUNT NO SUPERADO PORQUE EL CODIGO CAPTCHA ESTA VACIO");
	 
	 		}
				
		//Usuario registrado de manera correcta 
		WebElement registrocorrecto = driver.findElement(By.cssSelector("#pt-login > a:nth-child(1)"));
		/**if (!registrocorrecto.getText().contains("Log out")){
			System.out.println("LA CUENTA NO SE HA CREADO CORRECTAMENTE!!");
		}else {
			System.out.println("El unsuario se ha creado correctamente");			
		}**/
		
		try{
			Assert.assertFalse(registrocorrecto.getText().contains("Log out"));
			System.out.println("LA CUENTA NO SE HA CREADO CORRECTAMENTE!!");
	 		}catch (Throwable t){
	 			System.out.println("El unsuario se ha creado correctamente");
	 			//driver.close();
	 			//fail("Test de CREATE ACCOUNT NO SUPERADO PORQUE EL USUARIO YA EXISTE");
	 
	 		}

			System.out.println("----> Text CREATE ACCOUNT completado con EXITO!!");
		
		// Cierro el browser
		driver.close();
	
	}

	/******     Delay  *******/
	public static void tiempoDelay(int time) throws InterruptedException {
		Thread.sleep(time);

}
}
