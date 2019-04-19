package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(
				"D:\\Application\\eclipse-workspace\\SeleniumFramework_1\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");

		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Application\\eclipse-workspace\\All Library\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Application\\eclipse-workspace\\All Library\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browsername.equals("internetexplorer")) {
			System.setProperty("webdriver.edge.driver",
					"D:\\Application\\eclipse-workspace\\All Library\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		} else {

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenShot(String testname) throws IOException {
		LocalDateTime Time = LocalDateTime.now();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(
				"C://screenshot//" +testname+" " +Time.getDayOfMonth()+" "+ Time.getMonth()+" "+ Time.getHour()+"-"+Time.getMinute()+"-"+Time.getSecond() + ".png"));
	}

}
