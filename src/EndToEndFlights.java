import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndToEndFlights {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		Select dropdownValue = new Select(staticDropdown);
		dropdownValue.selectByIndex(2);

		driver.findElement(By.cssSelector("input[id *= originStation1_CTXT]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value = 'GOI']"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value = 'BLR'] "))
				.click();
		// div[@id*='glsctl00_mainContent_ddl_destinationStation1_CTNR']
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
		System.out.println(driver.findElement(By.cssSelector("div#Div1")).getAttribute("style"));
		if (driver.findElement(By.cssSelector("div#Div1")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id *='friendsandfamily']")).isSelected());
		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 0; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.cssSelector("input[id *='FindFlights']")).click();
	}

}
