package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    // Declare WebDriver instance
    WebDriver driver;

    // Constructor for HomePage class
    public HomePage(WebDriver driver) {
        // Assign the WebDriver passed from the test class to this class's driver
        this.driver = driver;

        // Initialize all @FindBy annotated WebElements in this page using PageFactory
        PageFactory.initElements(driver, this);
    }

    // ======= WEB ELEMENTS =======

    // 1. Logo
    @FindBy(xpath = "//img[contains(@alt, 'logo') or contains(@src, 'logo')]")
    public WebElement logo;

    // 2. Add to Cart button
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M256 23c-3')]")
    public WebElement firstAddToCartButton;

    // 3. Title
    @FindBy(xpath = "//h2[normalize-space()='Ear Ring Collections']")
    public WebElement homeTitle;

    // 4. Filter label
    @FindBy(xpath = "//h1[normalize-space()='Filter By Price']")
    public WebElement filterLabel;

    // 5. Product details
    @FindBy(xpath = "(//img[@class='product-image'])")
    public WebElement productImage;

    @FindBy(xpath = "//h4[contains(@class,'product-name')]")
    public List<WebElement> productNames;


    @FindBy(xpath = "//div[@class='product']//span[@class='product-price']")
    public List<WebElement> productPrices;
    
    

    // ======= METHODS =======

    // Check if logo is displayed
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    // Click the first Add to Cart button
    public void clickFirstAddToCart() {
        firstAddToCartButton.click();
    }

    // Get the title text
    public String getHomeTitleText() {
        return homeTitle.getText();
    }

    // Check if filter label is displayed
    public boolean isFilterLabelDisplayed() {
        return filterLabel.isDisplayed();
    }

    // Get product name and price
    public List<String> getAllProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement name : productNames) {
            names.add(name.getText());
        }
        return names;
    }

    public List<String> getAllProductPrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement price : productPrices) {
            prices.add(price.getText());
        }
        return prices;
    }
    
}
