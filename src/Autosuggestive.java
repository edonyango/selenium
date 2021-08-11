import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Autosuggestive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");
		WebDriver foxdriver = new FirefoxDriver();
		
		foxdriver.get("https://ksrtc.in/oprs-web/guest/home.do");
		
		foxdriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys("BENG");
		foxdriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
		
		//Javascript DOM can extract hidden elements
		//because selenium cannot identify hidden elements - (Ajax implementation)
		
		//JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor)foxdriver;
		
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		String text = (String) js.executeScript(script);
		//System.out.println(text);
		int i=0;
		
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			i++;
			foxdriver.findElement(By.cssSelector("#fromPlaceName")).sendKeys(Keys.DOWN);
			text = (String) js.executeScript(script);
			System.out.println(text);
			if (i>10) {
				break;
			}
		}
		
		if(i>10) {
			System.out.println("Element not found");
		}
	}

}
