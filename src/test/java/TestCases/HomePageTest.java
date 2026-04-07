package TestCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.HomePage;

public class HomePageTest extends BaseClass {

    @Test(priority = 1)
    public void verifyLogoIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(home.logo));
        Assert.assertTrue(home.isLogoDisplayed(), "❌ Logo is not displayed.");
    }

    @Test(priority = 2)
    public void getHomeTitleText() {
        Assert.assertTrue(home.homeTitle.isDisplayed(), "❌ Title is not displayed.");
    }

    @Test(priority = 3)
    public void isFilterLabelDisplayed() {
        Assert.assertTrue(home.isFilterLabelDisplayed(), "❌ Filter label is not displayed.");
    }

    @Test(priority = 4)
    public void verifyProductDetails() {
        List<String> names = home.getAllProductNames();
        List<String> prices = home.getAllProductPrices();

        System.out.println("Product names: " + names);
        System.out.println("Product prices: " + prices);

        Assert.assertFalse(names.isEmpty(), "❌ Product name list is empty.");
        boolean containsRs = prices.stream().anyMatch(p -> p.contains("Rs"));
        Assert.assertTrue(containsRs, "❌ Product price does not contain 'Rs'");
    }

    @Test(priority = 5)
    public void addToCartFromImage() throws InterruptedException {
        List<WebElement> addToCartButtons = driver.findElements(
            By.xpath("//div[@class='product']//button[contains(text(),'Add to Cart')]")
        );

        Actions actions = new Actions(driver);

        for (int i = 0; i < addToCartButtons.size(); i++) {
            WebElement product = driver.findElements(By.className("product")).get(i);

            // Scroll and hover to reveal the "Add to Cart" button
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            actions.moveToElement(product).perform();

            Thread.sleep(800); // Small wait

            addToCartButtons.get(i).click();
            System.out.println("✅ Clicked Add to Cart for product #" + (i + 1));
        }
    }
}
