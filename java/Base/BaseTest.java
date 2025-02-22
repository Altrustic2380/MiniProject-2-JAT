package Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Util.ScreenshotUtil;
import Util.Utils;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        Utils.browserLaunch();  // Launch browser with URL
        driver = Utils.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot if the test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }

        // Capture screenshot after every test for debugging (optional)
        ScreenshotUtil.captureScreenshot(driver, "After_Test_" + result.getName());

        Utils.closeBrowser();  // Close browser after test execution
    }
}
