import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");
		WebDriver foxdriver = new FirefoxDriver();
		
		foxdriver.get("https://login.salesforce.com");
		/*foxdriver.findElement(By.id("username")).sendKeys("Demore");
		foxdriver.findElement(By.name("pw")).sendKeys("pass254");
		foxdriver.findElement(By.name("Login")).click(); */
		
		foxdriver.findElement(By.cssSelector("input[id='username']")).sendKeys("Demore");
		foxdriver.findElement(By.cssSelector("input[name='pw']")).sendKeys("Password");
		foxdriver.findElement(By.cssSelector("input[id='Login']")).click();
		
		System.out.println(foxdriver.findElement(By.cssSelector("div[id ='error']")).getText());
		
		foxdriver.close();
		
	}

}