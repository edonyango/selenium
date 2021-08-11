import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");
		WebDriver foxdriver = new FirefoxDriver();
		
		foxdriver.manage().window().maximize();
		foxdriver.manage().deleteAllCookies();
		//foxdriver.manage().deleteCookieNamed("asdf"); //cookie name "asdf"
		
		//Delete session cookie, secure login locks out and navigates back to home page
		//foxdriver.manage().deleteCookieNamed("sessionKey"); //session cookie name "sessionKey"
		
		foxdriver.get("http://google.com");
		
		//enable driver to take screenshot 
		File src = ((TakesScreenshot)foxdriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D://screenshot.png"));
		
	}

}
