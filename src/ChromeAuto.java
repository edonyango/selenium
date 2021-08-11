import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeAuto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://essayshark.com/");
		Thread.sleep(4000);
		
		//syntax for Xpath //tagName[@attribute='value']
		driver.findElement(By.xpath("//a[@id='id_esauth_myaccount_login_link']")).click();
		driver.findElement(By.xpath("//input[@id='id_esauth_login_field']")).sendKeys("Demore");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@class='input_submit es-primary-button highlight-button']")).click();
		
		driver.close();
	}

}