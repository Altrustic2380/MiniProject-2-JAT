package Util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private static final String SCREENSHOT_PATH = ConfigReader.getProperty("screenshotPath");

    public static void captureScreenshot(WebDriver driver, String filename) {
        try {
            File screenshotDir = new File(SCREENSHOT_PATH);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs(); // Create directory if it doesn't exist
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotDir, filename + "_" + timestamp + ".png");
            FileUtils.copyFile(srcFile, destFile);
            
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Screenshot Error: " + e.getMessage());
        }
    }
}
