import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Sidharth\\Selenium\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows=driver.getWindowHandles();           //windows variable will get both parent id and childid
		System.out.println(windows);
		String win[] = windows.toArray(new String[windows.size()]);   //convert list of strings to array of strings
		System.out.println(win[0]);
		System.out.println(win[1]);
		//Iterator<String> it= windows.iterator();
		//String parent = it.next();
		//System.out.println(parent);
		//String child = it.next();
		//System.out.println(child);
		driver.switchTo().window(win[1]);
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText().split(" ")[4]);
		String emailId = driver.findElement(By.cssSelector("p.im-para.red")).getText().split(" ")[4];
		//String s = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		//Array<String> strings = s.split(" ");
		driver.switchTo().window(win[0]);
		driver.findElement(By.id("username")).sendKeys(emailId);
	}

}
