import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExercise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22773/nz-vs-ind-1st-t20i-india-tour-of-new-zealand-2020");
		
		WebElement table = driver.findElement(By.cssSelector("div.cb-col.cb-col-100.cb-ltst-wgt-hdr"));
		
		//int rowcount = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms")).size();
		
		//traverse to third child div:nth-child(3)
		int count = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
		
		for(int i=0;i<count-2;i++) {
			
			String value = table.findElements(By.cssSelector("div.cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();
			int valueInteger = Integer.parseInt(value);
			sum=sum+valueInteger; //51
		}
		//System.out.println(sum);
		
		String extras = table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		
		int extrasValue = Integer.parseInt(extras);
		int totalSumValue = sum+extrasValue;
		System.out.println(totalSumValue);
		
		System.out.println(table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
		
		
	}

}
