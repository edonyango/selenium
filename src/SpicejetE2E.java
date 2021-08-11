import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpicejetE2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");

		WebDriver foxdriver = new FirefoxDriver();

		// accessing the URL
		foxdriver.get("https://www.spicejet.com/");

		// SELECTING FROM AND TO DROPDOWNS

		foxdriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		foxdriver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='KQH']"))
				.click();
		// foxdriver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		// foxdriver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click(); //using
		// index
		foxdriver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']"))
				.click(); // using parent-child Xpath traversing

		// CHECKING IF THE RETURN DATE DIV IS INACTIVE

		// foxdriver.findElement(By.cssSelector(".picker-second")).getAttribute("style");
		// //return date div
		// foxdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		// //click round trip button

		if (foxdriver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("0.5")) {
			System.out.println("It's Disabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// SELECTING CURRENT DATE

		foxdriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		// SELECTING PASSENGERS

		foxdriver.findElement(By.cssSelector("#divpaxinfo")).click();
		// configuring the select class to test dropdown radio
		Select adult = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("2");
		Select child = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByIndex(3);
		Select infant = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByVisibleText("1");

		// SELECTING CURRENCY

		Select cur = new Select(foxdriver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		cur.selectByVisibleText("USD");

		// SELECT RADION BUTTONS (PASSENGER TYPE)

		foxdriver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		Assert.assertTrue(
				foxdriver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());

		// CLICK SEARCH BUTTON

		foxdriver.findElement(By.xpath("//input[contains(@id,'FindFlights')]")).click();
	}

}
