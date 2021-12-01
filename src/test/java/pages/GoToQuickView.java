package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class GoToQuickView {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(className = "quick-view")
    WebElement quickView;

    @FindBy(xpath = "//*[@class=\"material-icons touchspin-up\"]")
    WebElement quantity;

    @FindBy(xpath = "//*[@class=\"btn btn-primary add-to-cart\"]")
    WebElement addToCart;

    public GoToQuickView(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void showQuickView() {
        Actions show = new Actions(driver);
        show.moveToElement(quickView).build().perform();
        assertTrue(quickView.isDisplayed());
        quickView.click();
    }

    public void addQuantity(int numberOfQuantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"material-icons touchspin-up\"]")));
        for (int quantityNo = 0; quantityNo < numberOfQuantity; quantityNo++) {
            assertTrue(quantity.isEnabled());
            quantity.click();
        }
    }

    public void addToCartButton() {
        assertTrue(addToCart.isDisplayed());
        addToCart.click();
    }
}
