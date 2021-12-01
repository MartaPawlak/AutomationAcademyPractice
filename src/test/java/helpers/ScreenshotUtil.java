package helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File path = new File(System.getProperty("user.dir") + "/test-screenshots/");
            if (!path.exists()) {
                path.mkdirs();
            }
            FileHandler.copy(source, new File(System.getProperty("user.dir") + "/test-screenshots/" + name + ".png"));
            System.out.println("Screenshot taken");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

}
