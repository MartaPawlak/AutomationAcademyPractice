package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VerifyCart {
    private WebDriver driver;
    private int expectedQuantity = 3;

    @FindBy(xpath = "//*[@class='price']")
    WebElement itemPrice;

    @FindBy(xpath = "//*[@class='js-cart-line-product-quantity form-control']")
    WebElement itemsQuantity;

    @FindBy(xpath = "//*[@class='product-price']")
    WebElement itemsTotalPrice;

    @FindBy(xpath = "//*[@id='cart-subtotal-products']")
    List<WebElement> summaryLine;

    public VerifyCart(WebDriver driver) {
        this.driver = driver;
    }

    public String verifyCartTotalPrice() {
        String totalPrice = itemsTotalPrice.getText().replace("PLN", "");
        return totalPrice;
    }

    public String summaryTotalPrice() {
        WebElement priceTotalSummary = null;
        for (WebElement listDetail : summaryLine) {
            assertTrue(listDetail.isDisplayed());
            List<WebElement> details = listDetail.findElements(By.xpath(".//*"));
            for (WebElement webElement : details) {
                if (webElement.getText().toLowerCase().contains("pln".toLowerCase())) {
                    priceTotalSummary = webElement;
                    break;
                }
            }
        }
        assertTrue(priceTotalSummary.isDisplayed());
        String priceNumber = priceTotalSummary.getText().replace("PLN", "");
        return priceNumber;
    }

    public void verifyTotalPrice() {
        String totalPrice = summaryTotalPrice();
        String result1 = verifyCartTotalPrice();
        assertEquals(totalPrice, result1);

    }
    public void checkItemQuantityTimesItemPrice(){
        String getItemQuantity1 = itemsQuantity.getAttribute("value");
        int getItemQuantity = Integer.parseInt(getItemQuantity1);
        String getItemPrice1 = itemPrice.getText().replace("PLN", "");
        float getItemPrice = Float.parseFloat(getItemPrice1);
        String result = summaryTotalPrice();
        String price = BigDecimal.valueOf(getItemPrice * getItemQuantity).setScale(2, RoundingMode.HALF_UP).toString();
        assertEquals(price, result);
    }

}
