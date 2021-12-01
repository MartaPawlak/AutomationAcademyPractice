package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

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

    public void moveMouseToClothesSection() {
        Actions action = new Actions(driver);
        action.moveToElement(clothes).build().perform();
        assertTrue(clothes.isDisplayed());
    }

    public void goToWomenClothesPage() {
        assertTrue(women.isDisplayed());
        women.click();
    }

    public void verifyUrlWomenPage() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://autodemo.testoneo.com/en/5-women";
        System.out.println("current URL: " + currentURL);
        assertEquals(expectedURL, currentURL);
    }

    public List<String> getList() {
        List<String> sizeList = new ArrayList<>();
        assertTrue(sizeList.isEmpty());
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
        assertTrue(sizeList.isEmpty());
        for (WebElement element : getSizeElementsList()) {
            sizeList.add(element.getText().substring(0, element.getText().indexOf(" ")));
        }
        return sizeList;
    }

    public void chooseSize() {
        ArrayList<String> expectedSizeList = new ArrayList<String>(Arrays.asList("S", "M", "L", "XL"));
        assertEquals(getSizeList(), expectedSizeList);
        getSizeElementsList().get(1).findElement(By.tagName("a")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void checkActiveFilters() {
        if (activefilter.isDisplayed() == true) {
            System.out.println("Filtred by " + activefilter.getText());
        }
    }
}

