package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import PageObjects.HomePage;

public class BaseClass {

    public static WebDriver driver; // ✅ MAKE STATIC
    HomePage home;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://oneteamshopping.netlify.app/");

        home = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Add Screenshot Method here
    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + testName + "_" + timeStamp + ".png";
        File target = new File(dest);
        src.renameTo(target);
        return dest;
    }
}
