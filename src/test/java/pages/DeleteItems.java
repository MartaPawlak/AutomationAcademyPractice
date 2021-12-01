package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeleteItems {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@class='material-icons float-xs-left']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@class='label js-subtotal']")
    WebElement noItem;

    public DeleteItems(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void deleteItemsFromCart() throws InterruptedException {
        assertTrue(deleteButton.isEnabled());
        deleteButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(noItem, "0 items"));
    }

    public void checkIfIsNoItem(){
        wait.until(ExpectedConditions.visibilityOf(noItem));
        String items = noItem.getText().replace(" items", "");
        int getItemQuantity = Integer.parseInt(items);
        int result = 0;
        assertEquals(result, getItemQuantity);
    }
}
