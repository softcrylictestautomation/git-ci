package Actions;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.GoogleHome;

import com.Softcrylic.demo.testautomation.Common.ExceptionWriter;
import com.Softcrylic.demo.testautomation.Utilities.JustLogger;
import com.Softcrylic.demo.testautomation.Utilities.LogWriter;

public class GoogleActions extends BaseActions {
	
	public GoogleActions(WebDriver driver, StringBuffer sb, LogWriter logger) {
		this.driver = driver;
		this.logger = logger;
		this.sb = sb;
		
	}

	public WebDriver Google_Test(Hashtable<String, String> data) throws Exception {
		try {
			int StepNo = 1;
			this.Description = "Navigate to Google Home page";
			this.ExpectedValue = "Google home page should be displayed";
			this.ActualPass = "Google home page is displayed";
			this.ActualFail = "Google home page is not displayed";
			try {
				JustLogger.logInfo("Step " + StepNo + " started!");
				try {
					driver.manage().window().maximize();
				} catch (Exception ignore) {
				}
				
				driver.get("https://www.google.com");
				Thread.sleep(1000);
				boolean pageTitle = driver.getPageSource().contains("Google");
				Assert.assertEquals(pageTitle, true);
			
				if (this.CaptureScreenShot)
					logger.captureScreenShot(driver);
				logger.createTestStepWithImage(this.Description,
						this.ExpectedValue,
						this.ActualPass,
						true);
				JustLogger.logInfo("Step " + StepNo + ": Completed!");
			} catch (AssertionError e) {
				logger.captureScreenShot(driver);
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualFail,
						false);
				sb.append(e.getMessage());
				ExceptionWriter.LogException(new Exception(e.getMessage()));
				JustLogger.logError(e.getMessage());
				JustLogger.logError("Step " + StepNo
						+ ": Completed with Assertion Error!");
			}
			
		
			StepNo = 2;
			this.Description = "Search for the keyword 'AAPL' in the text box";
			this.ExpectedValue = "Apple Inc's financial card should be displayed";
			this.ActualPass = "Apple Inc's financial card is displayed";
			this.ActualFail = "Apple Inc's financial card is not displayed";
			try {
				JustLogger.logInfo("Step  " + StepNo + " started!");
				
				WebElement searchBox = GoogleHome.searchTxtBox(driver);
				searchBox.clear(); 
				Thread.sleep(1000);
				searchBox.sendKeys("GOOG");
				WebElement searchButton = GoogleHome.searchBtn(driver);
				searchButton.click();
				Thread.sleep(2000);
				boolean title = driver.getPageSource().contains("NASDAQ:GOOG");
				Assert.assertEquals(true, title);

				if (this.CaptureScreenShot)
					logger.captureScreenShot(driver); 
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualPass,
						true);
				JustLogger.logInfo("Step " + StepNo + ": Completed!");
			} catch (AssertionError e) {
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualFail,
						false);
				sb.append(e.getMessage());
				ExceptionWriter.LogException(new Exception(e.getMessage()));
				JustLogger.logError(e.getMessage());
				JustLogger.logError("Step " + StepNo
						+ ": Completed with Assertion Error!");
			}
		
			StepNo = 3;
			this.Description = "Click on the Google Finance option at the bottom of the financial card ";
			this.ExpectedValue = "Ensure the Google Finance chart is loaded. ";
			this.ActualPass = "Google Finance Chart is loaded ";
			this.ActualFail = "Google Finance Chart is not loaded";
			try {
				JustLogger.logInfo("Step  " + StepNo + " started!");
				//Clicking on Google Finance Link 
				GoogleHome.googleFinanceLink(driver).click();
				Thread.sleep(4000);
				boolean financeChart = driver.getPageSource().contains("NASDAQ real-time data");
				Assert.assertEquals(financeChart, true);
				if (this.CaptureScreenShot)
					logger.captureScreenShot(driver);
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualPass,
						true);
				JustLogger.logInfo("Step " + StepNo + ": Completed!");
			} catch (AssertionError e) {
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualFail,
						false);
				sb.append(e.getMessage());
				ExceptionWriter.LogException(new Exception(e.getMessage()));
				JustLogger.logError(e.getMessage());
				JustLogger.logError("Step " + StepNo
						+ ": Completed with Assertion Error!");
			}
			StepNo = 4;
			this.Description = "Click on more results";
			this.ExpectedValue = "Results page for Apple Inc company should be displayed";
			this.ActualPass = "Results page for Apple Inc company is displayed";
			this.ActualFail = "Results page for Apple Inc company is not displayed";
			try {
				JustLogger.logInfo("Step  " + StepNo + " started!");
				//Clicking on more results button
				GoogleHome.moreResultsBtn(driver).click();
				Thread.sleep(2000);
				GoogleHome.searchTab(driver).isDisplayed();
				if (this.CaptureScreenShot)
					logger.captureScreenShot(driver);
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualPass,
						true);
				JustLogger.logInfo("Step " + StepNo + ": Completed!");
			} catch (AssertionError e) {
				logger.createTestStepWithImage(
						this.Description,
						this.ExpectedValue,
						this.ActualFail,
						false);
				sb.append(e.getMessage());
				ExceptionWriter.LogException(new Exception(e.getMessage()));
				JustLogger.logError(e.getMessage());
				JustLogger.logError("Step " + StepNo
						+ ": Completed with Assertion Error!");
			}
		
	
		}
		catch (Exception e) {
			logger.createTestStepWithImage("Click on Search button", "Sucess",
					"failed", false);
			sb.append(e.getMessage());
		}
		return driver;
}
}
