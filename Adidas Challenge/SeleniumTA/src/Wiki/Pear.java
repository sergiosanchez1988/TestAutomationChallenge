package Wiki;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;
import org.junit.Assert;
import org.junit.Test;


public class Pear {

	@Test
	public void PearTest() throws InterruptedException {
		
		// Chromedriver or Geckodriver
		// System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");	
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

		// Creo el WebDriver (Obj que contiene lo necesario para controlar el browser)	
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();

		//Maximizo mi browser
		driver.manage().window().maximize();  
		
		// Le indico al webdriver la URL de la web
		String url = "https://en.wiktionary.org/";
		driver.get(url);
		tiempoDelay(3000);
		
		// Login with user and password
		WebElement login = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[6]/a"));
		login.click();
		tiempoDelay(3000);
				
		String usuario ="SergioSanchez1988";
		WebElement user = driver.findElement(By.xpath("//*[@id=\"wpName1\"]"));
		user.sendKeys(usuario);
		tiempoDelay(3000);
		
		String contraseña = "87654321";
		WebElement pass = driver.findElement(By.xpath("//*[@id=\"wpPassword1\"]"));
		pass.sendKeys(contraseña);
		tiempoDelay(3000);
				
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"wpLoginAttempt\"]"));
		loginButton.click();
		tiempoDelay(3000);
		
	    // Comprobación de que el log in es correcto
		WebElement loginok = driver.findElement(By.cssSelector("#pt-userpage > a:nth-child(1)"));
		
		try{
		Assert.assertEquals(loginok.getText(), "SergioSanchez1988");
		System.out.println("Usuario "+ loginok.getText()+ " logueado correctamente");
 		}catch (Throwable t){
 			System.out.println("Usuario "+ loginok.getText()+ " NO se ha logueado correctamente");
 			driver.close();
 			fail("Test de login NO SUPERADO");
 			System.out.println("----> Text BUSQUEDA PEAR completado con EXITO!!");
 
 		}
		
		//Busco la palabra 'pear' usando WebElement
		WebElement search = driver.findElement(By.name("search"));
		search.sendKeys("pear");
		tiempoDelay(4000);
		
		// Click en el botón de la lupa
		WebElement lookupButton = driver.findElement(By.name("go"));
		lookupButton.click();
		tiempoDelay(4000);
		
	     
	    // Comprobación de que la definición de pear es correcta
		WebElement definicion = driver.findElement(By.cssSelector(".mw-parser-output > ol:nth-child(13) > li:nth-child(1)"));
		
		try{
			Assert.assertTrue(definicion.getText().contains("An edible fruit produced by the pear tree, similar to an apple but elongated towards the stem."));
			System.out.println("La definicion es correcta: " + definicion.getText());
	 		}catch (Throwable t){
	 			System.out.println("No aparece la definición correcta para la palabra PEAR");
	 			driver.close();
	 			fail("Test de SEARCH PEAR NO SUPERADO");
	 			System.out.println("----> Text BUSQUEDA PEAR completado con EXITO!!");
	 
	 		}		

		System.out.println("----> Text BUSQUEDA PEAR completado con EXITO!!");
		
		// Cierro el browser
		driver.close();

	}
	
    /******     Delay  *******/
    public static void tiempoDelay(int time) throws InterruptedException {
        Thread.sleep(time);

    }

}
