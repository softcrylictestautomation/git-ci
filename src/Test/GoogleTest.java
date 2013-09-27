package Test;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import Actions.GoogleActions;

import com.Softcrylic.demo.testautomation.Base.BaseTest;
import com.Softcrylic.demo.testautomation.Common.ExceptionWriter;
import com.Softcrylic.demo.testautomation.Common.TableLayout;
import com.Softcrylic.demo.testautomation.Common.XLSReader;
import com.Softcrylic.demo.testautomation.DTO.StartUpParameters;
import com.Softcrylic.demo.testautomation.Utilities.JustLogger;
import com.Softcrylic.demo.testautomation.Utilities.LogWriter;

@Test
public class GoogleTest extends BaseTest {
	@org.testng.annotations.DataProvider(name = "DataProvider")
	public Object[][] DataProvider() {
		try {
			JustLogger.logInfo("@DataProvider");
			XLSReader reader = new XLSReader(TableLayout.HORIZONTAL,
					sup.getDataSource());
			JustLogger.logInfo("@Reader Started!");

			Hashtable<String, String> filter = new Hashtable<String, String>();
			filter.put(
					"Browser",
					sup.getBrowser().toLowerCase().contains("safari") ? "safari"
							: sup.getBrowser());

			filter.put("BrowserVersion", sup.getBrowserVersion());
			filter.put("ApplicationToTest", sup.getApplicationToTest());
			reader.setSelection(filter, false);
			Object[][] data = reader.getTableArray("NULL", "NULL");
			if (data == null)
				JustLogger.logInfo("@Data Is Null!");
			return data;
		} catch (Exception e) {
			ExceptionWriter.LogException(e);
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Test(groups = { "GoogleTest" }, testName = "GoogleFinance")
	public void GoogleTest() throws Exception {
		sup.setTestName("GoogleFinanceTest");
		sup.setRecordVideo(true);
		this.startUp("1");
		sup.setTestCaseID(this.getTestCaseId("1", sup.getTestName(),
				sup.getBrowser(), sup.getBrowserVersion()));
		LogWriter logger = new LogWriter();
		logger.addNewSpetialCharactor("^");
		logger.addNewSpetialCharactor("^");
		logger.addNewSpetialCharactor("#");
		logger.addNewSpetialCharactor("°");
		logger.addNewSpetialCharactor("Ãˆï¿¿");
		logger.addNewSpetialCharactor("È");
		logger.addNewSpetialCharactor("É");
		logger.addNewSpetialCharactor("Ô");
		logger.addNewSpetialCharactor("%");
		try {
			GoogleActions GoogleTest = new GoogleActions(
					 driver, sb, logger);

			logger.createTestCase(sup.getTestCaseID(), sup.getTestName() + "_"
					+ sup.getBrowser() + "_" + sup.getBrowserVersion(),
					sup.getTestName() + sup.getBrowser(),
					driver.getCurrentUrl(), sup.getVideoURL(), sup.getBrowser());
			driver = GoogleTest.Google_Test(null);

		} catch (Exception e) {
			ExceptionWriter.LogException(e);
		}
		logger.close(logger.gettestCase(), "GoogleTest");
		try
		{
			driver.quit();
		}
		catch(Exception ignore){}
		if (sb != null)
			Assert.assertEquals(sb.toString(), "");
	}
}
