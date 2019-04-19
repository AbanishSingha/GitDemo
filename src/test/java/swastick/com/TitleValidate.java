package swastick.com;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.LandingPage;
import pageobject.LoginPage;
import resources.Base;

public class TitleValidate extends Base {
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
	}

	@Test
	public void TitleNavigation() throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
//		Assert.assertEquals(lp.getTitle().getText(), "Featured Courses");
		Assert.assertTrue(lp.getNavbar().isDisplayed());
		log.info("Navigation Bar displayed Successfully");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
		log.info("Browser hasbeen closed\n");
	}

}
