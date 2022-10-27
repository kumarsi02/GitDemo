import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticDropdown = driver.findElement(By.cssSelector("select#ctl00_mainContent_DropDownListCurrency"));
		
		//handling static dropdown
		// create object of select class. This class is defined in selenium to handle dropdowns
		//Tagname select is used for static dropsdowns
		Select dropdownValue = new Select(staticDropdown);
		dropdownValue.selectByIndex(2);
		System.out.println(dropdownValue.getFirstSelectedOption().getText());
		dropdownValue.selectByVisibleText("INR");
		System.out.println(dropdownValue.getFirstSelectedOption().getText());
		dropdownValue.selectByValue("USD");
		System.out.println(dropdownValue.getFirstSelectedOption().getText());
		
		//handling passengers count
		driver.findElement(By.id("divpaxinfo")).click();
		int i=0;
		while(i<4)
		{
		driver.findElement(By.id("hrefIncAdt")).click();
		i++;
		}
		//handling static dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='DHM']")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BHO']")).click();
		
		//handling auto suggestive dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		Thread.sleep(2000);
		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		
		for(WebElement we :options)
		{
			if (we.getText().equalsIgnoreCase("India"))
					{
					System.out.println(we);
					we.click();
					break;
					}
		}
	}

}
