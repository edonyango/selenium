import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\webdrivers\\IEDriverServer.exe");
		
		WebDriver iedriver = new InternetExplorerDriver();
		
		iedriver.get("https://login.salesforce.com");
		iedriver.findElement(By.id("username")).sendKeys("Demore");
		iedriver.findElement(By.name("pw")).sendKeys("pass254");
		iedriver.findElement(By.name("login")).click();
		
		iedriver.close();
	}

}
