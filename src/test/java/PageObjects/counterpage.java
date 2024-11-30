package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

public class counterpage {
	
	public WebDriver driver;
	

	
	public counterpage(WebDriver driver) {	
		this.driver=driver;
		
	}
	public void clickonplusbutton() throws InterruptedException {
		



		String script = "document.querySelector('flt-glass-pane').shadowRoot.querySelector('flt-semantics-placeholder').click();";
		((JavascriptExecutor) driver).executeScript(script);

		// Wait for the DOM to update
		Thread.sleep(2000); // Adjust the sleep time as needed

		// Locate the "plus" button using XPath
		WebElement plusButton = driver.findElement(By.xpath("//flt-semantics[contains(@aria-label, 'Increment')]"));

		// Click the "plus" button

		System.out.println("click executed");

		// Locate the counter text element
		WebElement counterNumberElement = driver.findElement(By.xpath("//flt-semantics[@role='text' and contains(@aria-label, 'You have pushed')]//following-sibling::flt-semantics[@role='text']"));


		// Initialize the click counter
		int clickCount = 0;

		// Perform 5 clicks on the "plus" button
		for (int i = 0; i < 5; i++) {
			plusButton.click();
			clickCount++;

			// Retrieve the updated number displayed on the page
			String displayedNumber = counterNumberElement.getAttribute("aria-label");
			System.out.println(displayedNumber);

			// Extract the actual number from the string (e.g., if it's part of a larger label)
			int displayedCount = Integer.parseInt(displayedNumber);

			// Validate that the displayed number matches the click count
			if (displayedCount != clickCount) {
				System.out.println("Mismatch detected! Click count: " + clickCount + ", Displayed count: " + displayedCount);
			} else {
				System.out.println("Click count matches: " + displayedCount);
			}
		}
	}
}
