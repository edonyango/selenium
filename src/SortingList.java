import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click the sort button twice to sort in ascending order
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click(); //2nd click
		
		List<WebElement> firstColumn = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> originalList = new ArrayList<String>();
		for(int i=0;i<firstColumn.size();i++) {
			originalList.add(firstColumn.get(i).getText());
		}
		ArrayList<String> copiedList = new ArrayList<String>();
		for(int i=0;i<originalList.size();i++) {
			copiedList.add(originalList.get(i));
		}
		//sort in ascending order
		Collections.sort(copiedList);
		//sort in descending order
		Collections.reverse(copiedList);
		
		Assert.assertTrue(originalList.equals(copiedList));
	}

}
