package automate;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateCheckBox {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Abderrahim\\Aug2020_selenium\\Automation\\Drivers\\chromedriver.exe");

	}

	@Test
	public void test() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}

	public void validate() throws InterruptedException {

		WebElement toggle = driver.findElement(By.xpath("//div[@class='controls']//input[@type='checkbox']"));
		toggle.click();
		Thread.sleep(3000);
		Assert.assertTrue(checkBox());

	}

	public boolean checkBox() {

		boolean result = false;

		if ((driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"))).isDisplayed()
				&& (driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"))).isDisplayed()) {
			result = true;

		}
		return result;
	}

	@After
	public void TearDown() {

		driver.close();
		driver.quit();

	}

}
