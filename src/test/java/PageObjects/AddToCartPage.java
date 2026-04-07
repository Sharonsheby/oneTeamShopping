package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCartPage {
	  // Declare WebDriver instance
    WebDriver driver;

    // Constructor for HomePage class
    public AddToCartPage(WebDriver driver) {
        // Assign the WebDriver passed from the test class to this class's driver
        this.driver = driver;

        // Initialize all @FindBy annotated WebElements in this page using PageFactory
        PageFactory.initElements(driver, this);

}
    // ======= WEB ELEMENTS =======
    

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M256 23c-3')]")
    public WebElement cartIcon;

    @FindBy(xpath = "//div[@class='cart-products']//div[2]//button[1]//*[name()='svg']")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[normalize-space()='Proceed to Buy']")
    public WebElement proceedToBuyButton;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M512 64c24')]")
    public WebElement closeCartButton;
    
 // ======= METHODS =======
    
 // Click cart icon
    public void clickCartIcon() {
        cartIcon.click();
    }

    // Click delete button
    public void clickDeleteButton() {
        deleteButton.click();
    }

    // Proceed to buy
    public void clickProceedToBuy() {
        proceedToBuyButton.click();
    }

    // Close cart modal
    public void clickCloseCartButton() {
        closeCartButton.click();
    }
    


}
