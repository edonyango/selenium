import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeRediff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		
		//syntax for Xpath //tagName[@attribute='value'] Regular Expression //tagName[contains(@attribute,'value')]
		//Syntax for Css selector tagName#id or tagName.className::::Regular Expression tagName[attribute*='value']
		
		
		driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();
		driver.findElement(By.cssSelector("input[id*='login']")).sendKeys("Demore");
		driver.findElement(By.cssSelector("input#password")).sendKeys("password");
		driver.findElement(By.xpath("//input[@name='proceed']")).click();
		

	}

}
