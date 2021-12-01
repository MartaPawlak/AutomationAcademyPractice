package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.regex.Pattern;
import static org.junit.Assert.*;

public class CheckAddingToCartPopup {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@class='col-md-6']")
    List<WebElement>
            listDetails;

    @FindBy(xpath = "//*[@class='col-md-7']")
    List<WebElement>
            summaryListDetails;


    @FindBy(xpath = "//*[@class='btn btn-primary']")
    WebElement proceed;

    public CheckAddingToCartPopup(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getQuantity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='col-md-5 divide-right']")));
        WebElement quantity = null;
        for (WebElement listDetail : listDetails) {
            List<WebElement> details = listDetail.findElements(By.xpath(".//*"));
            assertNotNull(details);
            for (WebElement webElement : details) {
                if (webElement.getText().toLowerCase().contains("Quantity".toLowerCase())) {
                    quantity = webElement;
                    break;
                }
            }
        }
        String quantityNO = quantity.getText();
        Pattern pattern = Pattern.compile("[^0-9]");
        String quantitynumber = pattern.matcher(quantityNO).replaceAll("");
        return quantitynumber;
    }

    public String getPrice() {
        WebElement priceAndCurrency = null;
        for (WebElement listDetail : listDetails) {
            List<WebElement> details = listDetail.findElements(By.xpath(".//*"));
            for (WebElement priceElement : details) {
                if (priceElement.getText().toLowerCase().contains("PLN".toLowerCase())) {
                    priceAndCurrency = priceElement;
                    break;
                }
            }
        }
        assertTrue(priceAndCurrency.isDisplayed());
        String onlyPrice = priceAndCurrency.getText().replace("PLN", "");
        return onlyPrice;
    }

    public String getTotalPrice() {
        WebElement total = null;
        for (WebElement listDetail : summaryListDetails) {
            List<WebElement> details = listDetail.findElements(By.xpath(".//p"));
            for (WebElement priceElement : details) {
                if (priceElement.getText().toLowerCase().contains("products".toLowerCase())) {
                    total = priceElement;
                    break;
                }
            }
        }
        String totalPrice = total.getText().replace("Total products: PLN", "");
        assertTrue(total.isEnabled());
        return totalPrice;
    }

    public void verifyTotalPrice() {
        String getPrice = getPrice();
        float expectedPrice = Float.parseFloat(getPrice);
        String getQuantity = getQuantity();
        int expectedQuantity = Integer.parseInt(getQuantity);
        String result = getTotalPrice();
        assertEquals(expectedPrice * expectedQuantity, result);

    }
    public void proceedToCheckout() {
        assertTrue(proceed.isEnabled());
        proceed.click();
    }
}