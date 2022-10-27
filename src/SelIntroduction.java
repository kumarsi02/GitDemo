import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//set path for chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		//Invoking Browser
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		//set path for Firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		//Invoking Browser
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("http://www.google.com");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		driver1.close();
		

		//set path for Edge driver
		System.setProperty("webdriver.edge.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\edgedriver_win64\\msedgedriver.exe");
		//Invoking Browser
		WebDriver driver2 = new EdgeDriver();
		driver2.get("http://www.google.com");
		System.out.println(driver2.getTitle());
		System.out.println(driver2.getCurrentUrl());
		//driver2.close();
	}

}
