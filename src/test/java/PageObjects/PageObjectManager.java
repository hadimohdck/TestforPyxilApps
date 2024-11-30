package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public ecommerceLandingPage ep;
	public counterpage cop;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public ecommerceLandingPage getecommerceLandingPage() {
		ep=new ecommerceLandingPage(driver);
		return ep;
	}
	public counterpage getcounterpage() {
		cop=new counterpage(driver);
		return cop;
		
	}

}
