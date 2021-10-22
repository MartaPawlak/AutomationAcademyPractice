package pages;

import helpers.ThreadUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ContinueShopping {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='cart-grid-body col-xs-12 col-lg-8']")
    List<WebElement> buttonsList;

    public ContinueShopping(WebDriver driver) {
        this.driver = driver;
    }

    public void getBackContinueShopping() {
        WebElement continueShoppingButton = null;
        for (WebElement listDetail : buttonsList) {
            List<WebElement> details = listDetail.findElements(By.xpath(".//a"));
            for (WebElement buttonElement : details) {
                if (buttonElement.getText().toLowerCase().contains("Continue shopping".toLowerCase())) {
                    continueShoppingButton = buttonElement;
                    break;
                }
            }
        }
        if (continueShoppingButton != null) {
            continueShoppingButton.click();
        }
    }

    public void checkURLMainPage() {
        ThreadUtil.sleep(TimeUnit.SECONDS, 2);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://autodemo.testoneo.com/en/";
        assertEquals(expectedURL, currentURL);
    }
}
