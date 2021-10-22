package pages;

import helpers.ThreadUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class VerifyPageInPolish {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@class = 'language-selector-wrapper']")
    WebElement language;

    @FindBy(xpath = "//*[@class = 'dropdown-menu hidden-sm-down']")
    List<WebElement>
            languageList;

    @FindBy(id = "category-3")
    WebElement clothes;

    @FindBy(id = "category-5")
    WebElement women;

    public VerifyPageInPolish(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void changeToPolishLanguage() {
        language.click();
        ThreadUtil.sleep(TimeUnit.SECONDS, 2);
    }

    public void chooseLanguagePolish() {
        WebElement polishlanguage = null;
        for (WebElement listDetail : languageList) {
            List<WebElement> details = listDetail.findElements(By.tagName("li"));
            for (WebElement detail : details) {
                if (detail.getText().toLowerCase().contains("Polski".toLowerCase())) {
                    polishlanguage = detail;
                    break;
                }
            }
        }
        polishlanguage.click();
    }

    public void moveMouseToClothesSectionInPolish() {
        Actions action = new Actions(driver);
        action.moveToElement(clothes).build().perform();
    }

    public void goToWomenClothesPageInPolish() {
        women.click();
    }

    public void verifyUrlWomenPageInPolish() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://autodemo.testoneo.com/pl/5-women";
        System.out.println("current URL: " + currentURL);
        assertEquals(expectedURL, currentURL);
    }
}
