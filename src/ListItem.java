import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListItem {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //implicit wait
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); //Access the URL
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Brinjal","Carrot"};
		
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("[alt='Cart']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'cart-preview')]/div[2]/button")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name")); //store all elements in a list 
		int j=0;
		//iterate through the list to get the desired product
		for (int i= 0;i<products.size();i++) {
			String[] name = products.get(i).getText().split("-"); // Brocolli ,1Kg
			String formattedName = name[0].trim(); //remove the space after Brocolli
			//Format the name then pass to the if condition
			
			
			// check whether name you extracted is present in array
			//convert array into array list for easy search (to save memory)
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			
			
			//put a condition for the product (e.g cucumber)
			if (itemsNeededList.contains(formattedName)) {
				j++;
				//click add to cart button
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==itemsNeededList.size()) {
					break;
				}
			}
		}
	}

}
