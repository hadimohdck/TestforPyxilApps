package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class ecommerceLandingPage {
	public WebDriver driver;
	By addproduct=By.xpath("//a[@href='/add']");
	By titlefeild=By.xpath("//input[@name='title']");
	By Descriptionfeild=By.xpath("//input[@name='description']");
	By price=By.xpath("//input[@name='price']");
	public String testproductname="Test Product new"+Math.random();
	By CreateProduct=By.xpath("//button[@type='submit']");
	public String xpathofnewproduct = "//div[contains(text(), '" + testproductname + "')]";
	By ProductCreatedOnLp=By.xpath(xpathofnewproduct);
	public String xpathofeditbuttonofcreatedproduct = "(//div[contains(text(), '" + testproductname + "')])/ancestor::div[@class='sc-jXbUNg eZFFTp flex flex-col p-4']//div[@class='card-actions']/button[1]";
	By editbuttonforcreatedproduct=By.xpath(xpathofeditbuttonofcreatedproduct);
	public String editedtext="Edited Product";
	public String xpathofeditedproduct = "//div[contains(text(), '" + editedtext + "')]";
	By ProductEditedonLp=By.xpath(xpathofeditedproduct);
	public String xpathofdeletebuttonofcreatedproduct = "(//div[contains(text(), '" + editedtext + "')])/ancestor::div[@class='sc-jXbUNg eZFFTp flex flex-col p-4']//div[@class='card-actions']/button[2]";
	By deletebuttonforcreatedproduct=By.xpath(xpathofdeletebuttonofcreatedproduct);
	By searchinputfeild=By.xpath("//input[@placeholder='Search for products ...']");
	By searchresult=By.xpath("//div[contains(text(),'iphone')]");
	
	
	public ecommerceLandingPage(WebDriver driver) {	
		this.driver=driver;
		
	}
	public String gettitleofPage() {
		return driver.getTitle();
		
	}
	
	public void addproduct() {
		driver.findElement(addproduct).click();
	}
	public void filldetails() {
		driver.findElement(titlefeild).sendKeys(testproductname);
		driver.findElement(Descriptionfeild).sendKeys("This is a test product. This product is created by Hadi using Selenium and Java");
		driver.findElement(price).sendKeys("31");
	}
	
	public void CreateProduct() {
		driver.findElement(CreateProduct).click();
	}
	
	public boolean checkcreatedproductpresent() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ProductCreatedOnLp));
		boolean present = driver.findElement(ProductCreatedOnLp).isDisplayed();
		driver.findElement(editbuttonforcreatedproduct).click();
		return present;
	}
	public void editproductdetails() {
		
		driver.findElement(titlefeild).click();
		driver.findElement(titlefeild).clear();
		driver.findElement(titlefeild).sendKeys(editedtext);
		driver.findElement(CreateProduct).click();
	}
	
	public boolean checkeditedproductpresent() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(ProductEditedonLp));
		boolean present = driver.findElement(ProductEditedonLp).isDisplayed();
		return present;}
	
	public void deletecreatedproduct() {
		driver.findElement(deletebuttonforcreatedproduct).click();
	}
	
	public boolean checkdeletedproductpresent() {
		List<WebElement> elements = driver.findElements(ProductEditedonLp);
		boolean present=true;
		if(elements.size()==0)
			present=false;
		
		return present;}
	public void entersearchtext() {
		driver.findElement(searchinputfeild).sendKeys("iphone");
		
	}
	public boolean verifyresult() {
		List<WebElement> elements = driver.findElements(searchresult);
		boolean present=false;
		if(elements.size()>0)
			present=true;
		return present;
	}
	
}
