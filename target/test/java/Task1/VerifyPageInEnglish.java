package Task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class VerifyPageInEnglish {
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

    @FindBy(xpath = "//*[@class='facet clearfix']")
    List<WebElement>
            allClothesSize;

    @FindBy(xpath = "//li[@class='filter-block']")
    WebElement activefilter;


    public VerifyPageInEnglish(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void changeToPolishLanguage() {
        language.click();
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeToEnglish() {
        WebElement englishlanguage = null;
        for (WebElement listDetail : languageList) {
            List<WebElement> details = listDetail.findElements(By.tagName("li"));
            for (WebElement detail : details) {
                if (detail.getText().toLowerCase().contains("English".toLowerCase())) {
                    englishlanguage = detail;
                    break;
                }
            }
        }
        englishlanguage.click();
    }

    public void moveMouseToClothesSection() {
        Actions action = new Actions(driver);
        action.moveToElement(clothes).build().perform();
    }

    public void goToWomenClothesPage() {
        women.click();
    }

    public void verifyUrlWomenPage() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://autodemo.testoneo.com/en/5-women";
        System.out.println("current URL: " + currentURL);
//        wait.until(ExpectedConditions.invisibilityOf(women));
        assertEquals(expectedURL, currentURL);
    }

    public List<String> getList() {
        List<String> sizeList = new ArrayList<>();
        for (WebElement webElement : allClothesSize) {
            sizeList.add(webElement.getText());
        }
        return sizeList;
    }

    public List<WebElement> getSizeElementsList() {
        return allClothesSize.get(0).findElements(By.tagName("li"));
    }

    public List<String> getSizeList() {
        List<String> sizeList = new ArrayList<>();
        for (WebElement element : getSizeElementsList()) {
            sizeList.add(element.getText().substring(0, element.getText().indexOf(" ")));
        }
        return sizeList;
    }

    public void chooseSize() {
        ArrayList<String> expectedSizeList = new ArrayList<String>(Arrays.asList("S", "M", "L", "XL"));
        assertEquals(getSizeList(), expectedSizeList);
        getSizeElementsList().get(1).findElement(By.tagName("a")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkActiveFilters() {
        if (activefilter.isDisplayed() == true) {
            System.out.println("Filtred by " + activefilter.getText());
        }
    }
}

