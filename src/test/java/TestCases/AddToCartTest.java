package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import PageObjects.AddToCartPage;

public class AddToCartTest extends BaseClass {

    WebDriver driver;
    AddToCartPage cart;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://oneteamshopping.netlify.app/");
        cart = new AddToCartPage(driver);
    }

    @Test
    public void testClickCartIcon() throws InterruptedException, IOException {
        cart.clickCartIcon();
        Thread.sleep(2000); // Let modal load

        try {
            WebElement modal = driver.findElement(
                By.xpath("//div[contains(@class,'modal') or contains(text(),'Your cart is empty')]")
            );

            if (modal.isDisplayed()) {
                System.out.println("Empty cart modal is visible");
                captureScreen("EmptyCartModal");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No empty cart modal detected.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

   
}
