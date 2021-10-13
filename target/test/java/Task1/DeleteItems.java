package Task1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class DeleteItems {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='material-icons float-xs-left']")
    WebElement deleteButton;

    @FindBy(xpath = "//*[@class='label js-subtotal']")
    WebElement noItem;

    public DeleteItems(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteItemsFromCart() {
        deleteButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkIfIsNoItem(){
        String items = noItem.getText().replace(" items", "");
        int getItemQuantity = Integer.parseInt(items);
        int result = 0;
        assertEquals(getItemQuantity, result);
    }
}
