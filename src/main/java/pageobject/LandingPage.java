package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	By singin = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//*[@id='content']/div/div/h2");
	By navbar = By.xpath("//nav[@class='navbar-collapse collapse----']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement landingPage() {
		return driver.findElement(singin);
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}
}
