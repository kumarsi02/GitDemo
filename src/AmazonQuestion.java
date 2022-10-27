import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AmazonQuestion {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> itemsNeeded = new ArrayList<String>();
		itemsNeeded.add("Cauliflower");
		itemsNeeded.add("Tomato");
		itemsNeeded.add("Brinjal");
		System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver, itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[@class='action-block'] /button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	private static void addItems(WebDriver driver, ArrayList<String> itemsNeeded) {
		// TODO Auto-generated method stub
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for (int i=0;i<products.size();i++) {
			System.out.println(products.get(i).getText());
			String[] name = products.get(i).getText().split("-");
			if (itemsNeeded.contains(name[0].trim())) {
				driver.findElements(By.xpath("//a[@class='increment']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
							}
		}
	}

	}
