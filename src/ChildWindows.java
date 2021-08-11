import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.paypal-mobilemoney.com/m-pesa");
		driver.findElement(By.cssSelector("#navi-log-in")).click();
		System.out.println(driver.getTitle());
		
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//switch to child window
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		//switch to parent window
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		
	}

}
