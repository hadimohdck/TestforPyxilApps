package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class counterpage {
	
	public WebDriver driver;
	
	By plusbutton=By.cssSelector("label#ftl-announcement-polite");
	
	public counterpage(WebDriver driver) {	
		this.driver=driver;
		
	}
	public void clickonplusbutton() throws InterruptedException {
		
//	((JavascriptExecutor) driver).executeScript("arguments[0].style.visibility = 'visible';" +  // Make it visible
//		    "arguments[0].style.position = 'absolute';" +   // Set position to absolute
//		    "arguments[0].style.transform = 'none';" +      // Remove any transformations
//		    "arguments[0].style.width = 'auto';" +          // Set width to auto (or any desired size)
//		    "arguments[0].style.height = 'auto';" +         // Set height to auto (or any desired size)
//		    "arguments[0].scrollIntoView(true);" +          // Scroll into view (if needed)
//		    "arguments[0].click();", driver.findElement(plusbutton));
		 // Locate the shadow host element
		

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Set the canvas to be visible
		js.executeScript(
		    "document.querySelector('flt-scene-host > flt-scene > flt-canvas-container > canvas').style.visibility = 'visible';" +
		    "document.querySelector('flt-scene-host > flt-scene > flt-canvas-container > canvas').style.display = 'block';"
		);

		// Now interact with the canvas
		WebElement canvas = driver.findElement(By.cssSelector("flt-scene-host > flt-scene > flt-canvas-container > canvas"));
		int xOffset = 380;
		int yOffset = 580;

		Actions actions = new Actions(driver);
		actions.moveToElement(canvas, xOffset, yOffset).click().perform();

	
	}
	// Use Actions to click
	
	

}
