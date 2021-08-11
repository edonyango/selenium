import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");
		
		//April 14
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		//List <WebElement> dates = driver.findElements(By.className("ui-state-default"));
		int count = driver.findElements(By.className("ui-state-default")).size();
		
		for (int i=0;i<count;i++) {
			
			String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("14")) {
				
				driver.findElements(By.className("ui-state-default")).get(i).click();
				break;
			}
			
		}
		
	}

}
