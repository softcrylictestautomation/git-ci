package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHome {

	
	public static WebElement searchTxtBox(WebDriver driver) {
		return driver.findElement(By.name("q"));
	}
	
	public static WebElement searchBtn(WebDriver driver) {
		return driver.findElement(By.name("btnG"));
	}
	
	public static WebElement googleFinanceLink(WebDriver driver) {
		return driver.findElement(By.linkText("Google Finance"));
	}
	
	public static WebElement chartAnchor(WebDriver driver) {
		return driver.findElement(By.id("chart_anchor"));
	}
	
	public static WebElement moreResultsBtn(WebDriver driver) {
		return driver.findElement(By.cssSelector(".goog-inline-block.jfk-button.jfk-button-action.appbar-more"));
	}
	
	public static WebElement searchTab(WebDriver driver) {
		return driver.findElement(By.className("id-searchform"));
	}
	
	
	
	
	
	
}
