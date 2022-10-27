

	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URL;
	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.asserts.SoftAssert;

public class BrokenLinkMC {
		public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			SoftAssert sa = new SoftAssert();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.zlti.com/");
			driver.manage().window().maximize();
			//Thread.sleep(20000);
			List<WebElement> le= driver.findElements(By.cssSelector("a"));
			System.out.println(le.size());
			for(WebElement we : le) {
				//System.out.println(we);
				//System.out.println(we.getAttribute("href"));
				//System.out.println(driver.getTitle());
				String url = we.getAttribute("href");
				System.out.println(url);
				//we.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
				URL ur = new URL(url);
				HttpURLConnection huc = (HttpURLConnection)ur.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				System.out.println(huc.getResponseCode());
				sa.assertTrue(huc.getResponseCode()<400, "'"+ we.getText()+"'"+ "link not working");
				//if (huc.getResponseCode()>400){
				//	System.out.println("'"+ we.getText()+"'"+ "link not working");
				//	Assert.assertTrue(false);
				//}
			}
			sa.assertAll();
			//get status code for all opened links

		}

	}

