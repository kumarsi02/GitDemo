import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class SSLcheck {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		//to bypass https error
		co.setAcceptInsecureCerts(true);
		//to open with chrome extensions
		//co.addExtensions(null)
		//disable all popup
		co.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Sidharth\\Screenshot"));
		//This is a comment for git test
	}

}
