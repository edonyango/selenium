import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// AUTO SUGGESTING DROPDOWN (using button keys)

		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.id("fromCity")).click();

		WebElement origin = driver.findElement(By.xpath("//input[@placeholder='From']"));

		origin.sendKeys("del");
		Thread.sleep(3000);

		for (int i = 1; i < 6; i++) {
			origin.sendKeys(Keys.ARROW_DOWN); // click arrow down keys 5 times
		}

		origin.sendKeys(Keys.ENTER); // click enter keys

		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));

		destination.sendKeys("tel");
		Thread.sleep(3000);

		for (int i = 1; i < 5; i++) {
			destination.sendKeys(Keys.ARROW_DOWN);
		}

		destination.sendKeys(Keys.ENTER);
	}

}
