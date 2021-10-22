package pages;

import helpers.ThreadUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
        quickView.click();
        ThreadUtil.sleep(TimeUnit.SECONDS, 2);
    }

    public void addQuantity(int numberOfQuantity) {
        for (int quantityNo = 0; quantityNo < numberOfQuantity; quantityNo++) {
            quantity.click();
        }
        ThreadUtil.sleep(TimeUnit.SECONDS, 2);
    }

    public void addToCartButton() {
        addToCart.click();
        ThreadUtil.sleep(TimeUnit.SECONDS, 2);
    }
}
