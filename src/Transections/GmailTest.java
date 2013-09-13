package Transections;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Softcrylic.demo.testautomation.Base.BaseTest;
import com.Softcrylic.demo.testautomation.Common.ExceptionWriter;
import com.Softcrylic.demo.testautomation.Utilities.LogWriter;

import Actions.GmailActions;

@Test
public class GmailTest extends BaseTest {

	@Test(groups = { "ParallalRun" }, testName = "GoogleTest")
	public void GoogleTest() throws Exception {
		sup.setTestName("GoogleTest");
		sup.setRecordVideo(true);
		this.startUp("3");
		sup.setTestCaseID(this.getTestCaseId("3", sup.getTestName(),
				sup.getBrowser(), sup.getBrowserVersion()));
		LogWriter logger = new LogWriter();
		try {
			GmailActions ga = new GmailActions(driver,sb,logger);
			logger.createTestCase(sup.getTestCaseID(), sup.getTestName() + "_"
					+ sup.getBrowser() + "_" + sup.getBrowserVersion(),
					sup.getTestName() + sup.getBrowser(),
					driver.getCurrentUrl(), sup.getVideoURL(), sup.getBrowser());
			driver = ga.doGmailTest();
		} catch (Exception e) {
			sb.append(e.getMessage());
			ExceptionWriter.LogException(e);
		}
		logger.close(logger.gettestCase(), "ParallalRun");
		if (sb != null)
			Assert.assertEquals(sb.toString(), "");
	}

}