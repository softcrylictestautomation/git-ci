package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Softcrylic.demo.testautomation.Utilities.LogWriter;

public class BaseActions {
	
	
	protected void setWebDriverWaitTime(int Seconds) {
		wait = new WebDriverWait(this.driver, Seconds);
	}
	
	protected ExpectedCondition<WebElement> elementIsDiaplayed(
			final WebElement element) {
		//if (wait == null)
			setWebDriverWaitTime(20);
		return new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver d) {
				if (!element.isDisplayed())
					return null;
				return element;
			}
		};
	}
	
	
	protected StringBuffer sb;
	protected String ExpectedValue;
	protected String Description;
	protected String ActualPass;
	protected String ActualFail;
	protected boolean CaptureScreenShot = true;
	protected WebDriverWait wait;
	protected WebDriver driver;
	protected LogWriter logger;
}
