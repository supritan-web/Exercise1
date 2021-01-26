package com.wikipedia.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;

public class ContentsHeadingsPage extends PageObject {

	@FindBy(xpath = "//*[@id=\"toc\"]/ul")
	WebElement contentList;
	
	@FindBy(xpath = "//*[@id=\"mw-content-text\"]/div[1]")
	WebElement contentListHeader;

	@FindBy(xpath = "//*[@href=\"/wiki/Nike_(mythology)\"]")
	WebElement personifiedConcepts;
	
	@Step
	public void launchApplication() {
		open();
		
	}
	
	@Step
	public void list() {
		List<WebElement> links = contentList.findElements(By.tagName("li"));
		
		for (int i = 0; i < links.size(); i++)
		{
			
		    System.out.println(links.get(i).getText());
		    links.get(i).click();
		}
	}
	
	@Step
	public void validatelistHeadings() {
		List<WebElement> links = contentList.findElements(By.tagName("li"));
		
		for (int i = 0; i < links.size(); i++)
		{
		    
		    // validate if it a header (tag is a header)
		    List<WebElement> listHeader = contentListHeader.findElements(By.tagName("h2"));
		    
		    	if (listHeader.get(i+1).getText().contains(links.get(i).getText().substring(2))) 
		    	 System.out.println(links.get(i).getText().substring(2) + " is a header");
		    else
		    	System.out.println(links.get(i).getText().substring(2) + " is not a header");
		}
	}

	@Step
	public void validatelistClickable() {
		List<WebElement> links = contentList.findElements(By.tagName("li"));
		
		for (int i = 0; i < links.size(); i++)
		{
			String clickable = links + "[" + i+1 + "]/a" ;
		}
	}
	
	
	@Step @Test
	public void personifiedConcepts() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/Metis_(mythology)");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 900)");
		Actions builder = new Actions(driver);
		
		WebElement perCon = driver.findElement(By.xpath("//a[text()='Nike']"));
		
		// (c) in the _Personified concepts_, `Nike` has a popup that contains the following text:
		// In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.

		builder.moveToElement(perCon).perform();
		
		Thread.sleep(7000);
		WebElement perText = driver.findElement(By.xpath("//a[@class='mwe-popups-extract']/p"));
			
		assertEquals("In ancient Greek civilization, Nike was a goddess who personified victory. Her Roman equivalent was Victoria.", perText.getText());
		
		perCon.click();
		
		// (d) in the _Personified concepts_, if you click on `Nike`, it takes you to a page that displays a family tree
		
		WebElement perNike = driver.findElement(By.xpath("//*[@id='Family_tree']"));
		System.out.println(perNike.getText());
		assertEquals("Family tree", perNike.getText());
		
		driver.quit();
	}
	
}	
