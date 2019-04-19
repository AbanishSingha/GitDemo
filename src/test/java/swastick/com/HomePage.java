package swastick.com;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void UsernamePasswordNavigation(String username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated Home Page");
		LandingPage lp = new LandingPage(driver);
		lp.landingPage().click();
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getEmail().sendKeys(username);
		loginpage.getPassword().sendKeys(password);
		System.out.println(text);
		loginpage.getLogin().click();	
		log.info("Successfuly validated Message for user: "+ username);
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "ram@123";
		data[0][1] = "password1";
		data[0][2] = "Restected User";
		
		data[1][0] = "sam@123";
		data[1][1] = "password2";
		data[1][2] = "Non Restected User";
				
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser hasbeen closed\n");
	}
}
