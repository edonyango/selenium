import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sslcert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SSl certificates
		DesiredCapabilities fire = DesiredCapabilities.firefox();
		fire.acceptInsecureCerts();
		fire.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		fire.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//browser
		FirefoxOptions f = new FirefoxOptions();
		f.merge(fire);
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");
		WebDriver foxdriver = new FirefoxDriver(f);
		
		foxdriver.get("");
		

	}

}
