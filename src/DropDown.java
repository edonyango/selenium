import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");

		WebDriver foxdriver = new FirefoxDriver();
		
		//accessing the URL
		foxdriver.get("https://www.spicejet.com/");
		
		//CHECKING IF THE RETURN DATE DIV IS INACTIVE
		
		//foxdriver.findElement(By.cssSelector(".picker-second")).getAttribute("style");
		foxdriver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		foxdriver.findElement(By.cssSelector(".picker-second")).getAttribute("style");
		
		if (foxdriver.findElement(By.cssSelector(".picker-second")).getAttribute("style").contains("1"))
		{
			System.out.println("It's Enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		//STATIC DROPDOWN AUTOMATION
		foxdriver.findElement(By.cssSelector("#divpaxinfo")).click();
		//configuring the select class to test dropdown radio
		Select adult = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		adult.selectByValue("2");
		Select child = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		child.selectByIndex(3);
		Select infant = new Select(foxdriver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		infant.selectByVisibleText("1"); 
		
		//CHECKBOXES
		
		Assert.assertFalse(foxdriver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		foxdriver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		Assert.assertTrue(foxdriver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		
		//count number of checkboxes
		System.out.println(foxdriver.findElements(By.cssSelector("*[type='checkbox']")).size());
		
		
		//BUTTON ENTRY AUTOMATION 
		
		/* 	Using while/for loop to click on a button 4 times
		  	int i=1;
		 	while(i<5)
		 	{
		 		foxdriver.findElement(By.id("ctl00_mainContent_ddl_Infant").click();
		 		i++
		 	}
		 	
		 	for (int i=1;i<5;i++)
		 	{
		 		foxdriver.findElement(By.id("ctl00_mainContent_ddl_Infant").click();
		 	}
		 */
		
		//DYNAMIC DROPDOWN AUTOMATION 
		/*
		foxdriver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		foxdriver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='KQH']")).click();
		//foxdriver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		//foxdriver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click(); //using index
		foxdriver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click(); //using parent-child Xpath traversing 
		
		//SELECTING CURRENT DATE
		foxdriver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		*/
	}

}
