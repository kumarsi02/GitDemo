import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String name = "Sid";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//identify by id
		driver.findElement(By.id("inputUsername")).sendKeys("sidharthkm");
		//identify by name
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		//identify by class name
		driver.findElement(By.className("signInBtn")).click();
		
		//identify by css:
		// Format - tagname.classname or tagname#id or tagname[attribute='value']
		String errormsg = driver.findElement(By .cssSelector("p.error")).getText();
		System.out.println(errormsg);
		String errormsg1 = driver.findElement(By .cssSelector("p[class='error']")).getText();
		System.out.println(errormsg1);
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//identify by xpath:
		//tagname[@attribute='value']
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("sid@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9789098055");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//driver.findElement(By.cssSelector("button[class='go-to-login-btn']")).click();
		//driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'pwd')]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder*='Usern']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(), "Hello "+name+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		System.out.println("successfully logged out");
		driver.close();
	}

}
