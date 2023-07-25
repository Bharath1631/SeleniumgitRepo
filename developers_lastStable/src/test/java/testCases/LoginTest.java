package testCases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.LoginPage;
import resources.Base;
import resources.Log;
import org.openqa.selenium.support.ui.Select;

public class LoginTest extends Base {
	// public static Logger log =LogManager.getLogger(LoginTest.class.getName());
	// public static Logger log =LogManager.getLogger(LoginTest.class);
	// private static final Log logger = LogFactory.getLog(LoginTest.class);

	@Parameters("value")
	@BeforeMethod
	public void invokeBrowser(String value) throws IOException {
		driver = driverInitialize(value);

	}

	@SuppressWarnings("deprecation")
	@Test
	public void test(){
		// driver.get("https://www.google.com");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.findElement(By.id("userEmail")).sendKeys("bharathyuvi10@gmail.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Rey@6190");
		//driver.findElement(By.id("login")).click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,500)");
		//Thread.sleep(3000);
		//js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		// driver.get("https://jqueryui.com/droppable/");
		// driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		// driver.findElement(By.id("draggable")).click();
		// Actions a =new Actions(driver);
		// WebElement source =driver.findElement(By.id("draggable"));
		// WebElement target =driver.findElement(By.id("droppable"));
		// a.dragAndDrop(source, target).build().perform();

		// driver.get("https://www.amazon.com");
		// Actions a= new Actions(driver);
		// Actions b= new Actions(driver);
		// WebElement
		// move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		// a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").build()
//.perform();		
		// b.moveToElement(driver.findElement(By.cssSelector("b[id='nav-link-accountList']"))).build().perform();
		// driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/");
		// a.moveToElement(move).build().perform();

//driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
//driver.findElement(By.id("divpaxinfo")).click();
//driver.findElement(By.id("hrefIncAdt")).click();

	}

	@AfterMethod
	public void tearDown() {
		// driver.close();

	}

}
